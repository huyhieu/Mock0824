package com.viettel.data.query;

/**
 * @author hieunq5
 * 
 */
public class MockApiBodyQuery {
	public static final String REMOVE_HEADER_BY_MOCK_ID = "{Call mock_remove_header_by_mock_id(:mockId)}";

	public static final String GET_API_BODY_BY_MOCK_ID_NAME = "mock_get_api_body_by_mock_id";
	public static final String GET_API_BODY_BY_MOCK_ID_QUERY= "{? = call mock_get_api_body_by_mock_id(:mockid)}";
}
