package com.viettel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.viettel.data.dao.MockUserDAO;
import com.viettel.data.model.entity.MockUser;
import com.viettel.data.model.form.LoginForm;
import com.viettel.util.EncriptUtils;
import com.viettel.util.LogUtils;

@Controller
@SessionAttributes
public class LoginController {

	// cach 2 dung method get
	@RequestMapping("/pageLogin")
	public ModelAndView showContacts() {
		return new ModelAndView("login", "command", new LoginForm());
	}

	// cach 2 dung method post
	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
	public String doLogin(@ModelAttribute("login") LoginForm loginForm, ModelMap model, BindingResult result) {

		LogUtils.d("login", loginForm.getEmail());
		LogUtils.d("login", loginForm.getPassword());

		if (loginForm.getEmail() == null || loginForm.getEmail().equals("")) {
			LogUtils.d("login", "email_password");
			LogUtils.d("login", "login_fail");
			return "hello";
		}

		if (loginForm.getPassword() == null || loginForm.getPassword().equals("")) {
			LogUtils.d("login", "invalid_password");
			LogUtils.d("login", "login_fail");
			return "hello";
		}

		loginForm.setEmail(loginForm.getEmail().trim().toLowerCase());

		MockUser account = null;
		try {
			// Encript password
			String encriptedPass = EncriptUtils.encriptSHA(loginForm.getPassword() + loginForm.getEmail());
			account = MockUserDAO.getInstance().loginUser(loginForm.getEmail(), encriptedPass);

			if (account == null) {
				LogUtils.d("login", "account == null => login_fail");
				return "hello";
			} else {
				LogUtils.d("login", "login_success");
				model.addAttribute("user", account);
				model.addAttribute("auther", account.getUserEmail() + "login success");
				
				return "hello";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "hello";
		}
	}

}
