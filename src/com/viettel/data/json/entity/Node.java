package com.viettel.data.json.entity;

import java.util.List;

public class Node {
	private String nodeId;
	private String lastModified;
	private String name;
	private String type;
	private String parentId;
	private String headerType;

	private List<Header> headers;
	private URI uri;
	private Method method;
	private Body body;

	public Node() {

	}

	public Node(String nodeId, String lastModified, String name, String type, List<Header> headers, String headerType, URI uri, String parentId, Method method, Body body) {
		this.nodeId = nodeId;
		this.lastModified = lastModified;
		this.name = name;
		this.type = type;
		this.headers = headers;
		this.headerType = headerType;
		this.uri = uri;
		this.parentId = parentId;
		this.method = method;
		this.body = body;
	}

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public String getLastModified() {
		return lastModified;
	}

	public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}

	public String getName() {
		return name == null ? "" : name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type == null ? "" : type.trim();
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Header> getHeaders() {
		return headers;
	}

	public void setHeaders(List<Header> headers) {
		this.headers = headers;
	}

	public String getHeaderType() {
		return headerType;
	}

	public void setHeaderType(String headerType) {
		this.headerType = headerType;
	}

	public URI getUri() {
		return uri;
	}

	public void setUri(URI uri) {
		this.uri = uri;
	}

	public String getParentId() {
		return parentId == null ? "" : parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public Method getMethod() {
		return method;
	}

	public void setMethod(Method method) {
		this.method = method;
	}

	public Body getBody() {
		return body;
	}

	public void setBody(Body body) {
		this.body = body;
	}

}
