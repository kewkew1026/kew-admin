package com.kew.page;

import java.io.Serializable;
import java.util.List;

public class Page <T> implements Serializable {
	private static final long serialVersionUID = 1L;

	private long total = 0;

	private List<T> rows = null;
	
	public Page() {
		super();
	}

	public Page(long total, List<T> rows) {
		super();
		this.total = total;
		this.rows = rows;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}
}
