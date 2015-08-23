package com.viettel.util;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import com.viettel.common.util.EncryptDecryptUtils;

public class EncriptUtils {
	
	private static MessageDigest digester;

	static {
		try {
			digester = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	public static String crypt(String str) {
		if (str == null || str.length() == 0) {
			throw new IllegalArgumentException(
					"String to encript cannot be null or zero length");
		}

		digester.update(str.getBytes());
		byte[] hash = digester.digest();
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < hash.length; i++) {
			if ((0xff & hash[i]) < 0x10) {
				hexString.append("0" + Integer.toHexString((0xFF & hash[i])));
			} else {
				hexString.append(Integer.toHexString(0xFF & hash[i]));
			}
		}
		return hexString.toString();
	}

	public static String enCript(String password) {
		String encriptedPass = "";
		byte[] txtByte = StringUtil.stringToByte(password);
		byte[] byteEncripted = null;
		try {
			byteEncripted = EncryptDecryptUtils.encrypt(txtByte);
			encriptedPass = StringUtil.byteToString(byteEncripted);
		} catch (Exception e) {
		}
		return encriptedPass;
	}

	public static String encriptSHA(String str) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		md.update(str.getBytes());

		byte byteData[] = md.digest();

		// convert the byte to hex format
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16)
					.substring(1));
		}
		return sb.toString();
	}

	public static final char[] PASSWORD = "enfldsgbnlsngdlksdsgm".toCharArray();
	public static final byte[] SALT = {
			(byte) 0xde, (byte) 0x33, (byte) 0x10, (byte) 0x12,
			(byte) 0xde, (byte) 0x33, (byte) 0x10, (byte) 0x12,
	};

	public static String encryptEmailPassword(String property) {
		String encriptedPassword = "";
		try {
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
			SecretKey key = keyFactory.generateSecret(new PBEKeySpec(PASSWORD));
			Cipher pbeCipher = Cipher.getInstance("PBEWithMD5AndDES");
			pbeCipher.init(Cipher.ENCRYPT_MODE, key, new PBEParameterSpec(SALT, 20));
			encriptedPassword = base64Encode(pbeCipher.doFinal(property.getBytes("UTF-8")));
		} catch (Exception e) {
		}
		return encriptedPassword;
	}

	public static String decryptEmailPassword(String property) {
		String decriptedPassword = "";
		try {
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
			SecretKey key = keyFactory.generateSecret(new PBEKeySpec(PASSWORD));
			Cipher pbeCipher = Cipher.getInstance("PBEWithMD5AndDES");
			pbeCipher.init(Cipher.DECRYPT_MODE, key, new PBEParameterSpec(SALT, 20));
			decriptedPassword = new String(pbeCipher.doFinal(base64Decode(property)), "UTF-8");
		} catch (Exception e) {
		}
		return decriptedPassword;
	}

	private static String base64Encode(byte[] bytes) {
		return new BASE64Encoder().encode(bytes);
	}

	private static byte[] base64Decode(String property) throws IOException {
		return new BASE64Decoder().decodeBuffer(property);
	}

	

}
