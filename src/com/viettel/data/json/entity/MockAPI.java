package com.viettel.data.json.entity;

import java.util.List;

import com.viettel.data.model.entity.MockApi;
import com.viettel.data.model.entity.MockApiBody;
import com.viettel.data.model.entity.MockApiHeader;
import com.viettel.data.model.entity.MockApiUri;

public class MockAPI {
	private String version;
	private List<MockApi> nodes;

	public MockAPI() {
	}

	public MockAPI(String version) {
		this.version = version;
	}

	public MockAPI(List<MockApi> apis) {
		this.version = new String("V1");
		this.nodes = apis;

		// Remove nested MockApi inside Body, Header, Uri
		removeNestedObjects(apis);

	}

	public MockAPI(String version, List<MockApi> apis) {
		this.version = version;
		this.nodes = apis;

		// Remove nested MockApi inside Body, Header, Uri
		removeNestedObjects(apis);
	}

	private void removeNestedObjects(List<MockApi> apis) {
		if (apis != null && apis.size() > 0) {
			for (MockApi api : apis) {
				removeNestedObject(api);
			}
		}
	}

	private void removeNestedObject(MockApi api) {
		if (api.getBody() != null) {
			removeNestedObInBody(api.getBody());
		}
		if (api.getUri() != null) {
			removeNestedObInUri(api.getUri());
		}
		if (api.getHeaders() != null) {
			removeNestedObInHeaders(api.getHeaders());
		}
	}

	private void removeNestedObInUri(MockApiUri uri) {
		if (uri.getMockApi() != null) {
			uri.setMockApi(null);
		}
	}

	private void removeNestedObInBody(MockApiBody body) {
		if (body.getMockApi() != null) {
			body.setMockApi(null);
		}
	}

	private void removeNestedObInHeaders(List<MockApiHeader> headers) {
		for (MockApiHeader header : headers) {
			header.setMockApi(null);
		}
	}

	public String getVersion() {
		return version == null ? "" : version.trim();
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public List<MockApi> getNodes() {
		return nodes;
	}

	public void setNodes(List<MockApi> nodes) {
		this.nodes = nodes;
	}

}
