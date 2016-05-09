/**	
 * <br>
 * Copyright 2015 IFlyTek. All rights reserved.<br>
 * <br>			 
 * Package: com.xiongwu.lingzhong.web <br>
 * FileName: SendMailController.java <br>
 * <br>
 * @version
 * @author xiongwu@iflytek.com
 * @created 2015年12月10日
 * @last Modified 
 * @history
 */

package com.xiongwu.lingzhong.web;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xiongwu.lingzhong.base.Message;
import com.xiongwu.lingzhong.base.SysCode;
import com.xiongwu.lingzhong.service.ISendMailService;
import com.xiongwu.lingzhong.service.IUserService;
import com.xiongwu.utils.ResultUtil;
import com.xiongwu.utils.StringUtil;
import com.xiongwu.utils.dto.ResultDto;

/**
 *  发送邮件控制器
 *  
 *  @author xiongwu@iflytek.com
 *  @created 2015年12月10日 下午4:20:12
 *  @lastModified       
 *  @history           
 */
@Controller
public class SendMailController {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private ISendMailService sendMailService;
	
	/**
	 * 	发送邮箱动态口令--注册
	 *  
	 *  @param email 邮箱
	 *  @param response
	 *  @param session
	 *  @author xiongwu@iflytek.com
	 *  @created 2015年12月10日 下午4:33:35
	 *  @lastModified       
	 *  @history
	 */
	@RequestMapping(value="/register/dynamicpassword.do")
	public void sendMessageForRegist(String email, HttpServletResponse response,HttpSession session){
		ResultDto rd=null;
		rd=userService.checkUserByEmail(email);
		//邮箱唯一则发送邮件
		if(StringUtil.equals(rd.getFlag(), SysCode.TRUE)){
			String dynamicCode=StringUtil.getRandNum(6);
			session.setAttribute(SysCode.USER.DYNAMIC_PASSWORD, dynamicCode);
			String content="温馨提示：此邮件为【众邻-在线云社交平台】系统发送，请您在2分钟内完成邮箱校验,校验码为："+dynamicCode+",谢谢合作！";
			rd=sendMailService.sendRegistMessage(email,content);
		}
		ResultUtil.sendResult(response, rd);
	}
	
	/**
	 * 	发送邮箱动态口令--找回密码
	 *  
	 *  @param email 邮箱
	 *  @param response
	 *  @param session
	 *  @author xiongwu@iflytek.com
	 *  @created 2015年12月10日 下午4:33:35
	 *  @lastModified       
	 *  @history
	 */
	@RequestMapping(value="/forgot/dynamicpassword.do")
	public void sendMessageForgot(String email, HttpServletResponse response,HttpSession session) {
		ResultDto rd=null;
		rd=userService.checkUserByEmail(email);
		//邮箱存在则发送邮件
		if(!StringUtil.equals(rd.getFlag(), SysCode.TRUE)){
			String dynamicCode=StringUtil.getRandNum(6);
			session.setAttribute(SysCode.USER.DYNAMIC_PASSWORD, dynamicCode);
			String content="【找回密码】温馨提示：此邮件为<众邻-在线云社交平台>系统发送，请您在5分钟内完成邮箱校验,校验码为："+dynamicCode+",谢谢合作！";
			rd=sendMailService.sendRegistMessage(email,content);
		}else {
			//验证码错误
			rd = new ResultDto(SysCode.FALSE, Message.EMAIL_RANDOM_ERROR);
		}
		ResultUtil.sendResult(response, rd);
	}
	
	/**
	 * 	清空动态口令
	 *  
	 *  @param session
	 *  @param response
	 *  @author xiongwu@iflytek.com
	 *  @created 2015年12月10日 下午4:22:17
	 *  @lastModified       
	 *  @history
	 */
	@RequestMapping(value="/sendMail/cleardynamicpassword.do")
	public void clearDynamicCodeSessionForRegist(HttpSession session,HttpServletResponse response){
		session.removeAttribute(SysCode.USER.DYNAMIC_PASSWORD);
		ResultUtil.sendMsg(response, ResultUtil.success(SysCode.TRUE));
	}

}




