package com.viettel.data.json.entity;

import java.util.ArrayList;
import java.util.List;

public class MSAPI {
	private String version;
	private List<Node> nodes;

	public MSAPI() {

	}

	public MSAPI(String version, List<Node> nodes) {
		this.version = version;
		this.nodes = nodes;
	}

	public String getVersion() {
		return version == null ? "" : version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public List<Node> getNodes() {
		if (nodes == null) {
			nodes = new ArrayList<Node>();
		}
		return nodes;
	}

	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}

}
