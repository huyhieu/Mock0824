package com.viettel.data.model.entity;

// Generated Aug 6, 2015 9:16:39 AM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * MockRoleShare generated by hbm2java
 */
@Entity
@Table(name = "MOCK_ROLE_SHARE")
public class MockRoleShare {

	private BigDecimal roleId;
	private BigDecimal decription;
	private String decriptionVi;

	public MockRoleShare() {
	}

	public MockRoleShare(BigDecimal roleId) {
		this.roleId = roleId;
	}

	public MockRoleShare(BigDecimal roleId, BigDecimal decription, String decriptionVi) {
		this.roleId = roleId;
		this.decription = decription;
		this.decriptionVi = decriptionVi;
	}

	@Id
	@Column(name = "ROLE_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getRoleId() {
		return this.roleId;
	}

	public void setRoleId(BigDecimal roleId) {
		this.roleId = roleId;
	}

	@Column(name = "DECRIPTION", precision = 22, scale = 0)
	public BigDecimal getDecription() {
		return this.decription;
	}

	public void setDecription(BigDecimal decription) {
		this.decription = decription;
	}

	@Column(name = "DECRIPTION_VI", length = 4000)
	public String getDecriptionVi() {
		return this.decriptionVi;
	}

	public void setDecriptionVi(String decriptionVi) {
		this.decriptionVi = decriptionVi;
	}

}
