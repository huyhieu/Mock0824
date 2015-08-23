package com.viettel.data.json.entity;

public class Method {
	private boolean requestBody;
	private String link;
	private String name; // POST/ GET

	public Method() {

	}

	public Method(boolean requestBody, String link, String name) {
		this.requestBody = requestBody;
		this.link = link;
		this.name = name;
	}

	public boolean isRequestBody() {
		return requestBody;
	}

	public void setRequestBody(boolean requestBody) {
		this.requestBody = requestBody;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
