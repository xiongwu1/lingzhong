/**	
 * <br>
 * Copyright 2015 IFlyTek. All rights reserved.<br>
 * <br>			 
 * Package: com.xiongwu.lingzhong.domain.dto <br>
 * FileName: UserDto.java <br>
 * <br>
 * @version
 * @author xiongwu@iflytek.com
 * @created 2015年12月15日
 * @last Modified 
 * @history
 */

package com.xiongwu.lingzhong.domain.dto;

/**
 * 	用户Dto
 *  
 *  @author xiongwu@iflytek.com
 *  @created 2015年12月15日 下午7:52:14
 *  @lastModified       
 *  @history           
 */

public class LoginUserDto {
	
	/**
	 * id
	 */
	private String objectid;
	
	/**
	 * 登陆名
	 */
	private String loginName;
	
	/**
	 * 昵称
	 */
	private String nickName;
	
	/**
	 * 密码
	 */
	private String password;
	
	/**
	 * 验证码
	 */
	private String validateCode;
	
	/**
	 * 手机号
	 */
	private String mobilePhone;
	
	/**
	 * 邮箱
	 */
	private String email;
	
	/**
	 * 是否加关注
	 */
	private String isAttent;

	public String getObjectid() {
		return objectid;
	}

	public void setObjectid(String objectid) {
		this.objectid = objectid;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getValidateCode() {
		return validateCode;
	}

	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIsAttent() {
		return isAttent;
	}

	public void setIsAttent(String isAttent) {
		this.isAttent = isAttent;
	}
}




