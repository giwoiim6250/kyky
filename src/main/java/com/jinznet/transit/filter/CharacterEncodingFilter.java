/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 */
package com.jinznet.transit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jinznet.transit.request.wrapper.GetHttpServletRequestWrapper;

/**
 * @author hejian
 * 
 */
public class CharacterEncodingFilter implements Filter {

	private String encoding;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		encoding = filterConfig.getInitParameter("encoding");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 * javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		// 设置请求响应字符编码
		HttpServletResponse rep = (HttpServletResponse) response;
		
		HttpServletRequest req = (HttpServletRequest) request;

		if (req.getMethod().equalsIgnoreCase("get")) {
			req = new GetHttpServletRequestWrapper(req, encoding);
		}
		rep.setCharacterEncoding(encoding);
		req.setCharacterEncoding(encoding);
		chain.doFilter(req, rep);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {

	}

}
