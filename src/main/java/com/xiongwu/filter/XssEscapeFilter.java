package com.xiongwu.filter;

/*
 * Copyright @ 2015 com.iflysse.trains
 * portal 下午7:45:22
 * All right reserved.
 *
 */

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.xiongwu.wrapper.XssHttpServletRequestWrapper;
/**
 * 	过滤器
 *  
 *  @author xiongwu@iflytek.com
 *  @created 2015年11月30日 下午3:38:27
 *  @lastModified       
 *  @history
 */
public class XssEscapeFilter implements Filter {

	FilterConfig filterConfig = null;

	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

	public void destroy() {
		this.filterConfig = null;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		chain.doFilter(new XssHttpServletRequestWrapper((HttpServletRequest) request), response);
	}
}
