package com.xiongwu.lingzhong.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.AccessType;
import org.hibernate.annotations.GenericGenerator;

/**
 * 众邻-反馈建议表
 * 
 * @author xiongwu@iflytek.com
 * @created 2015年11月30日 上午10:51:48
 * @lastModified
 * @history
 */
@org.hibernate.annotations.Entity(selectBeforeUpdate = true, dynamicInsert = true, dynamicUpdate = true)
@javax.persistence.Entity
@javax.persistence.Table(name = "T_ZL_SUGGEST")
@GenericGenerator(name = "system_uuid", strategy = "uuid")
@AccessType("field")
public class TZlSuggest {
	public TZlSuggest() {

	}

	/**
	 * 主键ID
	 */
	@Id
	@GeneratedValue(generator = "system_uuid")
	@Column(name = "OBJECTID", length = 50)
	private String objectid;
	/**
	 * 用户ID
	 */
	@Column(name = "USERID", length = 50)
	private String userid;
	/**
	 * 建议内容
	 */
	@Column(name = "SUGGEST_CONTENT", length = 200)
	private String suggestContent;
	/**
	 * 联系方式
	 */
	@Column(name = "MOBILE_PHONE", length = 12)
	private String mobilePhone;
	/**
	 * 建议时间
	 */
	@Column(name = "SUGGEST_TIME", length = 14)
	private String suggestTime;
	/**
	 * 状态（0已删除 1未删除）
	 */
	@Column(name = "SUGGEST_STATUS", length = 1)
	private String suggestStatus;

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
	 * 用户ID
	 */
	public String getUserid() {
		return this.userid;
	}

	/**
	 * 用户ID
	 *
	 * @param userid
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * 建议内容
	 */
	public String getSuggestContent() {
		return this.suggestContent;
	}

	/**
	 * 建议内容
	 *
	 * @param suggestContent
	 */
	public void setSuggestContent(String suggestContent) {
		this.suggestContent = suggestContent;
	}

	/**
	 * 联系方式
	 */
	public String getMobilePhone() {
		return this.mobilePhone;
	}

	/**
	 * 联系方式
	 *
	 * @param mobilePhone
	 */
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	/**
	 * 建议时间
	 */
	public String getSuggestTime() {
		return this.suggestTime;
	}

	/**
	 * 建议时间
	 *
	 * @param suggestTime
	 */
	public void setSuggestTime(String suggestTime) {
		this.suggestTime = suggestTime;
	}

	/**
	 * 状态（0已删除 1未删除）
	 */
	public String getSuggestStatus() {
		return this.suggestStatus;
	}

	/**
	 * 状态（0已删除 1未删除）
	 *
	 * @param suggestStatus
	 */
	public void setSuggestStatus(String suggestStatus) {
		this.suggestStatus = suggestStatus;
	}

}