/**	
 * <br>
 * Copyright 2015 IFlyTek. All rights reserved.<br>
 * <br>			 
 * Package: com.xiongwu.lingzhong.service.impl <br>
 * FileName: SendMailServiceImpl.java <br>
 * <br>
 * @version
 * @author xiongwu@iflytek.com
 * @created 2015年12月10日
 * @last Modified 
 * @history
 */

package com.xiongwu.lingzhong.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.xiongwu.lingzhong.base.BasicSysCodeManager;
import com.xiongwu.lingzhong.base.SysCode;
import com.xiongwu.lingzhong.domain.dto.MailDto;
import com.xiongwu.lingzhong.service.ISendMailService;
import com.xiongwu.lingzhong.support.redis.JedisPool;
import com.xiongwu.utils.MailUtil;
import com.xiongwu.utils.ResultUtil;
import com.xiongwu.utils.StringUtil;
import com.xiongwu.utils.dto.ResultDto;

/**
 * 发送邮件实现类
 * 
 * @author xiongwu@iflytek.com
 * @created 2015年12月10日 下午4:50:23
 * @lastModified
 * @history
 */

public class SendMailServiceImpl implements ISendMailService {

	/**
	* 系统参数管理
	*/
	@Autowired
	private BasicSysCodeManager basicSysCodeManager;
	
	/**
	* redis连接池
	*/
	@Autowired
	private JedisPool jedisPool;
	
	/**
	 * 	发送邮件
	 *  
	 *  @param email 邮箱地址
	 *  @param content 邮件内容
	 *  @return
	 *  @author xiongwu@iflytek.com
	 *  @created 2015年12月10日 下午5:15:45
	 *  @lastModified       
	 *  @history
	 */
	public ResultDto sendRegistMessage(String email, String content) {

		if (StringUtil.isNotEmpty(email) && StringUtil.isNotEmpty(content)) {
			try {
				MailDto mail = new MailDto();
				mail.setHost(basicSysCodeManager.getHost());
				mail.setUsername(basicSysCodeManager.getSendName());
				mail.setPassword(basicSysCodeManager.getSendPassword());
				mail.setSubject(basicSysCodeManager.getSubject());
				mail.setSender(basicSysCodeManager.getSender());
				mail.setReceiver(email);
				mail.setMessage(content);
				MailUtil.send(mail);
				return ResultUtil.success(SysCode.SMS_SUCCESS);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return ResultUtil.fail(SysCode.SMS_ERROR);
	}
}
