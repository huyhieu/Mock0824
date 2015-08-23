package com.viettel.util;

import java.math.BigDecimal;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.type.DateType;

/**
 * 
 * @author hieuph
 * 
 */
public class HibernateUtil {

	private static SessionFactory sessionFactory = buildSessionFactory();

	public static Session getSession() throws HibernateException {
		Session session = sessionFactory.openSession();
		// session.beginTransaction();
		return session;
	}

	public static HibernateUtil instance = null;

	public static HibernateUtil getInstance() {
		if (instance == null) {
			instance = new HibernateUtil();
		}
		return instance;
	}

	// -------------
	@SuppressWarnings("deprecation")
	private static SessionFactory buildSessionFactory() {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			return new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static long getSequence(String sequenceName) throws Exception {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		String strQuery = "SELECT " + sequenceName + " .NextVal FROM Dual";
		Query queryObject = session.createSQLQuery(strQuery);
		BigDecimal bigDecimal = (BigDecimal) queryObject.uniqueResult();
		session.close();
		return bigDecimal.longValue();
	}

	public static Date getSysdate() throws Exception {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		String strQuery = "SELECT sysdate as system_datetime FROM Dual";
		SQLQuery queryObject = session.createSQLQuery(strQuery);
		queryObject.addScalar("system_datetime", DateType.INSTANCE);
		Date sysdate = (Date) queryObject.uniqueResult();
		session.close();
		return sysdate;
	}

	/**
	 * @author hieunq5
	 * 
	 *         Get an String by key
	 * @param session
	 * @param key
	 */
	public static String getString(HttpSession session, String key) {
		String result = "";
		try {
			result = (String) session.getAttribute(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * @author hieunq5
	 * 
	 *         Get an Long by key
	 * @param session
	 * @param key
	 */
	public static Long getLong(HttpSession session, String key) {
		Long result = null;
		try {
			result = (Long) session.getAttribute(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * @author hieunq5
	 * 
	 *         Get an object by key
	 * @param session
	 * @param key
	 */
	public static Object getObject(HttpSession session, String key) {
		Object result = null;
		try {
			result = (Object) session.getAttribute(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * Start to commit all changes
	 */
	public void commit() {
		getSession().getTransaction().commit();
	}

}
