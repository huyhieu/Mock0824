package com.viettel.data.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import com.viettel.data.query.MockApiBodyQuery;
import com.viettel.util.HibernateUtil;

public class MockApiHeaderDAO {

	public static MockApiHeaderDAO instance = null;

	private MockApiHeaderDAO() {

	}

	public static MockApiHeaderDAO getInstance() {
		if (instance == null) {
			instance = new MockApiHeaderDAO();
		}
		return instance;
	}

	/**
	 * @return
	 */
	public Long getNextIndex() {
		Long index = 0L;
		try {
			index = HibernateUtil.getSequence("MOCK_API_HEADER_SEQ");
		} catch (Exception e) {
			index = -1L;
		}
		return index;
	}

	/**
	 * @param mockId
	 * @return
	 */
	public boolean deleteApiHeaderByMockId(Long mockId) {
		boolean result = true;
		try {
			Session session = HibernateUtil.getSession();
			session.beginTransaction();
			Query query = session.createSQLQuery(MockApiBodyQuery.REMOVE_HEADER_BY_MOCK_ID);
			query.setParameter("mockId", mockId);
			query.executeUpdate();
			session.close();
		} catch (Exception e) {
			result = false;
		}
		return result;
	}
}
