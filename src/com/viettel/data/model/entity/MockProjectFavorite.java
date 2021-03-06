package com.viettel.data.model.entity;

// Generated Aug 6, 2015 9:16:39 AM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * MockProjectFavorite generated by hbm2java
 */
@Entity
@Table(name = "MOCK_PROJECT_FAVORITE")
public class MockProjectFavorite {

	private BigDecimal id;
	private BigDecimal dateAddFavorites;
	private BigDecimal projectId;
	private BigDecimal userId;

	public MockProjectFavorite() {
	}

	public MockProjectFavorite(BigDecimal id) {
		this.id = id;
	}

	public MockProjectFavorite(BigDecimal id, BigDecimal dateAddFavorites, BigDecimal projectId, BigDecimal userId) {
		this.id = id;
		this.dateAddFavorites = dateAddFavorites;
		this.projectId = projectId;
		this.userId = userId;
	}

	@Id
	@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@Column(name = "DATE_ADD_FAVORITES", precision = 22, scale = 0)
	public BigDecimal getDateAddFavorites() {
		return this.dateAddFavorites;
	}

	public void setDateAddFavorites(BigDecimal dateAddFavorites) {
		this.dateAddFavorites = dateAddFavorites;
	}

	@Column(name = "PROJECT_ID", precision = 22, scale = 0)
	public BigDecimal getProjectId() {
		return this.projectId;
	}

	public void setProjectId(BigDecimal projectId) {
		this.projectId = projectId;
	}

	@Column(name = "USER_ID", precision = 22, scale = 0)
	public BigDecimal getUserId() {
		return this.userId;
	}

	public void setUserId(BigDecimal userId) {
		this.userId = userId;
	}

}
