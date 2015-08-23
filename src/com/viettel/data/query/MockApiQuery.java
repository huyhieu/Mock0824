package com.viettel.data.query;

/**
 * @author hieunq5
 * 
 */
public class MockApiQuery {

	public static final String GET_ALL_API_BY_USER_ID_NAME = "mock_get_api_by_user_id";
	public static final String GET_ALL_API_BY_USER_ID = "{? =  call mock_get_api_by_user_id(:userId) }";

	public static final String GET_API_BY_NAME_NAME = "mock_get_api_by_name";
	public static final String GET_API_BY_NAME = "{? =  call mock_get_api_by_name(:userId, :parentId, :apiName, :nodeType) }";

	public static final String GET_API_BY_NAME_URL_NAME= "mock_get_api_by_name_url";
	public static final String GET_API_BY_NAME_URL_QUERY= "{? =  call mock_get_api_by_name_url(:nameurl) }";
}
