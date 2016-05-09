/**	
 * <br>
 * Copyright 2015 IFlyTek. All rights reserved.<br>
 * <br>			 
 * Package: com.xiongwu.utils <br>
 * FileName: MailUtil.java <br>
 * <br>
 * @version
 * @author xiongwu@iflytek.com
 * @created 2015年12月10日
 * @last Modified 
 * @history
 */

package com.xiongwu.utils;

import org.apache.commons.mail.EmailException;  
import org.apache.commons.mail.HtmlEmail;  
import org.apache.log4j.Logger;  

import com.xiongwu.lingzhong.domain.dto.MailDto;
  
/**
 * 	邮件发送工具实现类 
 * 
 * @author xiongwu@iflytek.com
 * @created 2015年12月10日 下午2:02:44
 * @lastModified
 * @history
 */

public class MailUtil {
	
	public static void main(String[] args) {
		MailDto mail = new MailDto();
		mail.setHost("smtp.sina.cn"); // 设置邮件服务器,如果不用163的,自己找找看相关的
		mail.setSender("xiongwu3271@sina.cn"); //发送人
		mail.setReceiver("1129203271@qq.com"); // 接收人
		mail.setUsername("xiongwu3271@sina.cn"); // 登录账号,一般都是和邮箱名一样吧
		mail.setPassword("doct287439"); // 发件人邮箱的登录密码
		mail.setSubject("欢迎注册");
		mail.setMessage("您好，欢迎注册众邻。");
		new MailUtil().send(mail);
	}

	//protected final Logger logger = Logger.getLogger(getClass());

	public static boolean send(MailDto mail) {
		// 发送email
		HtmlEmail email = new HtmlEmail();
		try {
			// 这里是SMTP发送服务器的名字：163的如下："smtp.163.com"
			email.setHostName(mail.getHost());
			// 字符编码集的设置
			email.setCharset(MailDto.ENCODEING);
			// 收件人的邮箱
			email.addTo(mail.getReceiver());
			// 发送人的邮箱
			email.setFrom(mail.getSender(), mail.getName());
			// 如果需要认证信息的话，设置认证：用户名-密码。分别为发件人在邮件服务器上的注册名称和密码
			email.setAuthentication(mail.getUsername(), mail.getPassword());
			// 要发送的邮件主题
			email.setSubject(mail.getSubject());
			// 要发送的信息，由于使用了HtmlEmail，可以在邮件内容中使用HTML标签
			email.setMsg(mail.getMessage());
			// 发送
			email.send();
			/*if (logger.isDebugEnabled()) {
				logger.debug(mail.getSender() + " 发送邮件到 " + mail.getReceiver() + "成功");
			}*/
			return true;
		} catch (EmailException e) {
			e.printStackTrace();
			/*logger.info(mail.getSender() + " 发送邮件到 " + mail.getReceiver()
					+ " 失败");*/
			return false;
		}
	}

}
