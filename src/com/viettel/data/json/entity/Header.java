package com.viettel.data.json.entity;

public class Header {
	private boolean enabled;
	private String name;
	private String value;

	public Header() {

	}

	public Header(String name, String value) {
		this.name = name;
		this.value = value;
	}

	public Header(boolean enabled, String name, String value) {
		this.enabled = enabled;
		this.name = name;
		this.value = value;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
