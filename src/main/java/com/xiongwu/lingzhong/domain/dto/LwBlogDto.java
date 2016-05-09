/**	
 * <br>
 * Copyright 2015 IFlyTek. All rights reserved.<br>
 * <br>			 
 * Package: com.xiongwu.lingzhong.domain.dto <br>
 * FileName: LwBlogDto.java <br>
 * <br>
 * @version
 * @author xiongwu@iflytek.com
 * @created 2016年1月16日
 * @last Modified 
 * @history
 */

package com.xiongwu.lingzhong.domain.dto;


/**
 * 	邻文Dto
 *  
 *  @author xiongwu@iflytek.com
 *  @created 2016年1月16日 下午3:35:13
 *  @lastModified       
 *  @history           
 */

public class LwBlogDto {
	
	/**
	 * 主键ID
	 */
	private String objectid;
	/**
	 * 内容
	 */
	private String content;
	/**
	 * 用户ID
	 */
	private String userid;
	/**
	 * 是否公开(0是1否)
	 */
	private String isOpen;
	/**
	 * 发布时间
	 */
	private String releaseTime;
	/**
	 * 发布地点
	 */
	private String releasePlace;
	/**
	 * 原微博ID
	 */
	private String beforeBlogid;
	/**
	 * 状态（0已删除 1未删除）
	 */
	private String deleteStaues;
	
	public String getObjectid() {
		return objectid;
	}
	public void setObjectid(String objectid) {
		this.objectid = objectid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getIsOpen() {
		return isOpen;
	}
	public void setIsOpen(String isOpen) {
		this.isOpen = isOpen;
	}
	public String getReleaseTime() {
		return releaseTime;
	}
	public void setReleaseTime(String releaseTime) {
		this.releaseTime = releaseTime;
	}
	public String getReleasePlace() {
		return releasePlace;
	}
	public void setReleasePlace(String releasePlace) {
		this.releasePlace = releasePlace;
	}
	public String getBeforeBlogid() {
		return beforeBlogid;
	}
	public void setBeforeBlogid(String beforeBlogid) {
		this.beforeBlogid = beforeBlogid;
	}
	public String getDeleteStaues() {
		return deleteStaues;
	}
	public void setDeleteStaues(String deleteStaues) {
		this.deleteStaues = deleteStaues;
	}
}




