package com.xiongwu.lingzhong.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.AccessType;
import org.hibernate.annotations.GenericGenerator;

/**
 * 众邻-微博表
 * 
 * @author xiongwu@iflytek.com
 * @created 2015年11月30日 上午10:16:37
 * @lastModified
 * @history
 */
@org.hibernate.annotations.Entity(selectBeforeUpdate = true, dynamicInsert = true, dynamicUpdate = true)
@javax.persistence.Entity
@javax.persistence.Table(name = "T_ZL_BLOG")
@GenericGenerator(name = "system_uuid", strategy = "uuid")
@AccessType("field")
public class TZlBlog {
	public TZlBlog() {

	}

	/**
	 * 主键ID
	 */
	@Id
	@GeneratedValue(generator = "system_uuid")
	@Column(name = "OBJECTID", length = 50)
	private String objectid;
	/**
	 * 内容
	 */
	@Column(name = "CONTENT", length = 200)
	private String content;
	/**
	 * 用户ID
	 */
	@Column(name = "USERID", length = 50)
	private String userid;
	/**
	 * 是否公开(0是1否)
	 */
	@Column(name = "IS_OPEN", length = 1)
	private String isOpen;
	/**
	 * 发布时间
	 */
	@Column(name = "RELEASE_TIME", length = 14)
	private String releaseTime;
	/**
	 * 发布地点
	 */
	@Column(name = "RELEASE_PLACE", length = 50)
	private String releasePlace;
	/**
	 * 原微博ID
	 */
	@Column(name = "BEFORE_BLOGID", length = 50)
	private String beforeBlogid;
	/**
	 * 状态（0已删除 1未删除）
	 */
	@Column(name = "DELETE_STAUES", length = 1)
	private String deleteStaues;

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
	 * 内容
	 */
	public String getContent() {
		return this.content;
	}

	/**
	 * 内容
	 *
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
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
	 * 是否公开(0是1否)
	 */
	public String getIsOpen() {
		return this.isOpen;
	}

	/**
	 * 是否公开(0是1否)
	 *
	 * @param isOpen
	 */
	public void setIsOpen(String isOpen) {
		this.isOpen = isOpen;
	}

	/**
	 * 发布时间
	 */
	public String getReleaseTime() {
		return this.releaseTime;
	}

	/**
	 * 发布时间
	 *
	 * @param releaseTime
	 */
	public void setReleaseTime(String releaseTime) {
		this.releaseTime = releaseTime;
	}

	/**
	 * 发布地点
	 */
	public String getReleasePlace() {
		return this.releasePlace;
	}

	/**
	 * 发布地点
	 *
	 * @param releasePlace
	 */
	public void setReleasePlace(String releasePlace) {
		this.releasePlace = releasePlace;
	}

	/**
	 * 原微博ID
	 */
	public String getBeforeBlogid() {
		return this.beforeBlogid;
	}

	/**
	 * 原微博ID
	 *
	 * @param beforeBlogid
	 */
	public void setBeforeBlogid(String beforeBlogid) {
		this.beforeBlogid = beforeBlogid;
	}

	/**
	 * 状态（0已删除 1未删除）
	 */
	public String getDeleteStaues() {
		return this.deleteStaues;
	}

	/**
	 * 状态（0已删除 1未删除）
	 *
	 * @param deleteStaues
	 */
	public void setDeleteStaues(String deleteStaues) {
		this.deleteStaues = deleteStaues;
	}

}