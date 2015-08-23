package com.viettel.controller;

import globaldefine.EmailConfig;
import globaldefine.GlobalConst;
import globaldefine.GlobalKeyMessage;
import globaldefine.GlobalMessage;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.viettel.data.dao.MockUserDAO;
import com.viettel.data.dao.TokenDAO;
import com.viettel.data.model.entity.MockToken;
import com.viettel.data.model.entity.MockUser;
import com.viettel.data.model.form.UserInfoForm;
import com.viettel.util.DateUtils;
import com.viettel.util.EncriptUtils;
import com.viettel.util.LogUtils;
import com.viettel.util.SSLEmail;
import com.viettel.util.StringUtil;

@Controller
public class AuthenticationController {
	private static final String TAG = AuthenticationController.class.getSimpleName();

	@RequestMapping("/register")
	public ModelAndView showRegister(UserInfoForm userInfoForm) {
		LogUtils.d("registerform", "");

		return new ModelAndView("register", "command", userInfoForm);
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("UserInfoForm") UserInfoForm userInfoForm, ModelMap model, HttpSession session) {
		LogUtils.d(TAG, "adduser");

		// kiem tra email ton tai
		MockUser userByEmail = MockUserDAO.getInstance().getUserByEmail(userInfoForm.getUserEmail());
		if (userByEmail != null) {
			model.addAttribute(GlobalKeyMessage.KEY_EMAIL_IS_EXIST, GlobalMessage.MSG_EMAIL_IS_EXIST);
			// yeu cau nhap lai ngay sinh
			userInfoForm.setUserDOB(null);
			return new ModelAndView("register", "command", userInfoForm);
		}

		String activeCode = StringUtil.getRandomString(30);
		Date dateCreated = DateUtils.getInstance().getCurrentDate();

		MockUser userAccount = new MockUser();
		userAccount.setUserId(MockUserDAO.getInstance().getNextIndex());
		userAccount.setUserName(userInfoForm.getUserFullName());
		userAccount.setUserBirthday(userInfoForm.getUserDOB());
		userAccount.setUserEmail(userInfoForm.getUserEmail());
		userAccount.setUserPassword(EncriptUtils.encriptSHA(userInfoForm.getUserPassword() + userInfoForm.getUserEmail()));
		userAccount.setUserActiveCode(activeCode);
		// userAccount.setUserSex(user_sex);
		userAccount.setUserIsactive(0L); // unactive
		userAccount.setUserRegistTime(dateCreated);
		userAccount.setRoleUserId(GlobalConst.ROLE_USER);

		boolean isRegistered = MockUserDAO.getInstance().insertUser(userAccount);
		// Check two people do register at one time
		if (!isRegistered) {
			// return "redirect:login.html";
			model.addAttribute(GlobalKeyMessage.KEY_ADD_USER_FAIL, GlobalMessage.MSG_UNKNOWN_ERROR_OCCURRED);
			return new ModelAndView("register", "command", userInfoForm);
		}

		SSLEmail.sendEmailHtml(EmailConfig.CONTENT_CREATED_ACCOUNT_SUCCESSFULLY_1 +
				EmailConfig.CONTENT_CREATED_ACCOUNT_SUCCESSFULLY_2 + EmailConfig.ip_contact +
				EmailConfig.CONTENT_CREATED_ACCOUNT_SUCCESSFULLY_3 + userInfoForm.getUserEmail() +
				EmailConfig.CONTENT_CREATED_ACCOUNT_SUCCESSFULLY_4 + activeCode +
				EmailConfig.CONTENT_CREATED_ACCOUNT_SUCCESSFULLY_5,
				userInfoForm.getUserEmail(), EmailConfig.SUBJECT_CREATED_ACCOUNT_SUCCESSFULLY);

		return new ModelAndView("VerifySuccessPage", GlobalKeyMessage.KEY_ANNOUCEMENT, GlobalMessage.MSG_CREATE_ACCOUNT_SUCCESSFUL);
	}

	@RequestMapping("/login")
	public ModelAndView showLogin(UserInfoForm userInfoForm) {
		LogUtils.d("login", "/login");

		return new ModelAndView("login", "command", userInfoForm);
	}

	@RequestMapping(value = "/dologin", method = RequestMethod.POST)
	public ModelAndView dologin(@ModelAttribute("UserInfoForm") UserInfoForm userInfoForm, ModelMap model, HttpSession session) {/*
		// Validate thong tin dang nhap
		if (userInfoForm.getUserEmail() == null) {
			model.addAttribute(GlobalKeyMessage.KEY_LOGIN_FAIL, GlobalMessage.MSG_EMAIL_REQUIRED);
			return showLogin(userInfoForm);
		}
		if (userInfoForm.getUserPassword() == null) {
			model.addAttribute(GlobalKeyMessage.KEY_LOGIN_FAIL, GlobalMessage.MSG_PASSWORD_REQUIRED);
			return showLogin(userInfoForm);
		}

		MockUser stUser = MockUserDAO.getInstance().getUserByEmail(userInfoForm.getUserEmail());
		// kiem tra du lieu db
		if (stUser == null) {
			model.addAttribute(GlobalKeyMessage.KEY_LOGIN_FAIL, GlobalMessage.MSG_EMAIL_PASSWORD_INCORRECT);
			return showLogin(userInfoForm);
		}

		// kiem tra mat khau
		String currentPass = EncriptUtils.encriptSHA(userInfoForm.getUserPassword() + userInfoForm.getUserEmail());

		MockUser account = null;
		// kiem tra ton tai mat khau moi
		if (stUser.getUserNewPassword() != null) {
			// neu login bang mat khau moi thi tien hanh kich hoat mat khau moi
			account = MockUserDAO.getInstance().loginUserNewPassword(userInfoForm.getUserEmail(), currentPass);
			if (account != null) {
				// cap nhat mat khau moi
				account.setUserPassword(account.getUserNewPassword());

				if (!updateChangePassword(account, model, true)) {
					// thong bao xay ra loi khi update thong tin that bai
					model.addAttribute(GlobalKeyMessage.KEY_LOGIN_FAIL, GlobalMessage.MSG_UNKNOWN_ERROR_OCCURRED);
					return showLogin(new UserInfoForm());
				}
			} else {
				account = MockUserDAO.getInstance().loginUser(userInfoForm.getUserEmail(), currentPass);
				if (account != null) {

					if (!updateChangePassword(account, model, false)) {
						// thong bao xay ra loi khi update thong tin that bai
						model.addAttribute(GlobalKeyMessage.KEY_LOGIN_FAIL, GlobalMessage.MSG_UNKNOWN_ERROR_OCCURRED);
						return showLogin(new UserInfoForm());
					}
				} else {
					model.addAttribute(GlobalKeyMessage.KEY_LOGIN_FAIL, GlobalMessage.MSG_EMAIL_PASSWORD_INCORRECT);
					return showLogin(userInfoForm);
				}
			}
		}
		else {
			// truong hop khong co mat khau moi
			account = MockUserDAO.getInstance().loginUser(userInfoForm.getUserEmail(), currentPass);

			if (account == null) {
				model.addAttribute(GlobalKeyMessage.KEY_LOGIN_FAIL, GlobalMessage.MSG_EMAIL_PASSWORD_INCORRECT);
				return showLogin(userInfoForm);
			}
		}

		// kiem tra xac thuc email
		if (account.getUserActiveCode() != null) {
			model.addAttribute(GlobalKeyMessage.KEY_LOGIN_FAIL, GlobalMessage.MSG_EMAIL_UNCONFIRMED);
			return showLogin(userInfoForm);
		}

		MockToken serverToken = TokenDAO.getInstance().getTokenByUserID(account.getUserId());
		MockToken token = TokenDAO.getInstance().createNewToken(account.getUserId());
		if (serverToken != null) { // If existed token - then update this token
			serverToken.setTokenString(token.getTokenString());
			serverToken.setStartTime(token.getStartTime());
			serverToken.setFullTokenString(token.getFullTokenString());
			serverToken.setTokenId(TokenDAO.getInstance().getNextIndex());
			TokenDAO.getInstance().updateToken(serverToken);
		} else { // If token is new - then insert into database
			TokenDAO.getInstance().insertToken(token);
		}

		session.setAttribute(GlobalKeyMessage.KEY_USER_ID, account.getUserId());
		// save session token key
		return new ModelAndView("home", GlobalKeyMessage.KEY_USER_ID, account.getUserId());*/
		return new ModelAndView("home");
	}

	private boolean updateChangePassword(MockUser mockUser, ModelMap model, boolean isNewPass) {
		// xoa thong tin truong new password
		mockUser.setUserNewPassword(null);

		boolean isUpdate = MockUserDAO.getInstance().updateAccount(mockUser);
		if (isUpdate) {
			String contentEmail = "";
			if (isNewPass) {
				contentEmail = EmailConfig.CONTENT_CONFIRM_PASSWORD_CHANGES_1 + mockUser.getUserDateChangePass() + EmailConfig.CONTENT_CONFIRM_PASSWORD_CHANGES_2;
			}
			else {
				contentEmail = EmailConfig.CONTENT_CONFIRM_PASSWORD_CHANGES_1 + mockUser.getUserDateChangePass() + EmailConfig.CONTENT_CONFIRM_PASSWORD_CHANGES_3;
			}
			// gui email thong bao da thay doi mat khau thanh cong
			SSLEmail.sendEmailHtml(contentEmail, mockUser.getUserEmail(), EmailConfig.SUBJECT_CONFIRM_PASSWORD_CHANGES);
			return true;
		}
		else {
			// thong bao xay ra loi khi update thong tin that bai
			return false;
		}
	}

	@RequestMapping("/forgotPassword")
	public ModelAndView showForgotPassword(UserInfoForm userInfoForm) {
		LogUtils.d("forgotPassword", "/forgotPassword");
		return new ModelAndView("forgotPassword", "command", userInfoForm);
	}

	@RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
	public ModelAndView resetPassword(@ModelAttribute("UserInfoForm") UserInfoForm userInfoForm, ModelMap model, BindingResult result) {
		// kiem tra thong tin yeu cau
		if (userInfoForm.getUserEmail() == null) {
			model.addAttribute(GlobalKeyMessage.KEY_ANNOUCEMENT, GlobalMessage.MSG_FIELD_REQUIRED);
			return new ModelAndView("forgotPassword", "command", userInfoForm);
		}

		MockUser mockUser = MockUserDAO.getInstance().getUserByEmail(userInfoForm.getUserEmail());
		if (mockUser == null) {
			model.addAttribute(GlobalKeyMessage.KEY_ANNOUCEMENT, GlobalMessage.MSG_EMAIL_IS_EXIST);
			return new ModelAndView("forgotPassword", "command", userInfoForm);
		}

		// tao mat khau moi
		String newPassword = StringUtil.getNewPassword(10);
		String newPasswordDB = newPassword + mockUser.getUserEmail();
		mockUser.setUserDateChangePass(DateUtils.getInstance().getCurrentDate());
		mockUser.setUserNewPassword(EncriptUtils.encriptSHA(newPasswordDB));
		boolean isUpdateUser = MockUserDAO.getInstance().updateAccount(mockUser);
		if (!isUpdateUser) {
			model.addAttribute(GlobalKeyMessage.KEY_ANNOUCEMENT, GlobalMessage.MSG_RESET_PASSWORD_FAIL);
			return new ModelAndView("forgotPassword", "command", userInfoForm);
		}
		SSLEmail.sendEmailHtml(EmailConfig.CONTENT_RESETPASSWORD + newPassword, mockUser.getUserEmail(), EmailConfig.HEADER_SUBJECT + "Vmock reset password");

		return new ModelAndView("VerifySuccessPage", GlobalKeyMessage.KEY_ANNOUCEMENT, GlobalMessage.MSG_SUCCESSFUL_PASSWORD_CHANGE);
	}

	@RequestMapping("/VerifyPage")
	public ModelAndView showVerifyPage() {
		LogUtils.d("VerifySuccessPage", "/VerifySuccessPage");

		return new ModelAndView("VerifySuccessPage");
	}

	@RequestMapping(value = "/verifyEmail", method = RequestMethod.GET)
	public ModelAndView verifyEmail(@RequestParam("email") String email, @RequestParam("activeCode") String activeCode) {
		MockUser stUser = MockUserDAO.getInstance().getUserByEmail(email);
		if (stUser.getUserActiveCode() != null)
			if (stUser.getUserActiveCode().equals(activeCode)) {
				// thuc hien xoa active code
				stUser.setUserActiveCode(null);
				boolean isUpdateUser = MockUserDAO.getInstance().updateAccount(stUser);
				if (isUpdateUser) {
					return new ModelAndView("VerifySuccessPage", GlobalKeyMessage.KEY_ANNOUCEMENT, GlobalMessage.MSG_ACCOUNT_ACTIVATION_SUCCESSFUL);
				}
			}

		return new ModelAndView("VerifyErrorPage", GlobalKeyMessage.KEY_ANNOUCEMENT, GlobalMessage.MSG_ACCOUNT_ACTIVATION_FAIL);
	}

}