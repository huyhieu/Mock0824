package com.viettel.util;

import java.io.StringReader;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.Random;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.lang.RandomStringUtils;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

/**
 * @author hieunq5
 * 
 */
public class StringUtil {

	static final String AB = "abcdefghjkmnpqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ123456789!@#$%^&*";

	public static final int stringLength = 50;
	public static final int DEFAULT_PASSWORD_LENGHT = 8;

	public static final String stringFormat = "UTF-8";
	// Tieng Viet
	private static final char[] marked = { 'à', 'á', 'ả', 'ã', 'ạ', 'ă', 'ằ', 'ắ', 'ẳ', 'ẵ', 'ặ', 'â', 'ầ', 'ấ', 'ẩ',
			'ẫ', 'ậ', 'À', 'Á', 'Ả', 'Ã', 'Ạ', 'Ă', 'Ằ', 'Ắ', 'Ẳ', 'Ẵ', 'Ặ', 'Â', 'Ầ', 'Ấ', 'Ẩ', 'Ẫ', 'Ậ', 'è', 'é',
			'ẻ', 'ẽ', 'ẹ', 'ê', 'ề', 'ế', 'ể', 'ễ', 'ệ', 'È', 'É', 'Ẻ', 'Ẽ', 'Ẹ', 'Ê', 'Ề', 'Ế', 'Ể', 'Ễ', 'Ệ', 'ì',
			'í', 'ỉ', 'ĩ', 'ị', 'Ì', 'Í', 'Ỉ', 'Ĩ', 'Ị', 'ò', 'ó', 'ỏ', 'õ', 'ọ', 'ô', 'ồ', 'ố', 'ổ', 'ỗ', 'ộ', 'ơ',
			'ờ', 'ớ', 'ở', 'ỡ', 'ợ', 'Ò', 'Ó', 'Ỏ', 'Õ', 'Ọ', 'Ô', 'Ồ', 'Ố', 'Ổ', 'Ỗ', 'Ộ', 'Ơ', 'Ờ', 'Ớ', 'Ở', 'Ỡ',
			'Ợ', 'ù', 'ú', 'ủ', 'ũ', 'ụ', 'ư', 'ừ', 'ứ', 'ử', 'ữ', 'ự', 'Ù', 'Ú', 'Ủ', 'Ũ', 'Ụ', 'ỳ', 'ý', 'ỷ', 'ỹ',
			'ỵ', 'Ỳ', 'Ý', 'Ỷ', 'Ỹ', 'Ỵ', 'đ', 'Đ', 'Ư', 'Ừ', 'Ử', 'Ữ', 'Ứ', 'Ự', '%', '_' };
	private static final char[] notmarked = { 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
			'A', 'A', 'A', 'A', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'i', 'i', 'i', 'i', 'i', 'I', 'I', 'I', 'I', 'I', 'o',
			'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'u', 'u', 'u', 'u',
			'u', 'u', 'u', 'u', 'u', 'u', 'u', 'U', 'U', 'U', 'U', 'U', 'y', 'y', 'y', 'y', 'y', 'Y', 'Y', 'Y', 'Y', 'Y', 'd', 'D', 'U', 'U', 'U', 'U', 'U', 'U', '♥', '♠' };

	/**
	 * 
	 * Kiem tra xem mot CharSequence co null hay do dai la 0
	 */
	public static boolean hasLength(CharSequence str) {
		return (str != null && str.length() > 0);
	}

	/**
	 * 
	 * Kiem tra xem mot chuoi String co null hay do dai la 0
	 */
	public static boolean hasLength(String str) {
		return hasLength((CharSequence) str);
	}

	/**
	 * 
	 * Trim whitespace o dau va cuoi cua chuoi String
	 */
	public static String trimWhitespace(String str) {
		if (!hasLength(str)) {
			return str;
		}
		StringBuilder sb = new StringBuilder(str);
		while (sb.length() > 0 && Character.isWhitespace(sb.charAt(0))) {
			sb.deleteCharAt(0);
		}
		while (sb.length() > 0 && Character.isWhitespace(sb.charAt(sb.length() - 1))) {
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}

	/**
	 * 
	 * Chuyen tieng viet co dau (unicode) thanh tieng anh (eng)
	 */
	public static String convertUnicodeToEngString(String unicodeString) {
		if (!hasLength(unicodeString)) {
			return "";
		}
		unicodeString = trimWhitespace(unicodeString);

		for (int i = 0; i < marked.length; i++) {
			unicodeString = unicodeString.replace(marked[i], notmarked[i]);
		}
		return unicodeString;
	}

	public static String getRandomTokenString()
	{
		String token = "";
		token = RandomStringUtils.randomAlphabetic(stringLength);
		return token;
	}

	public static String getRandomString(int length) {
		String token = "";
		token = RandomStringUtils.randomAlphabetic(length);
		return token;
	}
	
	static final String UppercaseCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static final String LowercaseCharacters = "abcdefghijklmnopqrstuvwxyz";
	static final String NumberCharacters = "0123456789";
	static final String SpecialCharactersCharacters = "~!@#$%^&*()_+=-`" + "{}|\\][" + ";:'\"" + ",<.>/?";
	
	public static String getNewPassword(int len){
		String passwordStrength = "a,b,c,d";
		String[] listPasswordStrength = passwordStrength.split(",");

		String regexPassForGen = "";
		for (String itemPasswordStrength : listPasswordStrength) {
			switch (itemPasswordStrength) {
			case "a":
				regexPassForGen = regexPassForGen + UppercaseCharacters;
				break;
			case "b":
				regexPassForGen = regexPassForGen + LowercaseCharacters;
				break;
			case "c":
				regexPassForGen = regexPassForGen + NumberCharacters;
				break;
			case "d":
				regexPassForGen = regexPassForGen + SpecialCharactersCharacters;
				break;
			}

		}
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len-listPasswordStrength.length; i++){
			sb.append(regexPassForGen.charAt(rnd.nextInt(regexPassForGen.length())));
		}
		for (String itemPasswordStrength : listPasswordStrength) {
			switch (itemPasswordStrength) {
			case "a":
				sb.append("A");
				break;
			case "b":
				sb.append("a");
				break;
			case "c":
				sb.append("1");
				break;
			case "d":
				sb.append("#");
				break;
			}

		}
		return sb.toString();
	}

	public static byte[] stringToByte(String input) {
		byte[] output = input.getBytes(Charset.forName(stringFormat));
		return output;
	}

	public static byte[] stringToByte(String input, String stringFormat) {
		byte[] output = input.getBytes(Charset.forName(stringFormat));
		return output;
	}

	public static String byteToString(byte[] input) {
		String output = "";
		try {
			output = new String(input, "UTF-8");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return output;
	}

	public static Random rnd = new Random();

	public static String randomString(int len)
	{
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		return sb.toString();
	}
	
	public static void main(String[] args) {
        final String xmlStr = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"+
                                "<Emp id=\"1\"><name>Pankaj</name><age>25</age>\n"+
                                "<role>Developer</role><gen>Male</gen></Emp>";
        Document doc = convertStringToDocument(xmlStr);
         
        String str = convertDocumentToString(doc);
        System.out.println(str);
    }
 
    @SuppressWarnings("unused")
	public static String convertDocumentToString(Document doc) {
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer;
        try {
            transformer = tf.newTransformer();
            // below code to remove XML declaration
            // transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            StringWriter writer = new StringWriter();
            transformer.transform(new DOMSource(doc), new StreamResult(writer));
            String output = writer.getBuffer().toString();
            return output;
        } catch (TransformerException e) {
            e.printStackTrace();
        }
         
        return null;
    }
 
    public static Document convertStringToDocument(String xmlStr) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
        DocumentBuilder builder;  
        try 
        {  
            builder = factory.newDocumentBuilder();  
            Document doc = builder.parse( new InputSource( new StringReader( xmlStr ) ) ); 
            return doc;
        } catch (Exception e) {  
            e.printStackTrace();  
        } 
        return null;
    }
	
}
