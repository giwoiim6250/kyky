/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 */
package com.jinznet.transit.request.wrapper;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.springframework.util.StringUtils;

/**
 * @author hejian
 *
 */
public class GetHttpServletRequestWrapper extends HttpServletRequestWrapper {

	private String charset = "UTF-8";

	/**
	 * @param request
	 */
	public GetHttpServletRequestWrapper(HttpServletRequest request, String charset) {
		super(request);
		this.charset = charset;
	}
	
	/* (non-Javadoc)
	 * @see javax.servlet.ServletRequestWrapper#getParameter(java.lang.String)
	 */
	@Override
	public String getParameter(String name) {
		String value = super.getParameter(name);
		if(!StringUtils.isEmpty(name)){
			try {
				value = new String(value.getBytes("ISO-8859-1"),charset);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return value;
	}

}
