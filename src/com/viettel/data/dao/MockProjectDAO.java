package com.viettel.data.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.viettel.data.model.entity.MockProject;
import com.viettel.util.HibernateUtil;

public class MockProjectDAO {

	public static MockProjectDAO instance = null;

	private MockProjectDAO() {

	}

	public static MockProjectDAO getInstance() {
		if (instance == null) {
			instance = new MockProjectDAO();
		}
		return instance;
	}

	/**
	 * @return
	 */
	public Long getNextIndex() {
		Long index = 0L;
		try {
			index = HibernateUtil.getSequence("MOCK_PROJECT_SEQ");
		} catch (Exception e) {
			index = -1L;
		}
		return index;
	}

	/**
	 * @param project
	 * @return true if updatign successfully, else return false
	 */
	public boolean updateProject(MockProject project) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(project);
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

	/**
	 * @param project
	 * @return true if removing successfully, else return false
	 */
	public boolean removeProject(MockProject project) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		try {
			session.delete(project);
		} catch (Exception e) {
			return false;
		} finally {
			session.close();
		}
		return true;
	}

	/**
	 * @param project
	 * @return true if adding successfully, else return false
	 */
	public boolean addProject(MockProject project) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(project);
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
}
