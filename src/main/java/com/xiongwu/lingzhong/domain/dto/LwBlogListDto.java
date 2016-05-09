/**	
 * <br>
 * Copyright 2015 IFlyTek. All rights reserved.<br>
 * <br>			 
 * Package: com.xiongwu.lingzhong.domain.dto <br>
 * FileName: LwBlogListDto.java <br>
 * <br>
 * @version
 * @author xiongwu@iflytek.com
 * @created 2016年1月20日
 * @last Modified 
 * @history
 */

package com.xiongwu.lingzhong.domain.dto;

import java.util.List;

/**
 * 邻文列表Dto
 * 
 * @author xiongwu@iflytek.com
 * @created 2016年1月20日 下午12:38:51
 * @lastModified
 * @history
 */

public class LwBlogListDto {
	
	/**
	 * 用户ID
	 */
	private String userId;

	/**
	 * 昵称
	 */
	private String nickName;

	/**
	 * 头像
	 */
	private String headPortrait;
	
	/**
	 * 邻文ID
	 */
	private String objectid;

	/**
	 * 邻文内容
	 */
	private String content;

	/**
	 * 发布时间
	 */
	private String releaseTime;
	
	/**
	 * 发布地点
	 */
	private String releasePlace;

	/**
	 * 图片路径
	 */
	private List<LwImageListDto> zlImageList;
	
	/**
	 * 转发数
	 */
	private int forwardNum;
	
	/**
	 * 评论数
	 */
	private int commentNum;
	
	/**
	 * 赞数
	 */
	private int likeNum;
	
	/**
	 * 是否被收藏
	 */
	private String isCollection;
	
	/**
	 * 是否被点赞
	 */
	private String isLike;
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getHeadPortrait() {
		return headPortrait;
	}

	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}
	
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

	public List<LwImageListDto> getZlImageList() {
		return zlImageList;
	}

	public void setZlImageList(List<LwImageListDto> zlImageList) {
		this.zlImageList = zlImageList;
	}

	public int getForwardNum() {
		return forwardNum;
	}

	public void setForwardNum(int forwardNum) {
		this.forwardNum = forwardNum;
	}

	public int getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}

	public int getLikeNum() {
		return likeNum;
	}

	public void setLikeNum(int likeNum) {
		this.likeNum = likeNum;
	}

	public String getIsCollection() {
		return isCollection;
	}

	public void setIsCollection(String isCollection) {
		this.isCollection = isCollection;
	}

	public String getIsLike() {
		return isLike;
	}

	public void setIsLike(String isLike) {
		this.isLike = isLike;
	}
}
