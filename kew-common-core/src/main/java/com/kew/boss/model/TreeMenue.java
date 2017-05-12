package com.kew.boss.model;

import java.io.Serializable;
import java.util.List;

/**
 * easyui生成树的基本元素 用类封装
 * @author mark
 *
 */
public class TreeMenue implements Serializable{

	/**
	 * 
	 */
	public TreeMenue() {
		super();
	}
	/**
	 * @param id
	 * @param text
	 */
	public TreeMenue(String id, String text) {
		super();
		this.id = id;
		this.text = text;
	}
	/**
	 * 序列码
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String text;
	private String url;
	private boolean checkbox;
	private List<?> children;
	private String state;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public boolean isCheckbox() {
		return checkbox;
	}
	public void setCheckbox(boolean checkbox) {
		this.checkbox = checkbox;
	}
	public List<?> getChildren() {
		return children;
	}
	public void setChildren(List<?> children) {
		this.children = children;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
}
