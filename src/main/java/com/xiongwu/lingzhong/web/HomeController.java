/**	
 * <br>
 * Copyright 2015 IFlyTek. All rights reserved.<br>
 * <br>			 
 * Package: com.xiongwu.lingzhong.web <br>
 * FileName: HomeController.java <br>
 * <br>
 * @version
 * @author xiongwu@iflytek.com
 * @created 2015年12月11日
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
import com.xiongwu.lingzhong.service.ILwBlogService;
import com.xiongwu.lingzhong.service.IZlUserRelationService;
import com.xiongwu.utils.ResultUtil;

/**
 * 	我的首页
 *  
 *  @author xiongwu@iflytek.com
 *  @created 2015年12月11日 下午2:03:25
 *  @lastModified       
 *  @history           
 */
@Controller
public class HomeController {
	
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
	
	@RequestMapping("/home/**.do")
	public Model goPortalPage(Model model) {
		return model;
	}
	
	/**
	 * 	获取我的好友最新邻文列表
	 *  
	 *  @param page 分页
	 *  @param response 服务器响应
	 *  @author xiongwu@iflytek.com
	 *  @created 2016年1月19日 下午1:37:49
	 *  @lastModified       
	 *  @history
	 */
	@RequestMapping("/home/MyFriendsNewLwList.do")
	public void MyFriendsNewLwList(Page<LwBlogListDto> page,HttpServletResponse response,HttpSession session) {
		try {
			TZlUserPerson user = (TZlUserPerson) session.getAttribute(SysCode.CURRENT_USER);
			ResultUtil.sendPage(response, lwBlogService.getMyFriendsNewLwPage(page,user.getObjectid()));
		} catch (Exception e) {
			e.printStackTrace();
			//ResultUtil.sendMsg(response, ResultUtil.FALSE, Message.LOAD_ERROR);
			ResultUtil.fail(Message.LOAD_ERROR);
		}
	}
	
	/**
	 * 	统计我的关注、粉丝与邻文数
	 *  
	 *  @param response 服务器响应
	 *  @param session session对象
	 *  @author xiongwu@iflytek.com
	 *  @created 2016年1月29日 上午9:57:55
	 *  @lastModified       
	 *  @history
	 */
	@RequestMapping("/home/myCountInfo.do")
	public void myCountInfo(HttpServletResponse response,HttpSession session) {
		
		TZlUserPerson user = (TZlUserPerson) session.getAttribute(SysCode.CURRENT_USER);
		
		ResultUtil.sendObject(response, zlUserRelationService.getCountAttention(user.getObjectid()));
	}
}




