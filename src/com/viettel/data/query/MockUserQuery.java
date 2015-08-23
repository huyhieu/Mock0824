package com.viettel.data.query;

/**
 * @author hieunq5
 * 
 */
public class MockUserQuery {

	public static final String GET_USER_BY_EMAIL_NAME = "mock_get_user_by_email";
	public static final String GET_USER_BY_EMAIL = "{? =  call mock_get_user_by_email(:email) }";

	public static final String GET_ALL_USERS_NAME = "mock_get_all_user";
	public static final String GET_ALL_USERS = "{? =  call mock_get_all_user() }";

	public static final String GET_USER_BY_ID_NAME = "mock_get_user_by_userid";
	public static final String GET_USER_BY_ID = "{? =  call mock_get_user_by_userid(:userId) }";

	public static final String LOGIN_USER_NAME = "mock_login_user";
	public static final String LOGIN_USER = "{? =  call mock_login_user(:email, :password) }";
	
	public static final String LOGIN_USER_NAME_NEW_PASS_NAME = "mock_login_user_new_pass";
	public static final String LOGIN_USER_NAME_NEW_PASS_QUERY = "{? =  call mock_login_user_new_pass(:email, :password) }";

}
