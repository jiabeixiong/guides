package com.guides.shared.session.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ConsumerHttpServletRequest extends HttpServletRequestWrapper {

	private HttpServletRequest request;

	private HttpServletResponse response;

	public ConsumerHttpServletRequest(HttpServletRequest request, HttpServletResponse response) {
		super(request);
		this.request = request;
		this.response = response;
	}
	

	@Override
	public HttpSession getSession() {
		
		
		return new ConsumerHttpSession(request,response);
	}
	
}
