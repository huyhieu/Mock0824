package com.viettel.data.model.entity;

// Generated Aug 6, 2015 9:16:39 AM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author hieunq5
 * 
 */
@Entity
@Table(name = "MOCK_API_URI")
public class MockApiUri {

	private Long uriId;
	private String link;
	private String schemeName;
	private String schemeVersion;
	private Long mockId;

	private MockApi mockApi;

	public MockApiUri() {
	}

	public MockApiUri(Long uriId) {
		this.uriId = uriId;
	}

	@Id
	@Column(name = "URI_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Long getUriId() {
		return uriId;
	}

	public void setUriId(Long uriId) {
		this.uriId = uriId;
	}

	@Column(name = "LINK", length = 800)
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Column(name = "SCHEME_NAME", length = 100)
	public String getSchemeName() {
		return schemeName;
	}

	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}

	@Column(name = "SCHEME_VERSION", length = 100)
	public String getSchemeVersion() {
		return schemeVersion;
	}

	public void setSchemeVersion(String schemeVersion) {
		this.schemeVersion = schemeVersion;
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
