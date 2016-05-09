/**	
 * <br>
 * Copyright 2015 IFlyTek. All rights reserved.<br>
 * <br>			 
 * Package: com.xiongwu.lingzhong.web <br>
 * FileName: ZlUserRelationController.java <br>
 * <br>
 * @version
 * @author xiongwu@iflytek.com
 * @created 2016年1月26日
 * @last Modified 
 * @history
 */

package com.xiongwu.lingzhong.web;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xiongwu.lingzhong.base.SysCode;
import com.xiongwu.lingzhong.domain.TZlUserPerson;
import com.xiongwu.lingzhong.service.IZlUserRelationService;
import com.xiongwu.utils.ResultUtil;

/**
 * 	众邻-用户关系Controller
 *  
 *  @author xiongwu@iflytek.com
 *  @created 2016年1月26日 上午10:32:15
 *  @lastModified       
 *  @history           
 */
@Controller
public class ZlUserRelationController {
	
	/**
	 * 	众邻-用户关系实现类
	 */
	@Autowired
	private IZlUserRelationService zlUserRelationService;
	
	
	/**
	 * 	加关注操作
	 *  
	 *  @param response 服务器返回
	 *  @param session session对象
	 *  @param attentUserId 被关注用户ID
	 *  @author xiongwu@iflytek.com
	 *  @created 2016年1月27日 下午12:48:38
	 *  @lastModified       
	 *  @history
	 */
	@RequestMapping("/payAttention.do")
	public void payAttention(HttpServletResponse response,HttpSession session,String attentUserId) {
		
		TZlUserPerson user = (TZlUserPerson) session.getAttribute(SysCode.CURRENT_USER);
		if(attentUserId != null) {
			if(user.getObjectid().equals(attentUserId)) {
				ResultUtil.sendString(response,SysCode.FALSE);
			}else {
				ResultUtil.sendResult(response, zlUserRelationService.saveUserRelation(user.getObjectid(),attentUserId));
			}
		}else {
			ResultUtil.sendString(response,SysCode.NO_FLAG);
		}
		
	}
	
	/**
	 * 	取消关注操作
	 *  
	 *  @param response 服务器返回
	 *  @param session session对象
	 *  @param attentUserId 被关注用户ID
	 *  @author xiongwu@iflytek.com
	 *  @created 2016年1月27日 下午4:53:29
	 *  @lastModified       
	 *  @history
	 */
	@RequestMapping("/cancelAttention.do")
	public void cancelAttention(HttpServletResponse response,HttpSession session,String attentUserId) {
		
		TZlUserPerson user = (TZlUserPerson) session.getAttribute(SysCode.CURRENT_USER);
		ResultUtil.sendResult(response, zlUserRelationService.cancelAttention(user.getObjectid(),attentUserId));
	}
}




