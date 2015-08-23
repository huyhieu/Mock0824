package com.viettel.data.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.viettel.data.model.entity.MockApiBody;
import com.viettel.data.query.MockApiBodyQuery;
import com.viettel.util.HibernateUtil;

public class MockApiBodyDAO {

	public static MockApiBodyDAO instance = null;

	private MockApiBodyDAO() {

	}

	public static MockApiBodyDAO getInstance() {
		if (instance == null) {
			instance = new MockApiBodyDAO();
		}
		return instance;
	}

	/**
	 * @return
	 */
	public Long getNextIndex() {
		Long index = 0L;
		try {
			index = HibernateUtil.getSequence("MOCK_API_BODY_SEQ");
		} catch (Exception e) {
			index = -1L;
		}
		return index;
	}
	
	@SuppressWarnings("unchecked")
	public List<MockApiBody> getApiBodyByMockId(Long mockId) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session.getNamedQuery(MockApiBodyQuery.GET_API_BODY_BY_MOCK_ID_NAME);
		query.setParameter("mockid", mockId);
		List<MockApiBody> lstAccount = query.list();
		session.close();
		if (lstAccount.isEmpty())
			return null;
		return lstAccount;
	}

}
