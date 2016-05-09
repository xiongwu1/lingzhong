/**	
 * <br>
 * Copyright 2015 IFlyTek. All rights reserved.<br>
 * <br>			 
 * Package: com.xiongwu.lingzhong.service <br>
 * FileName: ILwBlogService.java <br>
 * <br>
 * @version
 * @author xiongwu@iflytek.com
 * @created 2016年1月16日
 * @last Modified 
 * @history
 */

package com.xiongwu.lingzhong.service;

import java.util.List;

import com.iflytek.iframework.orm.Page;
import com.xiongwu.lingzhong.domain.dto.LwBlogDto;
import com.xiongwu.lingzhong.domain.dto.LwBlogListDto;
import com.xiongwu.utils.dto.ResultDto;

/**
 * 	邻文操作接口
 *  
 *  @author xiongwu@iflytek.com
 *  @created 2016年1月16日 下午3:25:59
 *  @lastModified       
 *  @history           
 */

public interface ILwBlogService {
	
	/**
	 * 	发表邻文
	 *  
	 *  @param zlBlog 邻文对象
	 *  @param userId 当前用户ID
	 *  @param imgIdStr 图片ID字符串
	 *  @author xiongwu@iflytek.com
	 *  @created 2016年1月16日 下午3:33:18
	 *  @lastModified       
	 *  @history
	 */
	public ResultDto saveLwBlog(LwBlogDto zlBlog,String userId,String imgIdStr);
	
	/**
	 * 	获取最新的邻文列表
	 *  
	 *  @param page 分页
	 *  @return
	 *  @author xiongwu@iflytek.com
	 *  @created 2016年1月19日 下午1:46:25
	 *  @lastModified       
	 *  @history
	 */
	public Page<LwBlogListDto> getNewLwBlogPage(Page<LwBlogListDto> page);
	
	/**
	 * 	查询我的好友最新的邻文分页结果
	 *  
	 *  @param page 分页
	 *  @param currentUserId 当前用户ID
	 *  @return
	 *  @author xiongwu@iflytek.com
	 *  @created 2016年1月28日 上午11:22:44
	 *  @lastModified       
	 *  @history
	 */
	public Page<LwBlogListDto> getMyFriendsNewLwPage(Page<LwBlogListDto> page,String currentUserId);
	
	/**
	 * 	获取最新的10条邻文数据
	 *  
	 *  @return
	 *  @author xiongwu@iflytek.com
	 *  @created 2016年1月25日 下午2:22:30
	 *  @lastModified       
	 *  @history
	 */
	public List<LwBlogDto> getTopTenLwList();
	
	/**
	 * 	删除我的邻文
	 *  
	 *  @param lwBlogId 我的邻文ID
	 *  @return
	 *  @author xiongwu@iflytek.com
	 *  @created 2016年1月30日 下午2:25:24
	 *  @lastModified       
	 *  @history
	 */
	public int deleteLwBlog(String lwBlogId);

}




