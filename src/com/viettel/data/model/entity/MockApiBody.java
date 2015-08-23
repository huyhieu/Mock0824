package com.viettel.data.model.entity;

// Generated Aug 6, 2015 9:16:39 AM by Hibernate Tools 4.3.1

import globaldefine.Config;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.viettel.data.query.MockApiBodyQuery;

/**
 * @author hieunq5
 * 
 */
@Entity
@javax.persistence.NamedNativeQueries({
	@javax.persistence.NamedNativeQuery(name = MockApiBodyQuery.GET_API_BODY_BY_MOCK_ID_NAME, query = MockApiBodyQuery.GET_API_BODY_BY_MOCK_ID_QUERY, resultClass = MockApiBody.class, hints = @javax.persistence.QueryHint(name = Config.callable, value = "true")), })
@Table(name = "MOCK_API_BODY")
public class MockApiBody {

	private Long bodyId;
	private Long bodyAutoLength;
	private Long bodyType;
	private String bodyInput;
	private String bodyOutput;
	private Long mockId;

	private MockApi mockApi;

	public MockApiBody() {
	}

	public MockApiBody(Long bodyId) {
		this.bodyId = bodyId;
	}

	@Id
	@Column(name = "BODY_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Long getBodyId() {
		return bodyId;
	}

	public void setBodyId(Long bodyId) {
		this.bodyId = bodyId;
	}

	@Column(name = "BODY_AUTO_LENGTH", precision = 22, scale = 0)
	public Long getBodyAutoLength() {
		return bodyAutoLength;
	}

	public void setBodyAutoLength(Long bodyAutoLength) {
		this.bodyAutoLength = bodyAutoLength;
	}

	@Column(name = "BODY_TYPE", precision = 22, scale = 0)
	public Long getBodyType() {
		return bodyType;
	}

	public void setBodyType(Long bodyType) {
		this.bodyType = bodyType;
	}

	@Column(name = "BODY_INPUT", length = 4000)
	public String getBodyInput() {
		return bodyInput;
	}

	public void setBodyInput(String bodyInput) {
		this.bodyInput = bodyInput;
	}

	@Column(name = "BODY_OUTPUT", length = 4000)
	public String getBodyOutput() {
		return bodyOutput;
	}

	public void setBodyOutput(String bodyOutput) {
		this.bodyOutput = bodyOutput;
	}

	@Column(name = "MOCK_ID", precision = 22, scale = 0)
	public Long getMockId() {
		return mockId;
	}

	public void setMockId(Long mockId) {
		this.mockId = mockId;
	}

	@OneToOne
	@JoinColumn(name = "MOCK_ID", insertable = false, updatable = false)
	public MockApi getMockApi() {
		return mockApi;
	}

	public void setMockApi(MockApi mockApi) {
		this.mockApi = mockApi;
	}

}
