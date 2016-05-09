/**	
 * <br>
 * Copyright 2015 IFlyTek. All rights reserved.<br>
 * <br>			 
 * Package: com.xiongwu.lingzhong.web <br>
 * FileName: AttachmentController.java <br>
 * <br>
 * @version
 * @author xiongwu@iflytek.com
 * @created 2016年1月15日
 * @last Modified 
 * @history
 */

package com.xiongwu.lingzhong.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.xiongwu.lingzhong.base.SysCode;
import com.xiongwu.lingzhong.domain.TZlUserPerson;
import com.xiongwu.lingzhong.service.IAttachmentService;
import com.xiongwu.utils.ResultUtil;

/**
 * 	图片附件上传控制层
 *  
 *  @author xiongwu@iflytek.com
 *  @created 2016年1月15日 下午7:14:26
 *  @lastModified       
 *  @history           
 */
@Controller
public class AttachmentController {
	
	/**
	 * 上传图片附件接口
	 */
	@Autowired
	private IAttachmentService attachmentService;
	
	
	@RequestMapping(value="/attach/uploadImg.do",method=RequestMethod.POST)
	public void uploadImg(HttpServletRequest request, HttpServletResponse response,
			 MultipartHttpServletRequest multipartRequest,HttpSession session) {
		//获取当前用户
		TZlUserPerson user = (TZlUserPerson) session.getAttribute(SysCode.CURRENT_USER);
		
		ResultUtil.sendObject(response, attachmentService.uploadImg(multipartRequest,user.getObjectid()));
	}

}




