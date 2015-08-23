package com.viettel.data.json.entity;

public class Scheme {
	private String name;
	private String version;

	public String getName() {
		return name == null ? "" : name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return version == null ? "" : version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}
