/**	
 * <br>
 * Copyright 2015 IFlyTek. All rights reserved.<br>
 * <br>			 
 * Package: com.xiongwu.lingzhong.web <br>
 * FileName: ZlOperateController.java <br>
 * <br>
 * @version
 * @author xiongwu@iflytek.com
 * @created 2016年2月1日
 * @last Modified 
 * @history
 */

package com.xiongwu.lingzhong.web;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xiongwu.lingzhong.base.SysCode;
import com.xiongwu.lingzhong.domain.TZlUserPerson;
import com.xiongwu.lingzhong.service.IZlBlogOperateService;
import com.xiongwu.utils.ResultUtil;

/**
 * 	邻文操作控制层
 *  
 *  @author xiongwu@iflytek.com
 *  @created 2016年2月1日 下午3:49:01
 *  @lastModified       
 *  @history           
 */

@Controller
public class LwOperateController {

	/**
	 * 邻文操作接口
	 */
	@Autowired
	private IZlBlogOperateService zlBlogOperateService;
	
	/**
	 * 	收藏邻文操作
	 *  
	 *  @param response 服务器返回对象
	 *  @param lwBlogId 邻文ID
	 *  @param session session对象
	 *  @author xiongwu@iflytek.com
	 *  @created 2016年2月1日 下午3:55:47
	 *  @lastModified       
	 *  @history
	 */
	@RequestMapping(value="/lwOperate/collectionLw.do",method=RequestMethod.POST)
	public void collectionLw(HttpServletResponse response,
			String lwBlogId,HttpSession session) {
		
		TZlUserPerson user = (TZlUserPerson) session.getAttribute(SysCode.CURRENT_USER);
		ResultUtil.sendResult(response, zlBlogOperateService.saveLwCollection(lwBlogId, user.getObjectid()));
		
	}
	
	/**
	 * 	取消收藏操作
	 *  
	 *  @param response 服务器返回
	 *  @param session session对象
	 *  @param lwBlogId 邻文ID
	 *  @author xiongwu@iflytek.com
	 *  @created 2016年1月27日 下午4:53:29
	 *  @lastModified       
	 *  @history
	 */
	@RequestMapping("/lwOperate/cancelCollection.do")
	public void cancelCollection(HttpServletResponse response,HttpSession session,String lwBlogId) {
		
		TZlUserPerson user = (TZlUserPerson) session.getAttribute(SysCode.CURRENT_USER);
		ResultUtil.sendResult(response, zlBlogOperateService.cancelCollection(user.getObjectid(),lwBlogId));
	}
	
	/**
	 * 	点赞邻文操作
	 *  
	 *  @param response 服务器返回对象
	 *  @param lwBlogId 邻文ID
	 *  @param session session对象
	 *  @author xiongwu@iflytek.com
	 *  @created 2016年2月2日 上午10:25:03
	 *  @lastModified       
	 *  @history
	 */
	@RequestMapping(value="/lwOperate/LwLike.do",method=RequestMethod.POST)
	public void LwLike(HttpServletResponse response,
			String lwBlogId,HttpSession session) {
		
		TZlUserPerson user = (TZlUserPerson) session.getAttribute(SysCode.CURRENT_USER);
		ResultUtil.sendResult(response, zlBlogOperateService.saveLwLike(lwBlogId, user.getObjectid()));
		
	}
	
	/**
	 * 	取消点赞操作
	 *  
	 *  @param response 服务器返回
	 *  @param session session对象
	 *  @param lwBlogId 邻文ID
	 *  @author xiongwu@iflytek.com
	 *  @created 2016年2月2日 上午10:27:29
	 *  @lastModified       
	 *  @history
	 */
	@RequestMapping("/lwOperate/cancelLike.do")
	public void cancelLike(HttpServletResponse response,HttpSession session,String lwBlogId) {
		
		TZlUserPerson user = (TZlUserPerson) session.getAttribute(SysCode.CURRENT_USER);
		ResultUtil.sendResult(response, zlBlogOperateService.cancelLike(user.getObjectid(),lwBlogId));
	}
	
	
}




