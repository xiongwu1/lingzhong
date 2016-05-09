/**	
 * <br>
 * Copyright 2015 IFlyTek. All rights reserved.<br>
 * <br>			 
 * Package: com.xiongwu.lingzhong.domain.dto <br>
 * FileName: CountNum.java <br>
 * <br>
 * @version
 * @author xiongwu@iflytek.com
 * @created 2016年1月29日
 * @last Modified 
 * @history
 */

package com.xiongwu.lingzhong.domain.dto;

/**
 * 	统计信息
 *  
 *  @author xiongwu@iflytek.com
 *  @created 2016年1月29日 上午11:28:27
 *  @lastModified       
 *  @history           
 */

public class CountNumDto {

	/**
	 * 关注数
	 */
	private String attentionNum;
	
	/**
	 * 粉丝数
	 */
	private String fansNum;
	
	/**
	 * 邻文数
	 */
	private String lwBlogNum;
	
	public String getAttentionNum() {
		return attentionNum;
	}

	public void setAttentionNum(String attentionNum) {
		this.attentionNum = attentionNum;
	}

	public String getFansNum() {
		return fansNum;
	}

	public void setFansNum(String fansNum) {
		this.fansNum = fansNum;
	}

	public String getLwBlogNum() {
		return lwBlogNum;
	}

	public void setLwBlogNum(String lwBlogNum) {
		this.lwBlogNum = lwBlogNum;
	}
}




