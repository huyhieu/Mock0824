package com.viettel.data.json.entity;

import java.util.ArrayList;
import java.util.List;

import com.viettel.data.model.entity.MockApi;

public class HtmlParse {

	private Long nodeID;
	private String name;

	private List<HtmlParse> htmlParses;

	public HtmlParse() {
		htmlParses = new ArrayList<HtmlParse>();
	}

	public HtmlParse(MockApi node) {
		this.nodeID = node.getApiId();
		this.name = node.getName();
		htmlParses = new ArrayList<HtmlParse>();
	}

	public HtmlParse(Long id, String name) {
		this.nodeID = id;
		this.name = name;
		htmlParses = new ArrayList<HtmlParse>();
	}

	public void addHtmlParse(MockApi node) {
		htmlParses.add(new HtmlParse(node));
	}

	public Long getNodeID() {
		return nodeID;
	}

	public void setNodeID(Long nodeID) {
		this.nodeID = nodeID;
	}

	public String getName() {
		return name == null ? "" : name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<HtmlParse> getHtmlParses() {
		return htmlParses;
	}

	public void setHtmlParses(List<HtmlParse> htmlParses) {
		this.htmlParses = htmlParses;
	}

}
