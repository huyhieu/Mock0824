package com.viettel.data.json.entity;

import globaldefine.GlobalConst;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.viettel.data.model.entity.MockApi;

public class JsonParser {
	public static Scheme createScheme() {
		Scheme scheme = new Scheme();
		scheme.setName("http");
		scheme.setVersion("V11");
		return scheme;
	}

	public static URI createURI() {
		URI uri = new URI();
		uri.setPath("localhost:8080/voffice/rest/docIn/delivery");
		uri.setScheme(createScheme());
		return uri;
	}

	public static Method createMethod() {
		Method method = new Method();
		method.setRequestBody(true);
		method.setName("POST");
		method.setLink("http://tools.ietf.org/html/rfc7231#section-4.3.3");

		return method;
	}

	public static Body createBody() {
		Body body = new Body();
		body.setAutoSetLength(true);
		body.setBodyType("Text");
		body.setTextBody("{\n \"documentReceiveId\":122684760,\n " +
				"		\"processId\":67304798,\n" +
				"\"consumerKey\":\"oWYWJPBnNDZriNjn7CpIg8kfhcs\",\n" +
				"\"token\":\"68c88d47597c3c6c6eee0ee093794f1\",\n" +
				"\"timestamp\":\"2015-06-28 08:30:30.252\",\n" +
				"\"nonce\": \"123456789\"\n" +
				"}");

		return body;
	}

	public static List<Header> createHeaders() {
		List<Header> headers = new ArrayList<Header>();
		Header header1 = new Header();

		header1.setEnabled(true);
		header1.setName("Content-Type 1");
		header1.setValue("application/json; charset=utf-8 1");
		headers.add(header1);

		Header header2 = new Header();
		header2.setEnabled(true);
		header2.setName("Content-Type 2");
		header2.setValue("application/json; charset=utf-8 2");

		headers.add(header2);
		return headers;
	}

	public static List<Node> createNodes() {
		List<Node> nodes = new ArrayList<Node>();

		Node nodeProj = new Node();
		nodeProj.setNodeId("9948C6B0-6CB2-4136-A01C-73FABA29813B");
		nodeProj.setLastModified("2015-07-06T13:42:33.883+07:00");
		nodeProj.setName("V-Office");
		nodeProj.setType(NodeType.PROJECT);
		nodes.add(nodeProj);

		Node nodeServ = new Node();
		nodeServ.setNodeId("3274EB62-EEAF-480B-BE31-59C037DE5361");
		nodeServ.setLastModified("2015-07-06T13:42:33.883+07:00");
		nodeServ.setName("Authentication 1");
		nodeServ.setType(NodeType.SERVICE);
		nodeServ.setParentId("9948C6B0-6CB2-4136-A01C-73FABA29813B");
		nodes.add(nodeServ);

		Node nodeServ2 = new Node();
		nodeServ2.setNodeId("3274EB62-EEAF-480B-BE31-59C037DE5362");
		nodeServ2.setLastModified("2015-07-06T13:42:33.883+07:00");
		nodeServ2.setName("Authentication 2");
		nodeServ2.setType(NodeType.SERVICE);
		nodeServ2.setParentId("9948C6B0-6CB2-4136-A01C-73FABA29813B");
		nodes.add(nodeServ2);

		Node nodeReq = new Node();
		nodeReq.setNodeId("8A1ABF93-AEE3-41EC-BFF6-DE7149C3ED21");
		nodeReq.setLastModified("2015-07-06T13:42:33.883+07:00");
		nodeReq.setName("Login 1");
		nodeReq.setType(NodeType.REQUEST);
		nodeReq.setParentId("3274EB62-EEAF-480B-BE31-59C037DE5361");
		nodeReq.setHeaderType("Form");
		nodeReq.setHeaders(createHeaders());
		nodeReq.setBody(createBody());
		nodeReq.setMethod(createMethod());
		nodeReq.setUri(createURI());
		nodes.add(nodeReq);

		Node nodeReq2 = new Node();
		nodeReq2.setNodeId("8A1ABF93-AEE3-41EC-BFF6-DE7149C3ED22");
		nodeReq2.setLastModified("2015-07-06T13:42:33.883+07:00");
		nodeReq2.setName("Login 2");
		nodeReq2.setType(NodeType.REQUEST);
		nodeReq2.setParentId("3274EB62-EEAF-480B-BE31-59C037DE5362");
		nodeReq2.setHeaderType("Form");
		nodeReq2.setHeaders(createHeaders());
		nodeReq2.setBody(createBody());
		nodeReq2.setMethod(createMethod());
		nodeReq2.setUri(createURI());
		nodes.add(nodeReq2);

		return nodes;
	}

	public static MSAPI createMSAPITest() {
		MSAPI msapi = new MSAPI();
		msapi.setVersion("1");
		msapi.setNodes(createNodes());
		return msapi;
	}

	/**
	 * Importing json text from JSON TEXT into an Object type
	 * 
	 * @param msapi
	 */
	public static MockAPI toObjectFromJsonText(String jsonText) {
		MockAPI msapi = new MockAPI();
		// convert java object to JSON format,
		// and returned as JSON formatted string
		try {
			// convert the json string back to object
			Gson gson = new Gson();
			msapi = gson.fromJson(jsonText, MockAPI.class);

		} catch (Exception e) {
			e.printStackTrace();
			msapi = null;
		}
		return msapi;
	}

	/**
	 * Importing json text into an Object type
	 * 
	 * @param msapi
	 */
	public static MockAPI importJson(String fileName) {
		MockAPI msapi = new MockAPI();
		Gson gson = new Gson();
		// convert java object to JSON format,
		// and returned as JSON formatted string
		try {
			// Read data from file
			BufferedReader br = new BufferedReader(new FileReader(GlobalConst.JSON_PATH + fileName + DataType.JSON));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append("\n");
				line = br.readLine();
			}
			String json = sb.toString();
			// convert the json string back to object
			msapi = gson.fromJson(json, MockAPI.class);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return msapi;
	}

	/**
	 * Export json text into a file in structural format used for importing back
	 * 
	 * @param msapi
	 */
	public static boolean exportJson(MockAPI msapi, String fileName) {
		boolean success = true;
		Gson gson = new Gson();
		// convert java object to JSON format,
		// and returned as JSON formatted string
		String json = gson.toJson(msapi);
		// Start to export json into file
		try {
			// write converted json data to a file named "file.json"
			FileWriter writer = new FileWriter(GlobalConst.JSON_PATH + fileName + DataType.JSON);
			writer.write(json);
			writer.close();

		} catch (IOException e) {
			success = false;
			e.printStackTrace();
		}
		return success;
	}

	/**
	 * Convert to HTML node format
	 * 
	 * @param listApi
	 * @return
	 */
	public static List<HtmlParse> convertToHtmlNode(List<MockApi> listApi) {
		// Start to export data
		List<HtmlParse> htmlParses = new ArrayList<HtmlParse>();
		if (listApi != null && listApi.size() > 0) {
			// Iterate all node and add them to list
			for (MockApi node : listApi) {
				// Check type of node
				if ((long) node.getMockType() == NodeType.PROJECT_NODE) {
					// This is Project Type then add it to list
					htmlParses.add(new HtmlParse(node));
				} else {
					// This is child node(maybe: Service Type or Request Type)
					// Find parent of this node then insert it to this parent
					// node.
					for (HtmlParse htmlParse : htmlParses) {
						// Find in list Project
						if ((long) htmlParse.getNodeID() == (long) node.getParentId()) {
							htmlParse.addHtmlParse(node);
						} else {
							// Find in list Service
							for (HtmlParse childParse : htmlParse.getHtmlParses()) {
								if ((long) childParse.getNodeID() == (long) node.getParentId()) {
									childParse.addHtmlParse(node);
								}
							}
						}
					}
				}
			}
		}
		return htmlParses;
	}

	public static List<NodeParse> convertToNodeParse(List<MockApi> listApi) {
		// Start to export data
		List<NodeParse> htmlParses = new ArrayList<NodeParse>();
		if (listApi != null && listApi.size() > 0) {
			// Iterate all node and add them to list
			for (MockApi node : listApi) {
				// Check type of node
				if ((long) node.getMockType() == NodeType.PROJECT_NODE) {
					// This is Project Type then add it to list
					htmlParses.add(new NodeParse(node));
				} else {
					// This is child node(maybe: Service Type or Request Type)
					// Find parent of this node then insert it to this parent
					// node.
					for (NodeParse htmlParse : htmlParses) {
						// Find in list Project
						if ((long) htmlParse.getApi().getApiId() == (long) node.getParentId()) {
							htmlParse.addApi(new NodeParse(node));
						} else {
							// Find in list Service
							for (NodeParse childParse : htmlParse.getListApi()) {
								if ((long) childParse.getApi().getApiId() == (long) node.getParentId()) {
									childParse.addApi(new NodeParse(node));
								}
							}
						}
					}
				}
			}
		}
		return htmlParses;
	}
}
