package com.jinznet.transit.controller.entity;

public class Pagination {
	private int pageSize = 6;
	
	private int current = 1;
	
	public Pagination() {
	}
	
	

	public Pagination(int pageSize, int current) {
		super();
		this.pageSize = pageSize;
		this.current = current;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

}
