package com.viettel.data.json.entity;

public class Body {
	private boolean autoSetLength;
	private String textBody;
	private String bodyType;

	public Body() {
	}

	public Body(boolean autoSetLengthm, String textBody, String bodyType) {
		this.autoSetLength = autoSetLengthm;
		this.textBody = textBody;
		this.bodyType = bodyType;
	}

	public boolean isAutoSetLength() {
		return autoSetLength;
	}

	public void setAutoSetLength(boolean autoSetLength) {
		this.autoSetLength = autoSetLength;
	}

	public String getTextBody() {
		return textBody;
	}

	public void setTextBody(String textBody) {
		this.textBody = textBody;
	}

	public String getBodyType() {
		return bodyType;
	}

	public void setBodyType(String bodyType) {
		this.bodyType = bodyType;
	}

}
