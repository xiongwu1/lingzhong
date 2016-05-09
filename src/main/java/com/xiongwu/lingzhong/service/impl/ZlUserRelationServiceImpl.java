/**	
 * <br>
 * Copyright 2015 IFlyTek. All rights reserved.<br>
 * <br>			 
 * Package: com.xiongwu.lingzhong.service.impl <br>
 * FileName: ZlUserRelationServiceImpl.java <br>
 * <br>
 * @version
 * @author xiongwu@iflytek.com
 * @created 2016年1月26日
 * @last Modified 
 * @history
 */

package com.xiongwu.lingzhong.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xiongwu.lingzhong.base.Message;
import com.xiongwu.lingzhong.base.SysCode;
import com.xiongwu.lingzhong.domain.TZlUserRelation;
import com.xiongwu.lingzhong.domain.dto.CountNumDto;
import com.xiongwu.lingzhong.domain.dto.LoginUserDto;
import com.xiongwu.lingzhong.persistence.ZlUserRelationDao;
import com.xiongwu.lingzhong.service.IZlUserRelationService;
import com.xiongwu.utils.DateUtils;
import com.xiongwu.utils.ResultUtil;
import com.xiongwu.utils.dto.ResultDto;

/**
 * 	众邻-用户关系实现类
 *  
 *  @author xiongwu@iflytek.com
 *  @created 2016年1月26日 上午10:18:17
 *  @lastModified       
 *  @history           
 */

public class ZlUserRelationServiceImpl implements IZlUserRelationService{
	
	
	/**
	 * 众邻-用户关系Dao
	 */
	@Autowired
	private ZlUserRelationDao relationDao;

	@Override
	public ResultDto saveUserRelation(String currentUserId,String attentUserId) {
		
		TZlUserRelation zlUserRelation = new TZlUserRelation();
		
		zlUserRelation.setPromoter(currentUserId);
		zlUserRelation.setRecipient(attentUserId);
		zlUserRelation.setAttentionTime(DateUtils.getCurrentGaDate());
		
		relationDao.saveOrUpdate(zlUserRelation);
		
		return ResultUtil.success(Message.SUCCESS);
	}
	
	@Override
	public ResultDto cancelAttention(String currentUserId,String attentUserId) {
		relationDao.cancelAttention(currentUserId, attentUserId);
		return ResultUtil.success(Message.SUCCESS);
	}
	
	
	@Override
	public List<LoginUserDto> getTopTenZlUser(String currentUserId) {
		
		List<LoginUserDto> topTenList = relationDao.queryTopTenZlUser();
		
		//根据TOP10的用户ID和当前用户ID，判断是否已被关注
		for(int i = 0;i < topTenList.size();i++) {
			TZlUserRelation userRelation= relationDao.queryIsAttention(currentUserId, topTenList.get(i).getObjectid());
			if (userRelation != null) {
				topTenList.get(i).setIsAttent(SysCode.TRUE);
			}else {
				topTenList.get(i).setIsAttent(SysCode.FALSE);
			}
		}
		
		return topTenList;
	}
	
	@Override
	public List<LoginUserDto> getTopTenZlUser() {
		return relationDao.queryTopTenZlUser();
	}
	
	@Override
	public CountNumDto getCountAttention(String currentUserId) {
		
		//将所有的统计信息封装成对象返回
		CountNumDto countNum = new CountNumDto();
		
		countNum.setAttentionNum(relationDao.queryCountAttention(currentUserId));
		countNum.setFansNum(relationDao.queryCountFans(currentUserId));
		countNum.setLwBlogNum(relationDao.queryCountLwBlog(currentUserId));
		
		return countNum;
	}
}




