/**	
 * <br>
 * Copyright 2015 IFlyTek. All rights reserved.<br>
 * <br>			 
 * Package: com.xiongwu.lingzhong.service.impl <br>
 * FileName: ZlBlogServiceImpl.java <br>
 * <br>
 * @version
 * @author xiongwu@iflytek.com
 * @created 2016年2月1日
 * @last Modified 
 * @history
 */

package com.xiongwu.lingzhong.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.xiongwu.lingzhong.base.Message;
import com.xiongwu.lingzhong.base.SysCode;
import com.xiongwu.lingzhong.domain.TZlBlogOperate;
import com.xiongwu.lingzhong.persistence.ZlBlogOperateDao;
import com.xiongwu.lingzhong.service.IZlBlogOperateService;
import com.xiongwu.utils.DateUtils;
import com.xiongwu.utils.ResultUtil;
import com.xiongwu.utils.dto.ResultDto;

/**
 * 	邻文操作实现类
 *  
 *  @author xiongwu@iflytek.com
 *  @created 2016年2月1日 下午2:11:01
 *  @lastModified       
 *  @history           
 */

public class ZlBlogOperateServiceImpl implements IZlBlogOperateService {

	/**
	 * 邻文操作Dao
	 */
	@Autowired
	private ZlBlogOperateDao zlBlogOperateDao;
	
	@Override
	public ResultDto saveLwCollection(String lwBlogId,String userId) {
		
		TZlBlogOperate zlBlogOperate = new TZlBlogOperate();
		
		zlBlogOperate.setBlogid(lwBlogId);
		zlBlogOperate.setUserid(userId);
		zlBlogOperate.setOperateTime(DateUtils.getCurrentGaDate());
		zlBlogOperate.setOperateType(SysCode.NO_FLAG);
		zlBlogOperate.setDeleteStaues(SysCode.NO_FLAG);
		
		zlBlogOperateDao.saveOrUpdate(zlBlogOperate);
		
		return ResultUtil.success(Message.SUCCESS);
	}
	
	@Override
	public ResultDto cancelCollection(String currentUserId,String lwBlogId) {
		zlBlogOperateDao.cancelCollection(currentUserId, lwBlogId);
		return ResultUtil.success(Message.SUCCESS);
	}
	
	@Override
	public ResultDto saveLwLike(String lwBlogId,String userId) {
		TZlBlogOperate zlBlogOperate = new TZlBlogOperate();
		
		zlBlogOperate.setBlogid(lwBlogId);
		zlBlogOperate.setUserid(userId);
		zlBlogOperate.setOperateTime(DateUtils.getCurrentGaDate());
		zlBlogOperate.setOperateType(SysCode.IS_FLAG);
		zlBlogOperate.setDeleteStaues(SysCode.NO_FLAG);
		
		zlBlogOperateDao.saveOrUpdate(zlBlogOperate);
		
		return ResultUtil.success(Message.SUCCESS);
	}
	
	@Override
	public ResultDto cancelLike(String currentUserId,String lwBlogId) {
		zlBlogOperateDao.cancelLike(currentUserId, lwBlogId);
		return ResultUtil.success(Message.SUCCESS);
	}
}




