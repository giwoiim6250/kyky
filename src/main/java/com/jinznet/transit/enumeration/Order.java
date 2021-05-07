package com.jinznet.transit.enumeration;

public enum Order {

	PRAISE_DESC("praise_num","desc"),
	
	PRAISE_ASC("praise_num","asc"),
	
	ID_DESC("id","desc"),
	
	ID_ASC("id","asc"),
	
	CREATE_TIME_DESC("create_time", "desc"),

	CREATE_TIME_ASC("create_time", "asc");
	
	Order(String field,String type){
		this.field = field;
		this.type = type;
	}
	
	private String field;
	
	private String type;

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
