package com.viettel.data.model.form;

import java.util.Date;

public class UserInfoForm {

	private String userFullName;
	private String userEmail;
	private String userPassword;
	private String userCPassword;
	private Date userDOB;
	private String error;

	public String getUserFullName() {
		return userFullName;
	}

	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserCPassword() {
		return userCPassword;
	}

	public void setUserCPassword(String userCPassword) {
		this.userCPassword = userCPassword;
	}

	public Date getUserDOB() {
		return userDOB;
	}

	public void setUserDOB(Date userDOB) {
		this.userDOB = userDOB;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
}
