package com.viettel.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

import com.viettel.data.dao.MockUserDAO;
import com.viettel.data.model.entity.MockUser;

/**
 * 
 * @author Administrator
 *
 */
public class EmailUtils  {
	private static final String TAG = EmailUtils.class.getSimpleName();

	private String email;
	private String emailExisted;

	public static EmailUtils instance = null;

	public static EmailUtils getInstance() {
		if (instance == null) {
			instance = new EmailUtils();
		}
		return instance;
	}

	private static Pattern pattern;
	private static Matcher matcher;
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final String DATE_PATTERN = "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)";
	private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!^&*]).{9,50})";

	/**
	 * @param email
	 * @return
	 */
	public static boolean validateEmail(String email) {
		pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(email);
		return matcher.matches();
	}

	/**
	 * @param password
	 * @return
	 */
	public static boolean validatePassword(String password) {
		pattern = Pattern.compile(PASSWORD_PATTERN);
		matcher = pattern.matcher(password);
		return matcher.matches();
	}

	/**
	 * @param date
	 * @return
	 */
	public static boolean validateDate(String date) {
		pattern = Pattern.compile(DATE_PATTERN);
		matcher = pattern.matcher(date);

		if (matcher.matches()) {
			matcher.reset();
			if (matcher.find()) {

				String day = matcher.group(1);
				String month = matcher.group(2);
				int year = Integer.parseInt(matcher.group(3));

				if (day.equals("31") && (month.equals("4") || month.equals("6") || month.equals("9") || month.equals("11") || month.equals("04") || month.equals("06") || month.equals("09"))) {
					return false; // only 1,3,5,7,8,10,12 has 31 days
				} else if (month.equals("2") || month.equals("02")) {
					// leap year
					if (year % 4 == 0) {
						if (day.equals("30") || day.equals("31")) {
							return false;
						} else {
							return true;
						}
					} else {
						if (day.equals("29") || day.equals("30") || day.equals("31")) {
							return false;
						} else {
							return true;
						}
					}
				} else {
					return true;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * 
	 */
	public static void CheckEmail() {

		String[] emails = new String[] { "nqhieu09t3@gmail.com", "hieunq5@viettel.com.vn" };
		for (int i = 0; i < emails.length; i++) {
			String email = emails[i];
			System.out.println("Email = " + email + ", result = " + isAddressValid(email));
		}
	}

	public String checkValidEmail() { // checkValidCaptcha
		// Check existing email
		String email = getEmail().toLowerCase();
		email = email.replaceAll("[-+^:,<>/()\\ ]", "");
		MockUser user = MockUserDAO.getInstance().getUserByEmail(email);
		if (user != null) {
			setEmailExisted("emailExisted");
		} else {
			setEmailExisted("emailNotExisted");
		}
		return "SUCCESS";
	}

	/**
	 * @param listEmail
	 *            -> hieunq5@viettel.com.vn; hieuph@viettel.com.vn;
	 *            thanhlq6@viettel.com.vn
	 * @return
	 */
	public List<String> getListEmail(String listEmail) {
		List<String> emails = null;

		if (listEmail != null) {
			listEmail = listEmail.trim();
			listEmail = listEmail.replaceAll("\\s+", " ");
			listEmail = listEmail.replace(" ", ";");
			listEmail = listEmail.replace(",", ";");

			String[] list = listEmail.split(";");
			if (list.length > 0) {
				emails = new ArrayList<String>();
				for (int i = 0; i < list.length; i++) {
					// Check email is existed in list
					boolean isExisted = false;
					for (String email : emails) {
						if (email.equals(list[i].trim().toLowerCase())) {
							isExisted = true;
						}
					}
					if (!isExisted) {
						if (!list[i].trim().equals("")) {
							emails.add(list[i].trim().toLowerCase());
						}
					}
				}
			}
		}
		return emails;
	}

	// =============================================================================================================
	private static int hear(BufferedReader in) throws IOException {
		String line = null;
		int res = 0;

		while ((line = in.readLine()) != null) {
			String pfx = line.substring(0, 3);
			try {
				res = Integer.parseInt(pfx);
			} catch (Exception ex) {
				ex.printStackTrace();
				res = -1;
			}
			if (line.charAt(3) != '-')
				break;
		}

		return res;
	}

	private static void say(BufferedWriter wr, String text) throws IOException {
		wr.write(text + "\r\n");
		wr.flush();

		return;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static ArrayList getMX(String hostName) throws NamingException {
		// Perform a DNS lookup for MX records in the domain
		Hashtable env = new Hashtable();
		env.put("java.naming.factory.initial", "com.sun.jndi.dns.DnsContextFactory");
		// env.put("java.naming.factory.initial",
		// "com.sun.jndi.dns.DnsContextFactory");
		DirContext ictx = new InitialDirContext(env);
		Attributes attrs = ictx.getAttributes(hostName, new String[] { "MX" });
		Attribute attr = attrs.get("MX");

		// if we don't have an MX record, try the machine itself
		if ((attr == null) || (attr.size() == 0)) {
			attrs = ictx.getAttributes(hostName, new String[] { "A" });
			attr = attrs.get("A");
			if (attr == null)
				throw new NamingException("No match for name '" + hostName + "'");
		}

		// Huzzah! we have machines to try. Return them as an array list
		// NOTE: We SHOULD take the preference into account to be absolutely
		// correct. This is left as an exercise for anyone who cares.
		ArrayList res = new ArrayList();
		NamingEnumeration en = attr.getAll();

		while (en.hasMore()) {
			String x = (String) en.next();
			String f[] = x.split(" ");
			if (f[1].endsWith("."))
				f[1] = f[1].substring(0, (f[1].length() - 1));
			res.add(f[1]);
		}
		LogUtils.d(TAG, "getMX 4");
		return res;
	}

	/**
	 * @param email
	 * @return
	 */
	public static boolean isExistedEmail(String email) {
		try {
			boolean existed = isAddressValid(email);
			return existed;
		} catch (Exception e) {
			return false;
		}
	}

	@SuppressWarnings("rawtypes")
	public static boolean isAddressValid(String address) {
		// Find the separator for the domain name
		int pos = address.indexOf('@');

		// If the address does not contain an '@', it's not valid
		if (pos == -1) {
			LogUtils.d(TAG, "pos == -1");
			return false;
		}

		// Isolate the domain/machine name and get a list of mail exchangers
		String domain = address.substring(++pos);
		ArrayList mxList = null;
		try {
			mxList = getMX(domain);
		} catch (NamingException ex) {
			LogUtils.d(TAG, "NamingException");
			return false;
		}

		// Just because we can send mail to the domain, doesn't mean that the
		// address is valid, but if we can't, it's a sure sign that it isn't
		if (mxList.size() == 0) {
			LogUtils.d(TAG, "mxList.size() == 0");
			return false;
		}

		// Now, do the SMTP validation, try each mail exchanger until we get
		// a positive acceptance. It *MAY* be possible for one MX to allow
		// a message [store and forwarder for example] and another [like
		// the actual mail server] to reject it. This is why we REALLY ought
		// to take the preference into account.
		for (int mx = 0; mx < mxList.size(); mx++) {
			boolean valid = false;
			try {
				int res;
				Socket skt = new Socket((String) mxList.get(mx), 25);
				BufferedReader rdr = new BufferedReader(new InputStreamReader(skt.getInputStream()));
				BufferedWriter wtr = new BufferedWriter(new OutputStreamWriter(skt.getOutputStream()));

				res = hear(rdr);
				if (res != 220) {
					LogUtils.d(TAG, "throw new Exception(Invalid header)");
					throw new Exception("Invalid header");
				}
				say(wtr, "EHLO orbaker.com");

				res = hear(rdr);
				if (res != 250) {
					LogUtils.d(TAG, "throw new Exception(Not ESMTP)");
					throw new Exception("Not ESMTP");
				}

				// validate the sender address
				say(wtr, "MAIL FROM: <tim@orbaker.com>");
				// say(wtr, "MAIL FROM: <hieunq5@viettel.com.vn>");
				res = hear(rdr);
				if (res != 250) {
					LogUtils.d(TAG, "throw new Exception(Sender rejected)");
					throw new Exception("Sender rejected");
				}

				say(wtr, "RCPT TO: <" + address + ">");
				res = hear(rdr);

				// be polite
				say(wtr, "RSET");
				hear(rdr);
				say(wtr, "QUIT");
				hear(rdr);
				if (res != 250) {
					LogUtils.d(TAG, "throw new Exception(Address is not valid!)");
					throw new Exception("Address is not valid!");
				}

				valid = true;
				rdr.close();
				wtr.close();
				skt.close();
			} catch (Exception ex) {
				LogUtils.d(TAG, "isAddressValid");

			} finally {
				if (valid)
					return true;
			}
		}
		LogUtils.d(TAG, "return false");
		return false;
	}

	// =============================================================================================================

	public String getEmailExisted() {
		return emailExisted;
	}

	public void setEmailExisted(String emailExisted) {
		this.emailExisted = emailExisted;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
