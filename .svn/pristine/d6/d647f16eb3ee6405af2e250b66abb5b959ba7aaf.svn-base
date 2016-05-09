package com.xiongwu.lingzhong.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.AccessType;
import org.hibernate.annotations.GenericGenerator;

/**
 * 众邻-用户关系表
 * 
 * @author xiongwu@iflytek.com
 * @created 2015年11月30日 上午10:52:38
 * @lastModified
 * @history
 */
@org.hibernate.annotations.Entity(selectBeforeUpdate = true, dynamicInsert = true, dynamicUpdate = true)
@javax.persistence.Entity
@javax.persistence.Table(name = "T_ZL_USER_RELATION")
@GenericGenerator(name = "system_uuid", strategy = "uuid")
@AccessType("field")
public class TZlUserRelation {
	public TZlUserRelation() {

	}

	/**
	 * 主键ID
	 */
	@Id
	@GeneratedValue(generator = "system_uuid")
	@Column(name = "OBJECTID", length = 50)
	private String objectid;
	/**
	 * 发起人
	 */
	@Column(name = "PROMOTER", length = 50)
	private String promoter;
	/**
	 * 接收人
	 */
	@Column(name = "RECIPIENT", length = 50)
	private String recipient;
	/**
	 * 状态
	 */
	@Column(name = "STATUS", length = 50)
	private String status;
	/**
	 * 关注时间
	 */
	@Column(name = "ATTENTION_TIME", length = 50)
	private String attentionTime;

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
	 * 发起人
	 */
	public String getPromoter() {
		return this.promoter;
	}

	/**
	 * 发起人
	 *
	 * @param promoter
	 */
	public void setPromoter(String promoter) {
		this.promoter = promoter;
	}

	/**
	 * 接收人
	 */
	public String getRecipient() {
		return this.recipient;
	}

	/**
	 * 接收人
	 *
	 * @param recipient
	 */
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	/**
	 * 状态
	 */
	public String getStatus() {
		return this.status;
	}

	/**
	 * 状态
	 *
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 关注时间
	 */
	public String getAttentionTime() {
		return this.attentionTime;
	}

	/**
	 * 关注时间
	 *
	 * @param attentionTime
	 */
	public void setAttentionTime(String attentionTime) {
		this.attentionTime = attentionTime;
	}

}