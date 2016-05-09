/*
 * Copyright @ 2014 com.iflysse.trains
 * bsdtht 下午02:19:35
 * All right reserved.
 *
 */
package com.xiongwu.lingzhong.base;

/**
 * 	系统常量
 *  
 *  @author xiongwu@iflytek.com
 *  @created 2015年12月9日 下午1:41:13
 *  @lastModified       
 *  @history
 */
public class SysCode {
	
	/**
	 * 登陆页地址
	 */
	public static final String LOGIN_PATH = "/index.do";
	
	/**
	 * true
	 */
	public static final String TRUE = "true";
	
	/**
	 * false
	 */
	public static final String FALSE = "false";
	
	/**
	 * session 用户
	 */
	public static final String CURRENT_USER = "CURRENT_USER";
	
	/**
	 * 重复注册
	 */
	public static final String SMS_DUBREG = "SMS_DUBREG";
	
	/**
	 * 邮箱返回码
	 */
	public static final String MAIL_BACK_CODE = "00";
	
	/**
	 * 发送成功
	 */
	public static final String SMS_SUCCESS = "SMS_SUCCESS";
	/**
	 * 发送失败
	 */
	public static final String SMS_ERROR = "SMS_ERROR";
	
	/**
	 * 是
	 */
	public static final String IS_FLAG = "0";
	
	/**
	 * 否
	 */
	public static final String NO_FLAG = "1";
	
	/**
	 * 特殊字符
	 */
	public static interface USER {
		
		/**
		 * 类名
		 */
		public static final String CLASSNAME = "TZlUserPerson";

		/**
		 * 用户登录名字
		 */
		public static final String CURRENT_USER = "CURRENT_USER";

		/**
		 * 用户名
		 */
		public static final String USERNAME = "loginName";

		/**
		 * 密码
		 */
		public static final String PASSWORD = "password";

		/**
		 * 动态口令
		 */
		public static final String DYNAMIC_PASSWORD = "DYNAMIC_PASSWORD";

		/**
		 * 用户名
		 */
		public static final String LOGINNAME = "loginName";

		/**
		 * 手机号码
		 */
		public static final String PHONE = "mobilePhone";
		
		/**
		 * 邮箱
		 */
		public static final String EMAIL = "email";
		

	}
	
	/**
	 * 	用户类型
	 *  
	 *  @author xiongwu@iflytek.com
	 *  @created 2015年12月9日 下午1:57:53
	 *  @lastModified       
	 *  @history
	 */
	public static interface USER_TYPE {
		
		/**
		 * 注册用户
		 */
		public static final String REGISTER = "1";
		
		/**
		 * 管理员
		 */
		public static final String SADMIN = "2";
	}
}
