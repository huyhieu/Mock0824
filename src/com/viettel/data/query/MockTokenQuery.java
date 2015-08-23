package com.viettel.data.query;

/**
 * @author hieunq5
 *
 */
public class MockTokenQuery {

	public static final String GET_ALL_TOKEN_NAME = "fn_get_all_token";
	public static final String GET_ALL_TOKEN = "{? = call mock_get_all_token()}"; // OK

	public static final String GET_TOKEN_BY_USER_ID_NAME = "get_token_by_userid";
	public static final String GET_TOKEN_BY_USER_ID_QUERY = "{? = call mock_get_token_by_userid(:userId)}"; // OK

}
