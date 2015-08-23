package com.viettel.data.model.entity;

// Generated Aug 6, 2015 9:16:39 AM by Hibernate Tools 4.3.1

import globaldefine.Config;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.viettel.data.query.MockApiQuery;

/**
 * @author hieunq5
 * 
 */
@Entity
@javax.persistence.NamedNativeQueries({

		@javax.persistence.NamedNativeQuery(name = MockApiQuery.GET_API_BY_NAME_URL_NAME, query = MockApiQuery.GET_API_BY_NAME_URL_QUERY, resultClass = MockApi.class, hints = @javax.persistence.QueryHint(name = Config.callable, value = "true")),
		@javax.persistence.NamedNativeQuery(name = MockApiQuery.GET_API_BY_NAME_NAME, query = MockApiQuery.GET_API_BY_NAME, resultClass = MockApi.class, hints = @javax.persistence.QueryHint(name = Config.callable, value = "true")),
		@javax.persistence.NamedNativeQuery(name = MockApiQuery.GET_ALL_API_BY_USER_ID_NAME, query = MockApiQuery.GET_ALL_API_BY_USER_ID, resultClass = MockApi.class, hints = @javax.persistence.QueryHint(name = Config.callable, value = "true")) })
@Table(name = "MOCK_API")
public class MockApi {

	private Long apiId;
	private String name;
	private Long mockType;
	private Date lastModified;
	private Long parentId;
	private String headerType;
	private Long listHeader;
	private String headerList;
	private Long userId;
	private String nameUrl;
	private String bodyDefault;

	private List<MockApiHeader> headers;
	private MockApiBody body;
	private MockApiUri uri;

	public MockApi() {
	}

	public MockApi(Long apiId) {
		this.apiId = apiId;
	}

	public MockApi(Long apiId, List<MockApiHeader> apiHeaders) {
		this.apiId = apiId;
		this.headers = apiHeaders;
	}

	public MockApi(Long apiId, String name, Long parentId, String headerType, String nameUrl, String bodyDefault) {
		this.apiId = apiId;
		this.name = name;
		this.parentId = parentId;
		this.headerType = headerType;
		this.nameUrl = nameUrl;
		this.bodyDefault = bodyDefault;
	}

	@Id
	@Column(name = "API_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Long getApiId() {
		return this.apiId;
	}

	public void setApiId(Long apiId) {
		this.apiId = apiId;
	}

	@Column(name = "NAME", length = 500)
	public String getName() {
		return this.name == null ? "" : name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "MOCK_TYPE", precision = 22, scale = 0)
	public Long getMockType() {
		return mockType;
	}

	public void setMockType(Long mockType) {
		this.mockType = mockType;
	}

	@Column(name = "HEADERS", precision = 22, scale = 0)
	public Long getListHeader() {
		return listHeader;
	}

	public void setListHeader(Long listHeader) {
		this.listHeader = listHeader;
	}

	@Column(name = "HEADER_LIST", length = 200)
	public String getHeaderList() {
		return headerList == null ? "" : headerList;
	}

	public void setHeaderList(String headerList) {
		this.headerList = headerList;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_MODIFIED")
	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	@Column(name = "PARENT_ID", precision = 22, scale = 0)
	public Long getParentId() {
		return this.parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	@Column(name = "HEADER_TYPE", length = 4000)
	public String getHeaderType() {
		return this.headerType == null ? "" : headerType;
	}

	public void setHeaderType(String headerType) {
		this.headerType = headerType;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "mockApi", cascade = CascadeType.ALL)
	public List<MockApiHeader> getHeaders() {
		return headers;
	}

	public void setHeaders(List<MockApiHeader> headers) {
		this.headers = headers;
	}

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "mockApi")
	public MockApiBody getBody() {
		return body;
	}

	public void setBody(MockApiBody body) {
		this.body = body;
	}

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "mockApi")
	public MockApiUri getUri() {
		return uri;
	}

	public void setUri(MockApiUri uri) {
		this.uri = uri;
	}

	@Column(name = "USER_ID", precision = 22, scale = 0)
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "NAME_URL", length = 100)
	public String getNameUrl() {
		return nameUrl;
	}

	public void setNameUrl(String nameUrl) {
		this.nameUrl = nameUrl;
	}

	@Column(name = "BODY_DEFAULT", length = 4000)
	public String getBodyDefault() {
		return bodyDefault;
	}

	public void setBodyDefault(String bodyDefault) {
		this.bodyDefault = bodyDefault;
	}
}
