package com.viettel.data.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.viettel.data.model.entity.MockUser;
import com.viettel.data.query.MockUserQuery;
import com.viettel.util.HibernateUtil;

/**
 * 
 * @author hieuph
 * 
 */

public class MockUserDAO {

	public static MockUserDAO instance = null;

	private MockUserDAO() {

	}

	public static MockUserDAO getInstance() {
		if (instance == null) {
			instance = new MockUserDAO();
		}
		return instance;
	}

	public Long getNextIndex() {
		Long index = 0L;
		try {
			index = HibernateUtil.getSequence("MOCK_USER_SEQ");
		} catch (Exception e) {
			index = -1L;
		}
		return index;
	}

	/**
	 * @return list of user accounts from database
	 */
	@SuppressWarnings("unchecked")
	public List<MockUser> getAllUserAccount() {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session.getNamedQuery(MockUserQuery.GET_ALL_USERS_NAME);
		List<MockUser> lstAccount = query.list();
		session.close();
		return lstAccount;
	}

	/**
	 * @param email
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public MockUser getUserByEmail(String email) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session.getNamedQuery(MockUserQuery.GET_USER_BY_EMAIL_NAME);
		query.setParameter("email", email);
		List<MockUser> lstAccount = query.list();
		session.close();
		if (lstAccount.isEmpty())
			return null;
		return lstAccount.get(0);
	}

	/**
	 * @param userId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public MockUser getUserByUserId(Long userId) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session.getNamedQuery(MockUserQuery.GET_USER_BY_ID_NAME);
		query.setParameter("userId", userId);
		List<MockUser> lstAccount = query.list();
		session.close();
		if (lstAccount.isEmpty())
			return null;
		return lstAccount.get(0);
	}

	/**
	 * @param email
	 * @param password
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public MockUser loginUser(String email, String password) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session.getNamedQuery(MockUserQuery.LOGIN_USER_NAME);
		query.setParameter("email", email);
		query.setParameter("password", password);
		List<MockUser> lstAccount = query.list();
		session.close();
		if (lstAccount.isEmpty()) {
			return null;
		}
		return lstAccount.get(0);
	}
	
	/**
	 * 
	 * @param email
	 * @param newPassword
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public MockUser loginUserNewPassword(String email, String newPassword) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session.getNamedQuery(MockUserQuery.LOGIN_USER_NAME_NEW_PASS_NAME);
		query.setParameter("email", email);
		query.setParameter("password", newPassword);
		List<MockUser> lstAccount = query.list();
		session.close();
		if (lstAccount.isEmpty()) {
			return null;
		}
		return lstAccount.get(0);
	}

	/**
	 * @param account
	 * @return
	 */
	public boolean updateAccount(MockUser stUser) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(stUser);
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
	 * @param account
	 * @return
	 */
	public boolean removeUserAccount(MockUser account) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		try {
			session.delete(account);
		} catch (Exception e) {
			return false;
		} finally {
			session.close();
		}
		return true;
	}

	public boolean insertUser(MockUser stUser) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(stUser);
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
