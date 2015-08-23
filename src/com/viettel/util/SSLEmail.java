/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.util;

import globaldefine.EmailConfig;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.PreencodedMimeBodyPart;
import javax.mail.util.ByteArrayDataSource;


/**
 * @author hieunq5
 * 
 */
public class SSLEmail {
	public static boolean sendReviewEmail(String content, String recipient, String subject) {
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtps.host", EmailConfig.host);
		properties.setProperty("mail.smtps.port", EmailConfig.port);
		properties.setProperty("mail.smtps.auth", EmailConfig.auth);
		properties.setProperty("mail.user", EmailConfig.from);
		properties.setProperty("mail.password", EncriptUtils.decryptEmailPassword(EmailConfig.password));
		Session session = Session.getDefaultInstance(properties);

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(EmailConfig.from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
			message.setSubject(subject, "UTF-8");
			message.setContent(content, "text/html; charset=utf-8");

			Transport trnsport;
			trnsport = session.getTransport("smtps");
			trnsport.connect(null, properties.getProperty("mail.password"));
			message.saveChanges();
			trnsport.sendMessage(message, message.getAllRecipients());
			trnsport.close();
			System.out.println("Sent message successfully....");
			return true;

		} catch (MessagingException mex) {
			mex.printStackTrace();
			return false;
		}
	}

	// Truyền vào Nội dung Email: emailContent
	// Email nhận: recipient
	// Subject Emai: subject
	public static boolean sendEmailHtml(String emailContent, String recipient, String subject) {
		// Get system properties
		Properties properties = System.getProperties();
		// Setup mail server
		properties.setProperty("mail.smtps.host", EmailConfig.host);
		properties.setProperty("mail.smtps.port", EmailConfig.port);
		properties.setProperty("mail.smtps.auth", EmailConfig.auth);
		properties.setProperty("mail.user", EmailConfig.from);
		properties.setProperty("mail.password", EncriptUtils.decryptEmailPassword(EmailConfig.password));
		// properties.put("mail.debug", "true");

		// Get the default Session object.
		Session session = Session.getDefaultInstance(properties);

		try {
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(EmailConfig.from));

			// Set To: header field of the header.

			message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

			message.setSubject(subject, "UTF-8");
			message.setContent(emailContent, "text/html; charset=utf-8");

			Transport trnsport;
			trnsport = session.getTransport("smtps");

			trnsport.connect(null, properties.getProperty("mail.password"));
			message.saveChanges();
			trnsport.sendMessage(message, message.getAllRecipients());
			trnsport.close();
			return true;
		} catch (MessagingException mex) {
			mex.printStackTrace();
			return false;
		}
	}

	// Truyền vào Nội dung Email: emailContent
	// Email nhận: recipient
	// Subject Emai: subject
	public static boolean sendInlineLocasdflImagsdfesInEmail(String recipient, String subject) {
		// Get system properties
		Properties properties = System.getProperties();
		// Setup mail server
		properties.setProperty("mail.smtps.host", EmailConfig.host);
		properties.setProperty("mail.smtps.port", EmailConfig.port);
		properties.setProperty("mail.smtps.auth", EmailConfig.auth);
		properties.setProperty("mail.user", EmailConfig.from);
		properties.setProperty("mail.password", EncriptUtils.decryptEmailPassword(EmailConfig.password));
		// properties.put("mail.debug", "true");

		// Get the default Session object.
		Session session = Session.getDefaultInstance(properties);

		try {
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(EmailConfig.from));

			// Set To: header field of the header.

			message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

			message.setSubject(subject, "UTF-8");

			// This mail has 2 part, the BODY and the embedded image
			MimeMultipart multipart = new MimeMultipart("related");
			// first part (the html)
			BodyPart messageBodyPart = new MimeBodyPart();
			String htmlText = "<H1>Hello</H1><img src=\"cid:image\">";
			messageBodyPart.setContent(htmlText, "text/html");
			// add it
			multipart.addBodyPart(messageBodyPart);

			// second part (the image)
			messageBodyPart = new MimeBodyPart();
			DataSource fds = new FileDataSource("E:\\ENTERTAINMENT\\images\\abc.png");

			messageBodyPart.setDataHandler(new DataHandler(fds));
			messageBodyPart.setHeader("Content-ID", "<image>");

			// add image to the multipart
			multipart.addBodyPart(messageBodyPart);

			// put everything together
			message.setContent(multipart);
			Transport trnsport;
			trnsport = session.getTransport("smtps");

			trnsport.connect(null, properties.getProperty("mail.password"));
			message.saveChanges();
			trnsport.sendMessage(message, message.getAllRecipients());
			trnsport.close();
			return true;
		} catch (MessagingException mex) {
			mex.printStackTrace();
			return false;
		}
	}// Truyền vào Nội dung Email: emailContent
		// Email nhận: recipient
		// Subject Emai: subject

	public static boolean sendInlineDynamicImagesInEmail(String recipient, String subject) {
		// Get system properties
		Properties properties = System.getProperties();
		// Setup mail server
		properties.setProperty("mail.smtps.host", EmailConfig.host);
		properties.setProperty("mail.smtps.port", EmailConfig.port);
		properties.setProperty("mail.smtps.auth", EmailConfig.auth);
		properties.setProperty("mail.user", EmailConfig.from);
		properties.setProperty("mail.password", EncriptUtils.decryptEmailPassword(EmailConfig.password));
		// properties.put("mail.debug", "true");

		// Get the default Session object.
		Session session = Session.getDefaultInstance(properties);

		try {
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(EmailConfig.from));

			// Set To: header field of the header.

			message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

			message.setSubject(subject, "UTF-8");

			// This mail has 2 part, the BODY and the embedded image
			MimeMultipart multipart = new MimeMultipart("related");
			// first part (the html)
			BodyPart messageBodyPart = new MimeBodyPart();
			String htmlText = "<H1>Hello</H1><img src=\"cid:image\">";
			messageBodyPart.setContent(htmlText, "text/html");
			// add it
			multipart.addBodyPart(messageBodyPart);

			// second part (the image)
			messageBodyPart = new MimeBodyPart();
			String feedbackContent = FileUtils.read("C:\\Users\\VPMT\\Desktop\\feedback content.txt");
			DataSource fds = null;
			try {
				new ByteArrayDataSource(new ByteArrayInputStream(feedbackContent.getBytes()), "multipart/mixed");

			} catch (Exception e) {
			}

			messageBodyPart.setDataHandler(new DataHandler(fds));
			messageBodyPart.setHeader("Content-ID", "<image>");

			// add image to the multipart
			multipart.addBodyPart(messageBodyPart);

			// put everything together
			message.setContent(multipart);
			Transport trnsport;
			trnsport = session.getTransport("smtps");

			trnsport.connect(null, properties.getProperty("mail.password"));
			message.saveChanges();
			trnsport.sendMessage(message, message.getAllRecipients());
			trnsport.close();
			return true;
		} catch (MessagingException mex) {
			mex.printStackTrace();
			return false;
		}
	}

	private static final Pattern imgRegExp = Pattern.compile("<img[^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>");

	public static boolean sendBase64Content(String recipient, String subject) {

		Map<String, String> inlineImage = new HashMap<String, String>();
		String feedbackContent = FileUtils.read("C:\\Users\\VPMT\\Desktop\\feedback content.txt");
		String body = feedbackContent;

		final Matcher matcher = imgRegExp.matcher(body);
		int i = 0;
		while (matcher.find()) {
			String src = matcher.group();
			if (body.indexOf(src) != -1) {
				String srcToken = "src=\"";
				int x = src.indexOf(srcToken);
				int y = src.indexOf("\"", x + srcToken.length());
				String srcText = src.substring(x + srcToken.length(), y);
				String cid = "image" + i;
				String newSrc = src.replace(srcText, "cid:" + cid);
				inlineImage.put(cid, srcText.split(",")[1]);
				body = body.replace(src, newSrc);
				i++;
			}
		}
		// Get system properties
		Properties properties = System.getProperties();
		// Setup mail server
		properties.setProperty("mail.smtps.host", EmailConfig.host);
		properties.setProperty("mail.smtps.port", EmailConfig.port);
		properties.setProperty("mail.smtps.auth", EmailConfig.auth);
		properties.setProperty("mail.user", EmailConfig.from);
		properties.setProperty("mail.password", EncriptUtils.decryptEmailPassword(EmailConfig.password));

		// Get the default Session object.
		Session session = Session.getDefaultInstance(properties);
		try {
			MimeMessage message = new MimeMessage(session);
			message.setSubject(subject);
			message.setFrom(new InternetAddress(EmailConfig.from));
			BodyPart bp = new MimeBodyPart();
			bp.setContent(body, "text/html");
			MimeMultipart mmp = new MimeMultipart();
			mmp.addBodyPart(bp);
			Iterator<Entry<String, String>> it = inlineImage.entrySet().iterator();
			while (it.hasNext()) {
				Entry<String, String> pairs = it.next();
				PreencodedMimeBodyPart pmp = new PreencodedMimeBodyPart("base64");
				pmp.setHeader("Content-ID", "<" + pairs.getKey() + ">");
				pmp.setDisposition(MimeBodyPart.INLINE);
				pmp.setText(pairs.getValue());
				mmp.addBodyPart(pmp);
			}
			message.setContent(mmp);
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

			Transport trnsport;
			trnsport = session.getTransport("smtps");

			trnsport.connect(null, properties.getProperty("mail.password"));
			message.saveChanges();
			trnsport.sendMessage(message, message.getAllRecipients());
			trnsport.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
