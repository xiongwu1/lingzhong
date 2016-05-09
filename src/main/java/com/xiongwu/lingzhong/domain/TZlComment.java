package com.xiongwu.lingzhong.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.AccessType;
import org.hibernate.annotations.GenericGenerator;

/**
 * 	众邻-评论表
 *  
 *  @author xiongwu@iflytek.com
 *  @created 2015年11月30日 上午10:51:01
 *  @lastModified       
 *  @history
 */
@org.hibernate.annotations.Entity(selectBeforeUpdate = true, dynamicInsert = true, dynamicUpdate = true)
@javax.persistence.Entity
@javax.persistence.Table(name = "T_ZL_COMMENT")
@GenericGenerator(name = "system_uuid", strategy = "uuid")
@AccessType("field")
public class TZlComment {
	public TZlComment() {

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
	 * 评论时间
	 */
	@Column(name = "COMMENT_TIME", length = 14)
	private String commentTime;
	/**
	 * 评论内容
	 */
	@Column(name = "COMMENT_CONTENT", length = 200)
	private String commentContent;
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
	 * 评论时间
	 */
	public String getCommentTime() {
		return this.commentTime;
	}

	/**
	 * 评论时间
	 *
	 * @param commentTime
	 */
	public void setCommentTime(String commentTime) {
		this.commentTime = commentTime;
	}

	/**
	 * 评论内容
	 */
	public String getCommentContent() {
		return this.commentContent;
	}

	/**
	 * 评论内容
	 *
	 * @param commentContent
	 */
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
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