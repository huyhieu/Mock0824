package com.viettel.data.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.viettel.data.model.entity.MockApi;
import com.viettel.data.query.MockApiQuery;
import com.viettel.util.HibernateUtil;

public class MockApiDAO {

	public static MockApiDAO instance = null;

	private MockApiDAO() {

	}

	public static MockApiDAO getInstance() {
		if (instance == null) {
			instance = new MockApiDAO();
		}
		return instance;
	}

	/**
	 * @return
	 */
	public Long getNextIndex() {
		Long index = 0L;
		try {
			index = HibernateUtil.getSequence("MOCK_API_SEQ");
		} catch (Exception e) {
			index = -1L;
		}
		return index;
	}

	/**
	 * @param userId
	 * @return list project owned by this user
	 */
	@SuppressWarnings("unchecked")
	public List<MockApi> getAllApi() {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		List<MockApi> apis = session.createQuery("FROM MockApi").list();
		session.close();
		return apis;
	}

	@SuppressWarnings("unchecked")
	public List<MockApi> getMockApiByUserId(Long userId) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session.getNamedQuery(MockApiQuery.GET_ALL_API_BY_USER_ID_NAME);
		query.setParameter("userId", userId);
		List<MockApi> list = query.list();
		session.close();
		if (list.isEmpty()) {
			return null;
		} else {
			return list;
		}
	}

	@SuppressWarnings("unchecked")
	public MockApi getMockApiByName(Long userId, Long parentId, String apiName, Long nodeType) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session.getNamedQuery(MockApiQuery.GET_API_BY_NAME_NAME);
		query.setParameter("userId", userId);
		query.setParameter("parentId", parentId);
		query.setParameter("apiName", apiName);
		query.setParameter("nodeType", nodeType);
		List<MockApi> api = query.list();
		session.close();
		if (api.isEmpty()) {
			return null;
		} else {
			return api.get(0);
		}
	}

	/**
	 * @return
	 */
	public boolean deleteMockApi(Long apiId) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		try {
			MockApi api = (MockApi) session.get(MockApi.class, apiId);
			session.delete(api);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return false;
		} finally {
			session.close();
		}
		return true;
	}

	public boolean deleteMockApi(MockApi api) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		try {
			session.delete(api);
		} catch (Exception e) {
			return false;
		} finally {
			session.close();
		}
		return true;
	}

	public boolean updateMockApi(MockApi api) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(api);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return false;
		} finally {
			session.close();
		}
		return true;
	}

	public boolean addMockApi(MockApi api) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(api);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return false;
		} finally {
			session.close();
		}
		return true;
	}

	public boolean saveOrUpdate(MockApi api) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.saveOrUpdate(api);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return false;
		} finally {
			session.close();
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public MockApi getMockApiByNameUrl(String nameUrl) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session.getNamedQuery(MockApiQuery.GET_API_BY_NAME_URL_NAME);
		query.setParameter("nameurl", nameUrl);
		List<MockApi> list = query.list();
		session.close();
		if (list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}
	}
}
