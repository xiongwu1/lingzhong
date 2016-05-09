/**	
 * <br>
 * Copyright 2015 IFlyTek. All rights reserved.<br>
 * <br>			 
 * Package: com.xiongwu.lingzhong.service <br>
 * FileName: IZlBlogOperateService.java <br>
 * <br>
 * @version
 * @author xiongwu@iflytek.com
 * @created 2016年2月1日
 * @last Modified 
 * @history
 */

package com.xiongwu.lingzhong.service;

import com.xiongwu.utils.dto.ResultDto;

/**
 * 	
 *  邻文操作接口
 *  
 *  @author xiongwu@iflytek.com
 *  @created 2016年2月1日 下午2:10:21
 *  @lastModified       
 *  @history           
 */

public interface IZlBlogOperateService {
	
	/**
	 * 	收藏邻文操作
	 *  
	 *  @param lwBlogId 邻文ID
	 *  @param userId 当前用户ID
	 *  @return
	 *  @author xiongwu@iflytek.com
	 *  @created 2016年2月1日 下午2:35:03
	 *  @lastModified       
	 *  @history
	 */
	public ResultDto saveLwCollection(String lwBlogId,String userId);
	
	/**
	 * 	取消收藏操作
	 *  
	 *  @param currentUserId 当前用户ID
	 *  @param lwBlogId 邻文ID
	 *  @return
	 *  @author xiongwu@iflytek.com
	 *  @created 2016年2月1日 下午5:50:41
	 *  @lastModified       
	 *  @history
	 */
	public ResultDto cancelCollection(String currentUserId,String lwBlogId);
	
	/**
	 *	点赞邻文
	 *  
	 *  @param lwBlogId 邻文ID
	 *  @param userId   当前用户ID
	 *  @return
	 *  @author xiongwu@iflytek.com
	 *  @created 2016年2月2日 上午9:37:03
	 *  @lastModified       
	 *  @history
	 */
	public ResultDto saveLwLike(String lwBlogId,String userId);
	
	/**
	 * 	取消点赞操作
	 *  
	 *  @param currentUserId 当前用户ID
	 *  @param lwBlogId 邻文ID
	 *  @return
	 *  @author xiongwu@iflytek.com
	 *  @created 2016年2月2日 上午9:42:48
	 *  @lastModified       
	 *  @history
	 */
	public ResultDto cancelLike(String currentUserId,String lwBlogId);
}




