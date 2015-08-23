package com.viettel.data.model.entity;

// Generated Aug 6, 2015 9:16:39 AM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * MockRating generated by hbm2java
 */
@Entity
@Table(name = "MOCK_RATING")
public class MockRating {

	private BigDecimal id;
	private BigDecimal apiId;
	private Date dateRating;
	private BigDecimal userId;
	private BigDecimal value;

	public MockRating() {
	}

	public MockRating(BigDecimal id) {
		this.id = id;
	}

	public MockRating(BigDecimal id, BigDecimal apiId, Date dateRating, BigDecimal userId, BigDecimal value) {
		this.id = id;
		this.apiId = apiId;
		this.dateRating = dateRating;
		this.userId = userId;
		this.value = value;
	}

	@Id
	@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@Column(name = "API_ID", precision = 22, scale = 0)
	public BigDecimal getApiId() {
		return this.apiId;
	}

	public void setApiId(BigDecimal apiId) {
		this.apiId = apiId;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_RATING", length = 7)
	public Date getDateRating() {
		return this.dateRating;
	}

	public void setDateRating(Date dateRating) {
		this.dateRating = dateRating;
	}

	@Column(name = "USER_ID", precision = 22, scale = 0)
	public BigDecimal getUserId() {
		return this.userId;
	}

	public void setUserId(BigDecimal userId) {
		this.userId = userId;
	}

	@Column(name = "VALUE", precision = 22, scale = 0)
	public BigDecimal getValue() {
		return this.value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

}
