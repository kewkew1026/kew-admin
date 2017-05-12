package com.kew.page;

import org.apache.ibatis.session.RowBounds;

import java.io.Serializable;

/**
 * 
 * [文件名称]<br>
 * PageObject <br>
 * <br>
 * [文件描述]<br>
 * 内容摘要.<br>
 * <br>
 * [修改记录]<br>
 * 2011-10-28 ver1.00 创建 chenghong<br>
 * 
 * @author chenghong
 * @version 1.00
 */
public class PageObject implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9020463810611652982L;
	//页面打印字符串
	private String pageString;
	//ibatis对象 用于分页
	private RowBounds rowBounds;
	
	//当前页
	private int currentPage;
	
	//总页数
	private int totalPage;
	
	//每一页
	private int perPage;
	
	//总行数
	private int totalRow;
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPerPage() {
		return perPage;
	}
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	public String getPageString() {
		return pageString;
	}
	public void setPageString(String pageString) {
		this.pageString = pageString;
	}
	public RowBounds getRowBounds() {
		return rowBounds;
	}
	public void setRowBounds(RowBounds rowBounds) {
		this.rowBounds = rowBounds;
	}
	/**
	 * @return 返回 totalRow
	 */
	public int getTotalRow() {
		return totalRow;
	}
	/**
	 * @param totalRow 参数 totalRow
	 */
	public void setTotalRow(int totalRow) {
		this.totalRow = totalRow;
	}
    
	
}
