/**	
 * <br>
 * Copyright 2015 IFlyTek. All rights reserved.<br>
 * <br>			 
 * Package: com.xiongwu.lingzhong.service.impl <br>
 * FileName: LwBlogServiceImpl.java <br>
 * <br>
 * @version
 * @author xiongwu@iflytek.com
 * @created 2016年1月16日
 * @last Modified 
 * @history
 */

package com.xiongwu.lingzhong.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.iflytek.iframework.orm.Page;
import com.xiongwu.lingzhong.base.Message;
import com.xiongwu.lingzhong.base.SysCode;
import com.xiongwu.lingzhong.domain.TZlBlog;
import com.xiongwu.lingzhong.domain.TZlBlogOperate;
import com.xiongwu.lingzhong.domain.TZlImage;
import com.xiongwu.lingzhong.domain.dto.LwBlogDto;
import com.xiongwu.lingzhong.domain.dto.LwBlogListDto;
import com.xiongwu.lingzhong.persistence.AttachmentDao;
import com.xiongwu.lingzhong.persistence.LwBlogDao;
import com.xiongwu.lingzhong.persistence.ZlBlogOperateDao;
import com.xiongwu.lingzhong.persistence.ZlCommentDao;
import com.xiongwu.lingzhong.persistence.ZlImageDao;
import com.xiongwu.lingzhong.service.ILwBlogService;
import com.xiongwu.utils.DateUtils;
import com.xiongwu.utils.ResultUtil;
import com.xiongwu.utils.dto.ResultDto;

/**
 * 	邻文操作实现类
 *  
 *  @author xiongwu@iflytek.com
 *  @created 2016年1月16日 下午3:27:24
 *  @lastModified       
 *  @history           
 */

public class LwBlogServiceImpl implements ILwBlogService{
	
	/**
	 * 邻文Dao
	 */
	@Autowired
	private LwBlogDao lwBlogDao;
	
	/**
	 * 邻文图片Dao
	 */
	@Autowired
	private ZlImageDao zlImageDao;
	
	/**
	 * 邻文评论Dao
	 */
	@Autowired
	private ZlCommentDao zlCommentDao;
	
	/**
	 * 邻文操作Dao
	 */
	@Autowired
	private ZlBlogOperateDao zlBlogOperateDao;
	
	/**
	 * 图片附件Dao
	 */
	@Autowired
	private AttachmentDao attachmentDao;
	
	
	@Override
	public ResultDto saveLwBlog(LwBlogDto zlBlogDto,String userId,String imgIdStr) {
		
		//保存邻文的内容
		TZlBlog zlBlog = new TZlBlog();
		zlBlog.setUserid(userId);
		zlBlog.setContent(zlBlogDto.getContent());
		zlBlog.setIsOpen(SysCode.IS_FLAG);
		zlBlog.setReleaseTime(DateUtils.getCurrentGaDate());
		zlBlog.setReleasePlace("浙江杭州");
		zlBlog.setDeleteStaues(SysCode.NO_FLAG);
		lwBlogDao.saveOrUpdate(zlBlog);
		
		if (imgIdStr != "") {
			//将邻文的ID更新到图片表中
			String[] imgId = imgIdStr.split(",");
	        for (int i = 0; i < imgId.length; i++) {
	        	TZlImage zlImage = attachmentDao.queryImgByImgId(imgId[i]);
	            zlImage.setBlogid(zlBlog.getObjectid());
	            attachmentDao.saveOrUpdate(zlImage);
	        }
		}
		
		return ResultUtil.success(Message.SUCCESS);
	}


	@Override
	public Page<LwBlogListDto> getNewLwBlogPage(Page<LwBlogListDto> page) {
		
		//查询出邻文List
		Page<LwBlogListDto> lwBlogList = lwBlogDao.queryNewLwBlogPage(page);
		
		if (lwBlogList != null) {
			for(int i=0;i<lwBlogList.getResult().size();i++) {
				//循环遍历，根据邻文的Id查出图片信息
				lwBlogList.getResult().get(i).setZlImageList(zlImageDao.queryLwImagesByLwBlogId(lwBlogList.getResult().get(i).getObjectid()));
				//循环遍历，根据邻文的Id统计评论数
				lwBlogList.getResult().get(i).setCommentNum(zlCommentDao.queryLwCommentSum(lwBlogList.getResult().get(i).getObjectid()));
				//循环遍历，根据邻文的Id统计点赞数
				lwBlogList.getResult().get(i).setLikeNum(zlBlogOperateDao.queryLwLikeSum(lwBlogList.getResult().get(i).getObjectid()));
				//循环遍历，根据邻文的Id统计被转发数
				lwBlogList.getResult().get(i).setForwardNum(lwBlogDao.queryLwforwardSum(lwBlogList.getResult().get(i).getObjectid()));
			}
		}
		return lwBlogList;
	}
	
	@Override
	public Page<LwBlogListDto> getMyFriendsNewLwPage(Page<LwBlogListDto> page,String currentUserId) {
		//查询出邻文List
		Page<LwBlogListDto> lwBlogList = lwBlogDao.queryMyFriendsNewLwPage(page,currentUserId);
		
		if (lwBlogList != null) {
			for(int i=0;i<lwBlogList.getResult().size();i++) {
				//循环遍历，根据邻文的Id查出图片信息
				lwBlogList.getResult().get(i).setZlImageList(zlImageDao.queryLwImagesByLwBlogId(lwBlogList.getResult().get(i).getObjectid()));
				//循环遍历，根据邻文的Id统计评论数
				lwBlogList.getResult().get(i).setCommentNum(zlCommentDao.queryLwCommentSum(lwBlogList.getResult().get(i).getObjectid()));
				//循环遍历，根据邻文的Id统计点赞数
				lwBlogList.getResult().get(i).setLikeNum(zlBlogOperateDao.queryLwLikeSum(lwBlogList.getResult().get(i).getObjectid()));
				//循环遍历，根据邻文的Id统计被转发数
				lwBlogList.getResult().get(i).setForwardNum(lwBlogDao.queryLwforwardSum(lwBlogList.getResult().get(i).getObjectid()));
				//循环遍历，根据邻文的ID判断是否被收藏
				TZlBlogOperate isCollection= zlBlogOperateDao.queryIsCollection(currentUserId, lwBlogList.getResult().get(i).getObjectid());
				if (isCollection != null) {
					lwBlogList.getResult().get(i).setIsCollection(SysCode.TRUE);
				}else {
					lwBlogList.getResult().get(i).setIsCollection(SysCode.FALSE);
				}
				//循环遍历，根据邻文的ID判断是否被点赞
				TZlBlogOperate isLike= zlBlogOperateDao.queryIsLike(currentUserId, lwBlogList.getResult().get(i).getObjectid());
				if (isLike != null) {
					lwBlogList.getResult().get(i).setIsLike(SysCode.TRUE);
				}else {
					lwBlogList.getResult().get(i).setIsLike(SysCode.FALSE);
				}
			}
		}
		return lwBlogList;
	}
	
	@Override
	public List<LwBlogDto> getTopTenLwList() {
		return lwBlogDao.queryNewLwBlogList();
	}

	@Override
	public int deleteLwBlog(String lwBlogId) {
		return lwBlogDao.deleteLwBlog(lwBlogId);
	}
}




