package com.viettel.data.model.entity;

// Generated Oct 31, 2014 12:52:55 PM by Hibernate Tools 4.3.1

import globaldefine.Config;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import com.viettel.data.query.TokenQuery;

@Entity
@javax.persistence.NamedNativeQueries({
		@javax.persistence.NamedNativeQuery(name = TokenQuery.GET_ALL_TOKEN_NAME, query = TokenQuery.GET_ALL_TOKEN, resultClass = VtStToken.class, hints = @javax.persistence.QueryHint(name = Config.callable, value = "true")),
		@javax.persistence.NamedNativeQuery(name = TokenQuery.GET_TOKEN_BY_USER_ID_NAME, query = TokenQuery.GET_TOKEN_BY_USER_ID_QUERY, resultClass = VtStToken.class, hints = @javax.persistence.QueryHint(name = Config.callable, value = "true")), })
@Table(name = "VT_ST_TOKEN")
public class VtStToken{

	private Long userId;
	private String tokenString;
	private Long startTime;
	private String fullTokenString;

	public VtStToken() {
	}

	public VtStToken(Long userId) {
		this.userId = userId;
	}

	public VtStToken(Long userId, String tokenString, Long startTime) {
		this.userId = userId;
		this.tokenString = tokenString;
		this.startTime = startTime;
	}

	@Id
	@Column(name = "USER_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "TOKEN_STRING", length = 50)
	public String getTokenString() {
		return this.tokenString;
	}

	public void setTokenString(String tokenString) {
		this.tokenString = tokenString;
	}

	@Column(name = "FULL_TOKEN_STRING", length = 100)
	public String getFullTokenString() {
		return fullTokenString == null ? "" : fullTokenString;
	}

	public void setFullTokenString(String fullTokenString) {
		this.fullTokenString = fullTokenString;
	}

	@Column(name = "START_TIME", precision = 22, scale = 0)
	public Long getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}

}
