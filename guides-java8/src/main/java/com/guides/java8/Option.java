package com.guides.java8;

public class Option {

	public Option setIp(String ip) {
		return this;
	}
	
	public Option setPost(String post) {
		return this;
	}
	
	public Option setName(String name) {
		return this;
	}
	
	
	public static void main(String[] args) {
		Option o = new Option();
		
		o.setIp("").setPost("").setName("");
		
	}
	
}
