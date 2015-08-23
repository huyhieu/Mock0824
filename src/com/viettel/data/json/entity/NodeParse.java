package com.viettel.data.json.entity;

import java.util.ArrayList;
import java.util.List;

import com.viettel.data.model.entity.MockApi;

public class NodeParse {

	private MockApi api;
	private List<NodeParse> listApi;

	public NodeParse() {
		listApi = new ArrayList<NodeParse>();
	}

	public NodeParse(MockApi api) {
		this.api = api;
		this.listApi = new ArrayList<NodeParse>();
	}

	public NodeParse(MockApi api, List<NodeParse> listApi) {
		this.api = api;
		this.listApi = listApi;
	}

	public void addApi(NodeParse api) {
		this.listApi.add(api);
	}

	public MockApi getApi() {
		return api;
	}

	public void setApi(MockApi api) {
		this.api = api;
	}

	public List<NodeParse> getListApi() {
		if (listApi == null) {
			listApi = new ArrayList<NodeParse>();
		}
		return listApi;
	}

	public void setListApi(List<NodeParse> listApi) {
		this.listApi = listApi;
	}

}
