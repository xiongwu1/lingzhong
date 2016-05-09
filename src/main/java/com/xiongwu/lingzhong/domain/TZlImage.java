package com.xiongwu.lingzhong.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.AccessType;
import org.hibernate.annotations.GenericGenerator;

/**
 * 	众邻-图片表
 *  
 *  @author xiongwu@iflytek.com
 *  @created 2015年11月30日 上午10:50:46
 *  @lastModified       
 *  @history
 */
@org.hibernate.annotations.Entity(selectBeforeUpdate = true, dynamicInsert = true, dynamicUpdate = true)
@javax.persistence.Entity
@javax.persistence.Table(name = "T_ZL_IMAGE")
@GenericGenerator(name = "system_uuid", strategy = "uuid")
@AccessType("field")
public class TZlImage {
	public TZlImage() {

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
	 * 微博ID
	 */
	@Column(name = "BLOGID", length = 50)
	private String blogid;
	/**
	 * 图片名称
	 */
	@Column(name = "IMAGE_NAME", length = 50)
	private String imageName;
	/**
	 * 图片路径
	 */
	@Column(name = "IMAGE_URL", length = 100)
	private String imageUrl;
	/**
	 * 上传时间
	 */
	@Column(name = "UPLOAD_TIME", length = 14)
	private String uploadTime;
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
	 * 图片名称
	 */
	public String getImageName() {
		return this.imageName;
	}

	/**
	 * 图片名称
	 *
	 * @param imageName
	 */
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	/**
	 * 图片路径
	 */
	public String getImageUrl() {
		return this.imageUrl;
	}

	/**
	 * 图片路径
	 *
	 * @param imageUrl
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	/**
	 * 上传时间
	 */
	public String getUploadTime() {
		return this.uploadTime;
	}

	/**
	 * 上传时间
	 *
	 * @param uploadTime
	 */
	public void setUploadTime(String uploadTime) {
		this.uploadTime = uploadTime;
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