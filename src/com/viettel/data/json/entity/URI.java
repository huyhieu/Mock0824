package com.viettel.data.json.entity;

public class URI {
	private String path;
	private Scheme scheme;

	public URI() {
	}

	public URI(String path, Scheme scheme) {
		this.path = path;
		this.scheme = scheme;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Scheme getScheme() {
		return scheme;
	}

	public void setScheme(Scheme scheme) {
		this.scheme = scheme;
	}

}
