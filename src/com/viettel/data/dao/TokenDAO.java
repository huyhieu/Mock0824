package com.viettel.data.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.viettel.data.model.entity.MockToken;
import com.viettel.data.query.TokenQuery;
import com.viettel.util.HibernateUtil;
import com.viettel.util.LogUtils;
import com.viettel.util.StringUtil;

public class TokenDAO {
	private static final String TAG = TokenDAO.class.getSimpleName();

	public static TokenDAO instance = null;

	private Session getSession() {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		return session;
	}

	private TokenDAO() {
	}

	public static TokenDAO getInstance() {
		if (instance == null) {
			instance = new TokenDAO();
		}
		return instance;
	}

	public Long getNextIndex() {
		Long index = 0L;
		try {
			index = HibernateUtil.getSequence("MOCK_TOKEN_SEQ");
		} catch (Exception e) {
			index = -1L;
		}
		return index;
	}

	public String creatFullServerToken(String shortToken) {
		
		return "";
	}

	public MockToken createNewToken(Long userId) {

		String tokenString = StringUtil.getRandomTokenString();
		String fullTokenString = creatFullServerToken(tokenString);
		Long startTime = com.viettel.util.DateUtils.getInstance().getCurrentTime();

		MockToken token = new MockToken();
		token.setTokenString(tokenString);
		token.setUserId(userId);
		token.setStartTime(startTime);
		token.setFullTokenString(fullTokenString);
		token.setTokenId(getNextIndex());
		LogUtils.d(TAG, "Successfully creating token.");
		return token;
	}
	
	public boolean insertToken(MockToken token) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(token);
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

	public boolean updateToken(MockToken token) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(token);
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
	 * @param userId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public MockToken getTokenByUserID(Long userId) {
		Query query = getSession().getNamedQuery(TokenQuery.GET_TOKEN_BY_USER_ID_NAME);
		query.setParameter("userId", userId);
		List<MockToken> lstToken = query.list();
		if (lstToken.isEmpty()) {
			return null;
		}
		return lstToken.get(0);
	}

	/**
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<MockToken> getAllToken() {
		Query query = getSession().getNamedQuery(TokenQuery.GET_ALL_TOKEN_NAME);
		List<MockToken> lstToken = query.list();
		return lstToken;
	}

	/**
	 * @param token
	 * @return
	 */
	public boolean deleteToken(MockToken token) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.delete(token);
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
	 * @param userId
	 * @return
	 */
	public boolean removeTokenByUserId(Long userId) {
		try {
			Query query = getSession().createSQLQuery(TokenQuery.REMOVE_TOKEN_BY_USER_ID);
			query.setParameter("userId", userId);
			query.executeUpdate();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
