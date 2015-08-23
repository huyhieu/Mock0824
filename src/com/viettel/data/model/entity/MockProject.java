package com.viettel.data.model.entity;

// Generated Aug 6, 2015 9:16:39 AM by Hibernate Tools 4.3.1

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author hieunq5
 * 
 */
@Entity
@javax.persistence.NamedNativeQueries({})
@Table(name = "MOCK_PROJECT")
public class MockProject {

	private Long projectId;
	private Long userCreateId;
	private String projectName;
	private Date dateCreate;

	public MockProject() {
	}

	public MockProject(Long projectId) {
		this.projectId = projectId;
	}

	public MockProject(Long projectId, Long userCreateId) {
		this.projectId = projectId;
		this.userCreateId = userCreateId;
	}

	@Id
	@Column(name = "PROJECT_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Long getProjectId() {
		return this.projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	@Column(name = "USER_CREATE_ID", precision = 22, scale = 0)
	public Long getUserCreateId() {
		return this.userCreateId;
	}

	public void setUserCreateId(Long userCreateId) {
		this.userCreateId = userCreateId;
	}

	@Column(name = "PROJECT_NAME", length = 200)
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_CREATE")
	public Date getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}

}
