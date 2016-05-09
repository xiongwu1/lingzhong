/*
* Copyright @ 2014 com.iflysse.trains
* portal 下午02:00:26
* All right reserved.
*
*/
package com.xiongwu.utils;

import javax.servlet.http.HttpSession;

import com.xiongwu.lingzhong.base.SysCode;
import com.xiongwu.lingzhong.domain.dto.LoginUserDto;

/**
 * 	Session处理工具
 *  
 *  @author xiongwu@iflytek.com
 *  @created 2015年12月16日 下午5:14:21
 *  @lastModified       
 *  @history
 */
public class SessionUtil {
	
	/**
	 * 	获取当前用户
	 *  
	 *  @param session
	 *  @return
	 *  @author xiongwu@iflytek.com
	 *  @created 2015年12月16日 下午5:14:07
	 *  @lastModified       
	 *  @history
	 */
	public static LoginUserDto getCurrentUser(HttpSession session) {
		return (LoginUserDto)session.getAttribute(SysCode.CURRENT_USER);
	}
	
	/**
	 * 	获取验证码
	 *  
	 *  @param session
	 *  @return
	 *  @author xiongwu@iflytek.com
	 *  @created 2015年12月16日 下午5:13:52
	 *  @lastModified       
	 *  @history
	 */
	public static String getRandomCode(HttpSession session){
		return (String) session.getAttribute("RANDOM_CODE");
	}
	
	/**
	 * 	移除session信息
	 *  
	 *  @param session
	 *  @author xiongwu@iflytek.com
	 *  @created 2015年12月16日 下午5:13:28
	 *  @lastModified       
	 *  @history
	 */
	public static void removeSession(HttpSession session) {
		// 从session中移除当前用户信息
		try {
			session.removeAttribute(SysCode.CURRENT_USER);
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
	
}
