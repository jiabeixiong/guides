package com.guides.shared.db.annotations;

public enum DataSourceOptionType {

	WRITE("read"),READ("write");
	
	DataSourceOptionType(String type) {
		this.type = type;
	}
	
	public String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
