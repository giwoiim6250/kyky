package com.jinznet.transit.controller.entity;

import java.util.Date;

public class PraiseInfo {
	private String ip;
	
	//上次访问时间
	private Date lastUpdateTime;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	

}
