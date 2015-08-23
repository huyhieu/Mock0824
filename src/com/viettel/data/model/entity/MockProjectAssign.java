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
 * MockProjectAssign generated by hbm2java
 */
@Entity
@Table(name = "MOCK_PROJECT_ASSIGN")
public class MockProjectAssign {

	private BigDecimal id;
	private Date invitedDate;
	private BigDecimal projectId;
	private BigDecimal userIdInvite;
	private BigDecimal userIdReceiver;

	public MockProjectAssign() {
	}

	public MockProjectAssign(BigDecimal id) {
		this.id = id;
	}

	public MockProjectAssign(BigDecimal id, Date invitedDate, BigDecimal projectId, BigDecimal userIdInvite, BigDecimal userIdReceiver) {
		this.id = id;
		this.invitedDate = invitedDate;
		this.projectId = projectId;
		this.userIdInvite = userIdInvite;
		this.userIdReceiver = userIdReceiver;
	}

	@Id
	@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "INVITED_DATE", length = 7)
	public Date getInvitedDate() {
		return this.invitedDate;
	}

	public void setInvitedDate(Date invitedDate) {
		this.invitedDate = invitedDate;
	}

	@Column(name = "PROJECT_ID", precision = 22, scale = 0)
	public BigDecimal getProjectId() {
		return this.projectId;
	}

	public void setProjectId(BigDecimal projectId) {
		this.projectId = projectId;
	}

	@Column(name = "USER_ID_INVITE", precision = 22, scale = 0)
	public BigDecimal getUserIdInvite() {
		return this.userIdInvite;
	}

	public void setUserIdInvite(BigDecimal userIdInvite) {
		this.userIdInvite = userIdInvite;
	}

	@Column(name = "USER_ID_RECEIVER", precision = 22, scale = 0)
	public BigDecimal getUserIdReceiver() {
		return this.userIdReceiver;
	}

	public void setUserIdReceiver(BigDecimal userIdReceiver) {
		this.userIdReceiver = userIdReceiver;
	}

}
