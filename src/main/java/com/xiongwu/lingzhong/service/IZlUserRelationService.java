/**	
 * <br>
 * Copyright 2015 IFlyTek. All rights reserved.<br>
 * <br>			 
 * Package: com.xiongwu.lingzhong.service <br>
 * FileName: IZlUserRelationService.java <br>
 * <br>
 * @version
 * @author xiongwu@iflytek.com
 * @created 2016年1月26日
 * @last Modified 
 * @history
 */

package com.xiongwu.lingzhong.service;

import java.util.List;

import com.xiongwu.lingzhong.domain.dto.CountNumDto;
import com.xiongwu.lingzhong.domain.dto.LoginUserDto;
import com.xiongwu.utils.dto.ResultDto;

/**
 * 	众邻-用户关系接口
 *  
 *  @author xiongwu@iflytek.com
 *  @created 2016年1月26日 上午10:17:41
 *  @lastModified       
 *  @history           
 */

public interface IZlUserRelationService {

	/**
	 * 	加关注
	 *  
	 *  @param currentUserId 当前用户ID
	 *  @param attentUserId 加关注对象ID
	 *  @return
	 *  @author xiongwu@iflytek.com
	 *  @created 2016年1月26日 上午10:56:28
	 *  @lastModified       
	 *  @history
	 */
	public ResultDto saveUserRelation(String currentUserId,String attentUserId);
	
	/**
	 * 	取消关注操作
	 *  
	 *  @param currentUserId 当前用户ID
	 *  @param attentUserId 被关注对象ID
	 *  @return
	 *  @author xiongwu@iflytek.com
	 *  @created 2016年1月27日 下午12:46:30
	 *  @lastModified       
	 *  @history
	 */
	public ResultDto cancelAttention(String currentUserId,String attentUserId);
	
	
	/**
	 * 	获取最新登陆的TOP10用户
	 *  
	 *  @param currentUserId 当前用户ID
	 *  @return
	 *  @author xiongwu@iflytek.com
	 *  @created 2016年1月26日 下午2:46:51
	 *  @lastModified       
	 *  @history
	 */
	public List<LoginUserDto> getTopTenZlUser(String currentUserId);
	
	/**
	 * 	获取最新登陆的TOP10用户 （重构）
	 *  
	 *  @return
	 *  @author xiongwu@iflytek.com
	 *  @created 2016年1月26日 下午3:46:23
	 *  @lastModified       
	 *  @history
	 */
	public List<LoginUserDto> getTopTenZlUser();
	
	/**
	 * 	统计我所关注的人数
	 * 
	 *  @param currentUserId 当前用户ID
	 *  @return
	 *  @author xiongwu@iflytek.com
	 *  @created 2016年1月29日 上午9:32:27
	 *  @lastModified       
	 *  @history
	 */
	public CountNumDto getCountAttention(String currentUserId);
}




