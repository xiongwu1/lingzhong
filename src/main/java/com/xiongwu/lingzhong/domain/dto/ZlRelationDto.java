/**	
 * <br>
 * Copyright 2015 IFlyTek. All rights reserved.<br>
 * <br>			 
 * Package: com.xiongwu.lingzhong.domain.dto <br>
 * FileName: ZlRelationDto.java <br>
 * <br>
 * @version
 * @author xiongwu@iflytek.com
 * @created 2016年1月26日
 * @last Modified 
 * @history
 */

package com.xiongwu.lingzhong.domain.dto;


/**
 * 	众邻-用户关系DTO
 *  
 *  @author xiongwu@iflytek.com
 *  @created 2016年1月26日 下午2:26:39
 *  @lastModified       
 *  @history           
 */

public class ZlRelationDto {
	
	/**
	 * 主键ID
	 */
	private String objectid;
	/**
	 * 发起人
	 */
	private String promoter;
	/**
	 * 接收人
	 */
	private String recipient;
	
	/**
	 * 关注时间
	 */
	private String attentionTime;

	public String getObjectid() {
		return objectid;
	}

	public void setObjectid(String objectid) {
		this.objectid = objectid;
	}

	public String getPromoter() {
		return promoter;
	}

	public void setPromoter(String promoter) {
		this.promoter = promoter;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getAttentionTime() {
		return attentionTime;
	}

	public void setAttentionTime(String attentionTime) {
		this.attentionTime = attentionTime;
	}
}




