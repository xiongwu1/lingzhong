/**	
 * <br>
 * Copyright 2015 IFlyTek. All rights reserved.<br>
 * <br>			 
 * Package: com.iflytek.lingzhong.web <br>
 * FileName: IndexController.java <br>
 * <br>
 * @version
 * @author xiongwu@iflytek.com
 * @created 2015年11月30日
 * @last Modified 
 * @history
 */

package com.xiongwu.lingzhong.web;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iflytek.iframework.orm.Page;
import com.xiongwu.lingzhong.base.Message;
import com.xiongwu.lingzhong.base.SysCode;
import com.xiongwu.lingzhong.domain.TZlUserPerson;
import com.xiongwu.lingzhong.domain.dto.LwBlogListDto;
import com.xiongwu.lingzhong.service.IFeedBackService;
import com.xiongwu.lingzhong.service.ILwBlogService;
import com.xiongwu.lingzhong.service.IZlUserRelationService;
import com.xiongwu.utils.ResultUtil;

/**
 * 	首页控制器
 *  
 *  @author xiongwu@iflytek.com
 *  @created 2015年11月30日 下午12:11:05
 *  @lastModified       
 *  @history           
 */
@Controller
public class IndexController {

	/**
	 * 邻文操作接口
	 */
	@Autowired
	private ILwBlogService lwBlogService;
	
	/**
	 * 众邻-用户关系接口
	 */
	@Autowired
	private IZlUserRelationService zlUserRelationService;
	
	/**
	 * 意见反馈接口
	 */
	@Autowired
	private IFeedBackService feedBackService;
	
	@RequestMapping("/**.do")
	public Model goPortalPage(Model model) {
		return model;
	}
	
	/**
	 * 	获取最新的邻文列表
	 *  
	 *  @param page 分页
	 *  @param response 服务器响应
	 *  @author xiongwu@iflytek.com
	 *  @created 2016年1月19日 下午1:37:49
	 *  @lastModified       
	 *  @history
	 */
	@RequestMapping("/NewlwBlogList.do")
	public void NewLwBlogList(Page<LwBlogListDto> page,HttpServletResponse response) {
		try {
			ResultUtil.sendPage(response, lwBlogService.getNewLwBlogPage(page));
		} catch (Exception e) {
			e.printStackTrace();
			//ResultUtil.sendMsg(response, ResultUtil.FALSE, Message.LOAD_ERROR);
			ResultUtil.fail(Message.LOAD_ERROR);
		}
	}
	
	/**
	 * 	首页热门邻文
	 *  
	 *  @param response 服务器响应
	 *  @author xiongwu@iflytek.com
	 *  @created 2016年1月25日 下午2:24:32
	 *  @lastModified       
	 *  @history
	 */
	@RequestMapping("/NewTenLwList.do")
	public void NewTenLwList(HttpServletResponse response) {
		
		try {
			ResultUtil.sendList(response, lwBlogService.getTopTenLwList());
		} catch (Exception e) {
			e.printStackTrace();
			ResultUtil.fail(Message.LOAD_ERROR);
		}
	}
	
	/**
	 * 	首页众邻-找人：获取最活跃的TOP10用户
	 *  
	 *  @param response
	 *  @author xiongwu@iflytek.com
	 *  @created 2016年1月25日 下午5:15:52
	 *  @lastModified       
	 *  @history
	 */
	@RequestMapping("/MostActiveTenUser.do")
	public void MostActiveTenUser(HttpServletResponse response,HttpSession session) {
		try {
			TZlUserPerson user = (TZlUserPerson) session.getAttribute(SysCode.CURRENT_USER);
			if (user != null) {
				ResultUtil.sendList(response, zlUserRelationService.getTopTenZlUser(user.getObjectid()));
			}else {
				ResultUtil.sendList(response, zlUserRelationService.getTopTenZlUser());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			ResultUtil.fail(Message.LOAD_ERROR);
		}
	}

	/**
	 * 	意见反馈
	 *
	 *  @param response
	 *  @param feedBackContent
	 *  @param feedBackTel
	 *  @author xiongwu@iflytek.com
	 *  @created 2016年5月4日 下午7:28:52
	 *  @lastModified
	 *  @history
	 */
	@RequestMapping("/FeedBack.do")
	public void FeedBack(HttpServletResponse response,String feedBackContent, String feedBackTel,HttpSession session) {

		TZlUserPerson user = (TZlUserPerson) session.getAttribute(SysCode.CURRENT_USER);
		
		ResultUtil.sendResult(response, feedBackService.saveFeedBack(feedBackContent,feedBackTel, user));
	}

}




