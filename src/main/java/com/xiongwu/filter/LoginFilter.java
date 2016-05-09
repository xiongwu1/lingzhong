package com.xiongwu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

import com.xiongwu.lingzhong.base.SysCode;

/**
 * 	 登录过滤器
 *  
 *  @author xiongwu@iflytek.com
 *  @created 2015年11月30日 下午3:38:02
 *  @lastModified       
 *  @history
 */
public class LoginFilter implements Filter {
	
	private Logger log = Logger.getLogger(this.getClass());

	/*
	* 登陆过滤器初始化
	*/
	public void init(FilterConfig filterConfig) throws ServletException {
		log.info("登陆过滤器初始化...");
	}

	/*
	* 登陆过滤处理中
	*/
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		log.info("登陆过滤器处理中...");
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		HttpSession session = req.getSession();
		
		// 获取session中的当前登录用户
		Object currentUser = session.getAttribute(SysCode.USER.CURRENT_USER);
		
		// 拼接首页登陆页面URL
		String loginUrl = req.getContextPath() + SysCode.LOGIN_PATH;
		
		// 获取当前访问资源URL
		String currentServletPath = req.getServletPath();
		
		if(currentServletPath.startsWith("/home/") && null == currentUser){
			res.sendRedirect(loginUrl);
			return;
		}
		
		// 放行
		chain.doFilter(request, response);
	}
	/*
	* 登陆过滤器销毁
	*/
	public void destroy() {
		log.info("登陆过滤器销毁中...");
	}
}