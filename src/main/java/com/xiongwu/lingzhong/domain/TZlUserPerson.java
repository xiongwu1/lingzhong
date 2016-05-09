package com.xiongwu.lingzhong.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.annotations.AccessType;
import org.hibernate.annotations.GenericGenerator;

/**
 * 众邻-个人用户表
 * 
 * @author xiongwu@iflytek.com
 * @created 2015年11月30日 上午10:52:06
 * @lastModified
 * @history
 */
@org.hibernate.annotations.Entity(selectBeforeUpdate = true, dynamicInsert = true, dynamicUpdate = true)
@javax.persistence.Entity
@javax.persistence.Table(name = "T_ZL_USER_PERSON")
@GenericGenerator(name = "system_uuid", strategy = "uuid")
@AccessType("field")
public class TZlUserPerson {
	public TZlUserPerson() {

	}

	/**
	 * 主键ID
	 */
	@Id
	@GeneratedValue(generator = "system_uuid")
	@Column(name = "OBJECTID", length = 50)
	private String objectid;
	/**
	 * 登录名
	 */
	@Column(name = "LOGIN_NAME", length = 50)
	private String loginName;
	/**
	 * 密码(MD5加密)
	 */
	@Column(name = "PASSWORD", length = 50)
	private String password;
	/**
	 * 昵称
	 */
	@Column(name = "NICK_NAME", length = 50)
	private String nickName;
	
	/**
	 * 头像
	 */
	@Column(name = "HEAD_PORTRAIT", length = 100)
	private String headPortrait;
	
	/**
	 * 真实姓名
	 */
	@Column(name = "REAL_NAME", length = 50)
	private String realName;
	/**
	 * 所在地-省
	 */
	@Column(name = "SZD_PROVINCE", length = 20)
	private String szdProvince;
	/**
	 * 所在地-市
	 */
	@Column(name = "SZD_CITY", length = 20)
	private String szdCity;
	/**
	 * 性别（0男 1女）
	 */
	@Column(name = "GENDER", length = 1)
	private String gender;
	/**
	 * 性取向（0男 1女）
	 */
	@Column(name = "XQX", length = 1)
	private String xqx;
	/**
	 * 感情状况（0单身 1恋爱 2订婚 3已婚 4离婚 5丧偶）
	 */
	@Column(name = "GQZK", length = 1)
	private String gqzk;
	/**
	 * 生日
	 */
	@Column(name = "BIRTHDAY", length = 14)
	private String birthday;
	/**
	 * 血型（0A型 1B型 2AB型 3O型）
	 */
	@Column(name = "BLOOD_TYPE", length = 1)
	private String bloodType;
	/**
	 * 邮箱
	 */
	@Column(name = "EMAIL", length = 50)
	private String email;
	/**
	 * 手机号
	 */
	@Column(name = "MOBILE_PHONE", length = 50)
	private String mobilePhone;
	/**
	 * QQ
	 */
	@Column(name = "QQ", length = 20)
	private String qq;
	/**
	 * 个性签名
	 */
	@Column(name = "GXQM", length = 200)
	private String gxqm;
	/**
	 * 注册时间
	 */
	@Column(name = "REGISTERED_TIME", length = 14)
	private String registeredTime;
	/**
	 * 修改时间
	 */
	@Column(name = "UPDATE_TIME", length = 14)
	private String updateTime;
	/**
	 * 上次登录时间
	 */
	@Column(name = "LAST_LOGIN_TIME", length = 14)
	private String lastLoginTime;
	/**
	 * 是否锁定（0是1否）
	 */
	@Column(name = "IS_LOCK", length = 1)
	private String isLock;
	/**
	 * 等级制度
	 */
	@Column(name = "DJZD", length = 1)
	private String djzd;
	/**
	 * 用户类型（1注册用户 2管理员）
	 */
	@Column(name = "USER_TYPE", length = 1)
	private String userType;
	
	/**
	 * 邮箱验证码
	 */
	@Transient
	private String emailValidateCode;

	/**
	 * 主键ID
	 */
	public String getObjectid() {
		return this.objectid;
	}

	/**
	 * 主键ID
	 *
	 * @param objectid
	 */
	public void setObjectid(String objectid) {
		this.objectid = objectid;
	}

	/**
	 * 登录名
	 */
	public String getLoginName() {
		return this.loginName;
	}

	/**
	 * 登录名
	 *
	 * @param loginName
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	/**
	 * 密码(MD5加密)
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * 密码(MD5加密)
	 *
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 昵称
	 */
	public String getNickName() {
		return this.nickName;
	}

	/**
	 * 昵称
	 *
	 * @param nickName
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	/**
	 * 头像
	 */
	public String getHeadPortrait() {
		return headPortrait;
	}

	/**
	 * 头像
	 *
	 * @param headPortrait
	 */
	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}

	/**
	 * 真实姓名
	 */
	public String getRealName() {
		return this.realName;
	}

	/**
	 * 真实姓名
	 *
	 * @param realName
	 */
	public void setRealName(String realName) {
		this.realName = realName;
	}

	/**
	 * 所在地-省
	 */
	public String getSzdProvince() {
		return this.szdProvince;
	}

	/**
	 * 所在地-省
	 *
	 * @param szdProvince
	 */
	public void setSzdProvince(String szdProvince) {
		this.szdProvince = szdProvince;
	}

	/**
	 * 所在地-市
	 */
	public String getSzdCity() {
		return this.szdCity;
	}

	/**
	 * 所在地-市
	 *
	 * @param szdCity
	 */
	public void setSzdCity(String szdCity) {
		this.szdCity = szdCity;
	}

	/**
	 * 性别（0男 1女）
	 */
	public String getGender() {
		return this.gender;
	}

	/**
	 * 性别（0男 1女）
	 *
	 * @param gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * 性取向（0男 1女）
	 */
	public String getXqx() {
		return this.xqx;
	}

	/**
	 * 性取向（0男 1女）
	 *
	 * @param xqx
	 */
	public void setXqx(String xqx) {
		this.xqx = xqx;
	}

	/**
	 * 感情状况（0单身 1恋爱 2订婚 3已婚 4离婚 5丧偶）
	 */
	public String getGqzk() {
		return this.gqzk;
	}

	/**
	 * 感情状况（0单身 1恋爱 2订婚 3已婚 4离婚 5丧偶）
	 *
	 * @param gqzk
	 */
	public void setGqzk(String gqzk) {
		this.gqzk = gqzk;
	}

	/**
	 * 生日
	 */
	public String getBirthday() {
		return this.birthday;
	}

	/**
	 * 生日
	 *
	 * @param birthday
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	/**
	 * 血型（0A型 1B型 2AB型 3O型）
	 */
	public String getBloodType() {
		return this.bloodType;
	}

	/**
	 * 血型（0A型 1B型 2AB型 3O型）
	 *
	 * @param bloodType
	 */
	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	/**
	 * 邮箱
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * 邮箱
	 *
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 手机号
	 */
	public String getMobilePhone() {
		return this.mobilePhone;
	}

	/**
	 * 手机号
	 *
	 * @param mobilePhone
	 */
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	/**
	 * QQ
	 */
	public String getQq() {
		return this.qq;
	}

	/**
	 * QQ
	 *
	 * @param qq
	 */
	public void setQq(String qq) {
		this.qq = qq;
	}

	/**
	 * 个性签名
	 */
	public String getGxqm() {
		return this.gxqm;
	}

	/**
	 * 个性签名
	 *
	 * @param gxqm
	 */
	public void setGxqm(String gxqm) {
		this.gxqm = gxqm;
	}

	/**
	 * 注册时间
	 */
	public String getRegisteredTime() {
		return this.registeredTime;
	}

	/**
	 * 注册时间
	 *
	 * @param registeredTime
	 */
	public void setRegisteredTime(String registeredTime) {
		this.registeredTime = registeredTime;
	}

	/**
	 * 修改时间
	 */
	public String getUpdateTime() {
		return updateTime;
	}

	/**
	 * 修改时间
	 *
	 * @param updateTime
	 */
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * 上次登录时间
	 */
	public String getLastLoginTime() {
		return this.lastLoginTime;
	}

	/**
	 * 上次登录时间
	 *
	 * @param lastLoginTime
	 */
	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	/**
	 * 是否锁定（0是1否）
	 */
	public String getIsLock() {
		return this.isLock;
	}

	/**
	 * 是否锁定（0是1否）
	 *
	 * @param isLock
	 */
	public void setIsLock(String isLock) {
		this.isLock = isLock;
	}

	/**
	 * 等级制度
	 */
	public String getDjzd() {
		return this.djzd;
	}

	/**
	 * 等级制度
	 *
	 * @param djzd
	 */
	public void setDjzd(String djzd) {
		this.djzd = djzd;
	}

	/**
	 * 用户类型（1注册用户 2管理员）
	 */
	public String getUserType() {
		return this.userType;
	}

	/**
	 * 用户类型（1注册用户 2管理员）
	 *
	 * @param userType
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}

	/**
	 * 邮箱验证码
	 */
	public String getEmailValidateCode() {
		return emailValidateCode;
	}

	/**
	 * 邮箱验证码
	 *
	 * @param emailValidateCode
	 */
	public void setEmailValidateCode(String emailValidateCode) {
		this.emailValidateCode = emailValidateCode;
	}
	
	

}