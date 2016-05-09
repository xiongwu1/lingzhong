package com.xiongwu.lingzhong.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.AccessType;
import org.hibernate.annotations.GenericGenerator;

/**
 * 众邻-微博操作表
 * 
 * @author xiongwu@iflytek.com
 * @created 2015年11月30日 上午10:19:19
 * @lastModified
 * @history
 */
@org.hibernate.annotations.Entity(selectBeforeUpdate = true, dynamicInsert = true, dynamicUpdate = true)
@javax.persistence.Entity
@javax.persistence.Table(name = "T_ZL_BLOG_OPERATE")
@GenericGenerator(name = "system_uuid", strategy = "uuid")
@AccessType("field")
public class TZlBlogOperate {
	public TZlBlogOperate() {

	}

	/**
	 * 主键ID
	 */
	@Id
	@GeneratedValue(generator = "system_uuid")
	@Column(name = "OBJECTID", length = 50)
	private String objectid;
	/**
	 * 微博ID
	 */
	@Column(name = "BLOGID", length = 50)
	private String blogid;
	/**
	 * 用户ID
	 */
	@Column(name = "USERID", length = 50)
	private String userid;
	/**
	 * 操作时间
	 */
	@Column(name = "OPERATE_TIME", length = 14)
	private String operateTime;
	/**
	 * 操作类别（0赞 1收藏）
	 */
	@Column(name = "OPERATE_TYPE", length = 1)
	private String operateType;
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
	 * 微博ID
	 */
	public String getBlogid() {
		return this.blogid;
	}

	/**
	 * 微博ID
	 *
	 * @param blogid
	 */
	public void setBlogid(String blogid) {
		this.blogid = blogid;
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
	 * 操作时间
	 */
	public String getOperateTime() {
		return this.operateTime;
	}

	/**
	 * 操作时间
	 *
	 * @param operateTime
	 */
	public void setOperateTime(String operateTime) {
		this.operateTime = operateTime;
	}

	/**
	 * 操作类别（0赞 1收藏）
	 */
	public String getOperateType() {
		return this.operateType;
	}

	/**
	 * 操作类别（0赞 1收藏）
	 *
	 * @param operateType
	 */
	public void setOperateType(String operateType) {
		this.operateType = operateType;
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