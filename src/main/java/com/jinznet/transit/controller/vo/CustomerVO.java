/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 */
package com.jinznet.transit.controller.vo;

import com.jinznet.transit.controller.entity.BuyingInfo;

/**
 * @author hejian
 *
 */
public class CustomerVO extends BuyingInfo {

	//展示的用户名
	private String showUserName;
	
	//展示的地址
	private String showAddress;
	
	//年龄
	private int age = 20;

	/**
	 * @return the showUserName
	 */
	public String getShowUserName() {
		return showUserName;
	}

	/**
	 * @return the showAddress
	 */
	public String getShowAddress() {
		return showAddress;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param showUserName the showUserName to set
	 */
	public void setShowUserName(String showUserName) {
		this.showUserName = showUserName;
	}

	/**
	 * @param showAddress the showAddress to set
	 */
	public void setShowAddress(String showAddress) {
		this.showAddress = showAddress;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
}
