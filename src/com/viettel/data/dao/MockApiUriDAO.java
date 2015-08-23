package com.viettel.data.dao;

import com.viettel.util.HibernateUtil;

public class MockApiUriDAO {

	public static MockApiUriDAO instance = null;

	private MockApiUriDAO() {

	}

	public static MockApiUriDAO getInstance() {
		if (instance == null) {
			instance = new MockApiUriDAO();
		}
		return instance;
	}

	/**
	 * @return
	 */
	public Long getNextIndex() {
		Long index = 0L;
		try {
			index = HibernateUtil.getSequence("MOCK_API_URI_SEQ");
		} catch (Exception e) {
			index = -1L;
		}
		return index;
	}

}
