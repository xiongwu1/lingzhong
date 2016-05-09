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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xiongwu.lingzhong.base.Message;
import com.xiongwu.lingzhong.base.SysCode;
import com.xiongwu.lingzhong.domain.TZlUserPerson;
import com.xiongwu.lingzhong.domain.dto.LwBlogDto;
import com.xiongwu.lingzhong.service.ILwBlogService;
import com.xiongwu.utils.ResultUtil;
import com.xiongwu.utils.dto.ResultDto;

/**
 * 	邻文控制器
 *  
 *  @author xiongwu@iflytek.com
 *  @created 2016年1月13日 下午2:55:19
 *  @lastModified       
 *  @history           
 */
@Controller
public class LwBlogController {
	
	@Autowired
	private ILwBlogService lwBlogService;
	
	@RequestMapping("/lwBlog/**.do")
	public Model golwBlogPage(Model model) {
		return model;
	}
	
	/**
	 * 	发表邻文
	 *  
	 *  @param request 	Request请求
	 *  @param response 服务器响应
	 *  @param zlBlogDto 邻文DTO 
	 *  @param imgIdStr 图片ID字符串
	 *  @param session Session对象
	 *  @author xiongwu@iflytek.com
	 *  @created 2016年1月16日 下午4:17:49
	 *  @lastModified       
	 *  @history
	 */
	@RequestMapping(value="/lwBlog/publishLwBlog.do",method=RequestMethod.POST)
	public void publishLwBlog(HttpServletRequest request, HttpServletResponse response,LwBlogDto zlBlogDto,
			String imgIdStr,HttpSession session) {
		
		TZlUserPerson user = (TZlUserPerson) session.getAttribute(SysCode.CURRENT_USER);
		ResultUtil.sendResult(response, lwBlogService.saveLwBlog(zlBlogDto, user.getObjectid(),imgIdStr));
	}
	
	/**
	 * 	删除我的邻文
	 *  
	 *  @param request 	Request请求
	 *  @param response 服务器响应
	 *  @param lwBlogId 我的邻文ID
	 *  @author xiongwu@iflytek.com
	 *  @created 2016年1月30日 下午2:35:25
	 *  @lastModified       
	 *  @history
	 */
	@RequestMapping(value="/lwBlog/deleteLwBlog.do",method=RequestMethod.POST)
	public void deleteLwBlog(HttpServletRequest request, HttpServletResponse response,String lwBlogId) {
		ResultDto rd = null;
		try {
			int num = lwBlogService.deleteLwBlog(lwBlogId);
			if (num > 0) {
				rd = new ResultDto(SysCode.TRUE, Message.SUCCESS);
			}else {
				rd = new ResultDto(SysCode.FALSE, Message.FAILURE);
			}
			ResultUtil.sendResult(response, rd);
		} catch (Exception e) {
			e.printStackTrace();
			ResultUtil.sendResult(response, ResultUtil.fail(Message.FAILURE));
		}
		
	}
}




