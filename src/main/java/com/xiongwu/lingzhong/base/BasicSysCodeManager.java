/**	
 * <br>
 * Copyright 2011 IFlyTek. All rights reserved.<br>
 * <br>			 
 * Package: com.iflytek.op.base <br>
 * FileName: BasicSysCodeManager.java <br>
 * <br>
 * @version
 * @author xsding@iflytek.com
 * @created 2014-5-26
 * @last Modified 
 * @history
 */
package com.xiongwu.lingzhong.base;

/**
 * 	系统配置注入类
 *  
 *  @author xiongwu@iflytek.com
 *  @created 2015年12月10日 下午2:18:39
 *  @lastModified       
 *  @history
 */
public class BasicSysCodeManager {

	/**
	 * 邮件服务器
	 */
	private String host;
	
	/**
	 * 邮箱登陆账号
	 */
	private String sendName;
	
	/**
	 * 发件人邮箱的登录密码
	 */
	private String sendPassword;
	
	/**
	 *  发件人名称
	 */
	private String sender;
	
	
	/**
	 * 邮件主题
	 */
	private String subject;
	
	/**
	 * 上传头像路径
	 */
	private String uploadHeadUrl;
	
	/**
	 * 上传头像保存格式
	 */
	private String imgFormat;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getSendName() {
		return sendName;
	}

	public void setSendName(String sendName) {
		this.sendName = sendName;
	}

	public String getSendPassword() {
		return sendPassword;
	}

	public void setSendPassword(String sendPassword) {
		this.sendPassword = sendPassword;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getUploadHeadUrl() {
		return uploadHeadUrl;
	}

	public void setUploadHeadUrl(String uploadHeadUrl) {
		this.uploadHeadUrl = uploadHeadUrl;
	}

	public String getImgFormat() {
		return imgFormat;
	}

	public void setImgFormat(String imgFormat) {
		this.imgFormat = imgFormat;
	}
}
