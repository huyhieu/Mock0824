package com.viettel.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSON;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import org.hibernate.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.w3c.dom.Document;

import com.viettel.data.dao.MockApiBodyDAO;
import com.viettel.data.dao.MockApiDAO;
import com.viettel.data.model.entity.MockApi;
import com.viettel.data.model.entity.MockApiBody;
import com.viettel.data.model.entity.VpmtMockService;
import com.viettel.data.model.entity.VpmtMockServiceConfig;
import com.viettel.util.HibernateUtil;
import com.viettel.util.LogUtils;
import com.viettel.util.StringUtil;

@Controller
@SessionAttributes
public class MockService {

	// private String mockCode = "";
	private String responseString = "";
	private JSON json;
	private String xml;
	public static String CONTENT_TYPE_JSON = "application/json";
	public static String CONTENT_TYPE_XML = "application/xml";
	public static String CONTENT_TYPE_FORM = "application/x-www-form-urlencoded";
	public static String POST_METHOD = "POST";
	public static String GET_METHOD = "GET";

	public String getXml() {
		return xml;
	}

	public void setXml(String xml) {
		this.xml = xml;
	}

	public JSON getJson() {
		return json;
	}

	public void setJson(JSON json) {
		this.json = json;
	}

	/*
	 * public String getMockCode() { return mockCode; }
	 * 
	 * public void setMockCode(String mockCode) { this.mockCode = mockCode; }
	 */

	public String getResponseString() {
		return responseString;
	}

	public void setResponseString(String responseString) {
		this.responseString = responseString;
	}

	@SuppressWarnings({ "static-access", "unchecked" })
	@RequestMapping(value = "/MockService/{mockCode}", produces = { "application/json", "application/xml" }, consumes = { "application/json", "application/xml" })
	public @ResponseBody
	Object getMockService(@RequestHeader(value = "Content-Type", defaultValue = "application/json") String contentType, @PathVariable(value = "mockCode") String mockCode) throws IOException {
		LogUtils.d("Content-Type", contentType);
		ServletRequestAttributes attr = (ServletRequestAttributes)
				RequestContextHolder.currentRequestAttributes();
		HttpServletRequest request = attr.getRequest();
		JSONObject jsonRequestClient = new JSONObject();
		if (request.getMethod().equals(POST_METHOD)) {
			String line = null;
			StringBuffer jb = new StringBuffer();
			try {
				BufferedReader reader = request.getReader();
				while ((line = reader.readLine()) != null) {
					jb.append(line);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			LogUtils.d("Boby", jb.toString());
			if (jb.toString().trim().equals("")) {
				jb.append("{}");
			}
			try {
				jsonRequestClient = JSONObject.fromObject(jb.toString());
			} catch (Exception ex) {
				String error = "{\n" + "\"error\": \"Chuoi Json request gửi lên sai cau truc\"\n" + "}";
				json = JSONSerializer.toJSON(error);
				ex.printStackTrace();
				return json;
			}
		} else {
			Map<String, String[]> mapParam = request.getParameterMap();
			HashMap<String, String> hashMap = new HashMap<>();
			for (Map.Entry<String, String[]> e : mapParam.entrySet()) {
				if (!e.getKey().equals("MockCode")) {
					if (e.getValue().length > 0) {
						hashMap.put(e.getKey(), e.getValue()[0]);
					} else {
						hashMap.put(e.getKey(), "");
					}
				}
			}
			jsonRequestClient = JSONObject.fromObject(hashMap);
			LogUtils.d("jsonRequestClient", jsonRequestClient.toString());
		}

		boolean haveConfig = false;
		String jsonResponseServer = "";

		String method = attr.getRequest().getMethod();
		LogUtils.d("method", method);

		Query query = HibernateUtil.getInstance().getSession().createQuery("From VpmtMockService where code =?");
		query.setParameter(0, mockCode);
		List<VpmtMockService> lstVpmtMockService = query.list();
		if (!lstVpmtMockService.isEmpty()) {
			VpmtMockService mock = lstVpmtMockService.get(0);
			// tim kiem trong config da co chua
			Query queryConfig = HibernateUtil.getInstance().getSession().createQuery("From VpmtMockServiceConfig where responseId = ?");
			queryConfig.setParameter(0, mock.getId());
			List<VpmtMockServiceConfig> lstMockService = queryConfig.list();
			for (VpmtMockServiceConfig mockConfig : lstMockService) {
				String requestString = "{}";
				if (mockConfig.getRequestByte() != null) {
					if (mockConfig.getRequestByte() != null) {
						requestString = new String(mockConfig.getRequestByte(), Charset.forName("UTF8"));
					}
					JSONObject jsonRequestServer = JSONObject.fromObject(requestString);
					if (jsonRequestClient.equals(jsonRequestServer)) {
						haveConfig = true;
						if (mockConfig.getResponseByte() != null) {
							jsonResponseServer = new String(mockConfig.getResponseByte(), Charset.forName("UTF8"));
						}
						break;
					}
				}
			}
			if (!haveConfig) {// set default
				jsonResponseServer = new String(mock.getValueByte(), Charset.forName("UTF8"));
			}
			responseString = jsonResponseServer;
			if (mock.getMockType().toLowerCase().equals("json")) {
				try {
					json = JSONSerializer.toJSON(responseString);
				} catch (Exception ex) {
					ex.printStackTrace();
					String error = "{\n" + "\"error\": \"Chuoi Json sai cau truc\"\n" + "}";
					json = JSONSerializer.toJSON(error);
				}
				return json;
			}
		}
		return json;
	}

	@RequestMapping(value = "/V2/{mockCode}", produces = { "application/json", "application/xml" }, consumes = { "application/json", "application/xml" })
	public @ResponseBody
	Object V2(@RequestHeader(value = "Content-Type", defaultValue = "application/json") String contentType, @PathVariable(value = "mockCode") String mockCode) throws IOException {
		LogUtils.d("Content-Type", contentType);
		ServletRequestAttributes attr = (ServletRequestAttributes)
				RequestContextHolder.currentRequestAttributes();
		HttpServletRequest request = attr.getRequest();
		// tao doi tuong nhan body request tu client
		// doi tuong neu request la json
		JSONObject jsonRequestClient = new JSONObject();
		Document xmlRequestClient = null;

		if (request.getMethod().equals(POST_METHOD)) {
			String line = null;
			StringBuffer jb = new StringBuffer();
			try {
				BufferedReader reader = request.getReader();
				while ((line = reader.readLine()) != null) {
					jb.append(line);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			LogUtils.d("Boby", jb.toString());
			if (jb.toString().trim().equals("")) {
				jb.append("{}");
			}
			if (contentType.equals(CONTENT_TYPE_JSON)) {
				try {
					jsonRequestClient = JSONObject.fromObject(jb.toString());
				} catch (Exception ex) {
					String error = "{\n" + "\"error\": \"Chuoi Json request gửi lên sai cau truc\"\n" + "}";
					json = JSONSerializer.toJSON(error);
					ex.printStackTrace();
					return json;
				}
			}
			else {

				xmlRequestClient = StringUtil.convertStringToDocument(jb.toString());
				if (xmlRequestClient == null) {
					String error = "<infomation><error>Chuoi request gui len sai cau truc</error></infomation>";
					xmlRequestClient = StringUtil.convertStringToDocument(error);

					return xmlRequestClient;
				}
			}

		} else {
			Map<String, String[]> mapParam = request.getParameterMap();
			HashMap<String, String> hashMap = new HashMap<>();
			for (Map.Entry<String, String[]> e : mapParam.entrySet()) {
				if (!e.getKey().equals("MockCode")) {
					if (e.getValue().length > 0) {
						hashMap.put(e.getKey(), e.getValue()[0]);
					} else {
						hashMap.put(e.getKey(), "");
					}
				}
			}
			jsonRequestClient = JSONObject.fromObject(hashMap);
			LogUtils.d("jsonRequestClient", jsonRequestClient.toString());
		}

		boolean haveConfig = false;
		String jsonResponseServer = "";

		// lay thong tin database mock service V2
		MockApi mockAPI = MockApiDAO.getInstance().getMockApiByNameUrl(mockCode.toLowerCase());
		if (mockAPI != null) {
			// tim kiem trong config da co chua
			List<MockApiBody> apiBodys = MockApiBodyDAO.getInstance().getApiBodyByMockId(mockAPI.getApiId());
			for (MockApiBody mockConfig : apiBodys) {
				String requestString = "{}";
				if (mockConfig.getBodyInput() != null) {
					if (mockConfig.getBodyInput() != null) {
						// luu request default
						requestString = mockConfig.getBodyInput();
					}
					if (contentType.equals(CONTENT_TYPE_JSON)) {
						JSONObject jsonRequestServer = JSONObject.fromObject(requestString);
						if (jsonRequestClient.equals(jsonRequestServer)) {
							haveConfig = true;
							if (mockConfig.getBodyOutput() != null) {
								jsonResponseServer = mockConfig.getBodyOutput();
							}
							break;
						}	
					}
					else{
						Document xmlRequestServer = StringUtil.convertStringToDocument(requestString);
						String strxmlRequestClient = StringUtil.convertDocumentToString(xmlRequestClient);
						String strxmlRequestServer = StringUtil.convertDocumentToString(xmlRequestServer);
						if (strxmlRequestClient.equals(strxmlRequestServer)) {
							haveConfig = true;
							if (mockConfig.getBodyOutput() != null) {
								jsonResponseServer = mockConfig.getBodyOutput();
							}
							break;
						}
					}
					
					
				}
			}
			if (!haveConfig) {// set default
				jsonResponseServer = mockAPI.getBodyDefault();
			}
			responseString = jsonResponseServer;
			
			if (contentType.equals(CONTENT_TYPE_JSON)) {
				try {
					json = JSONSerializer.toJSON(responseString);
				} catch (Exception ex) {
					ex.printStackTrace();
					String error = "{\n" + "\"error\": \"Chuoi Json sai cau truc\"\n" + "}";
					json = JSONSerializer.toJSON(error);
				}
				return json;
			}
			else {
				xmlRequestClient = StringUtil.convertStringToDocument(responseString);
				if (xmlRequestClient == null) {
					String error = "<infomation><error>Chuoi request gui len sai cau truc</error></infomation>";
					xmlRequestClient = StringUtil.convertStringToDocument(error);

					return xmlRequestClient;
				}
				return xmlRequestClient;
			}
			
		}
		return json;
	}
}
