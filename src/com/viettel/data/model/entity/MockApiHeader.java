package com.viettel.data.model.entity;

// Generated Aug 6, 2015 9:16:39 AM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author hieunq5
 * 
 */
@Entity
@Table(name = "MOCK_API_HEADER")
public class MockApiHeader {

	private Long headerId;
	private String headerName;
	private String headerValue;
	private Long mockId;

	private MockApi mockApi;

	public MockApiHeader() {
	}

	public MockApiHeader(Long headerId) {
		this.headerId = headerId;
	}

	public MockApiHeader(Long headerId, String name, String value, Long mockId) {
		this.headerId = headerId;
		this.headerName = name;
		this.headerValue = value;
		this.mockId = mockId;
	}

	@Id
	@Column(name = "HEADER_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Long getHeaderId() {
		return headerId;
	}

	public void setHeaderId(Long headerId) {
		this.headerId = headerId;
	}

	@Column(name = "HEADER_NAME", length = 200)
	public String getHeaderName() {
		return headerName;
	}

	public void setHeaderName(String headerName) {
		this.headerName = headerName;
	}

	@Column(name = "HEADER_VALUE", length = 200)
	public String getHeaderValue() {
		return headerValue;
	}

	public void setHeaderValue(String headerValue) {
		this.headerValue = headerValue;
	}

	@Column(name = "MOCK_ID", precision = 22, scale = 0)
	public Long getMockId() {
		return mockId;
	}

	public void setMockId(Long mockId) {
		this.mockId = mockId;
	}

	@ManyToOne
	@JoinColumn(name = "MOCK_ID", insertable = false, updatable = false)
	public MockApi getMockApi() {
		return mockApi;
	}

	public void setMockApi(MockApi mockApi) {
		this.mockApi = mockApi;
	}

}
