/**	
 * <br>
 * Copyright 2015 IFlyTek. All rights reserved.<br>
 * <br>			 
 * Package: com.iflytek.lingzhong.web <br>
 * FileName: UserController.java <br>
 * <br>
 * @version
 * @author xiongwu@iflytek.com
 * @created 2015年12月4日
 * @last Modified 
 * @history
 */

package com.xiongwu.lingzhong.web;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xiongwu.lingzhong.base.BasicSysCodeManager;
import com.xiongwu.lingzhong.base.Message;
import com.xiongwu.lingzhong.base.SysCode;
import com.xiongwu.lingzhong.domain.TZlUserPerson;
import com.xiongwu.lingzhong.domain.dto.LoginUserDto;
import com.xiongwu.lingzhong.service.IAttachmentService;
import com.xiongwu.lingzhong.service.IUserService;
import com.xiongwu.utils.ImageUtil;
import com.xiongwu.utils.MD5Util;
import com.xiongwu.utils.ResultUtil;
import com.xiongwu.utils.SessionUtil;
import com.xiongwu.utils.dto.ResultDto;

/**
 * 用户Controller
 * 
 * @author xiongwu@iflytek.com
 * @created 2015年12月4日 下午12:58:37
 * @lastModified
 * @history
 */
@Controller
public class UserController {

	/**
	 * 注册用户接口
	 */
	@Autowired
	private IUserService userService;

	/**
	 * 上传图片附件接口
	 */
	@Autowired
	private IAttachmentService attachmentService;

	/**
	 * 系统注入类
	 */
	@Autowired
	private BasicSysCodeManager basicSysCodeManager;

	@RequestMapping("/user/**.do")
	public Model goPortalPage(Model model) {
		return model;
	}

	/**
	 * 注册用户信息
	 * 
	 * @param user
	 *            用户对象
	 * @param response
	 * @param session
	 * @author xiongwu@iflytek.com
	 * @created 2015年12月4日 下午8:55:56
	 * @lastModified
	 * @history
	 */
	@RequestMapping(value = "/user/registerSave.do", method = RequestMethod.POST)
	public void userRegist(TZlUserPerson user, HttpServletResponse response,
			HttpSession session) {

		try {
			// 从session中取出邮箱验证码
			String dynamicPassword = (String) session
					.getAttribute(SysCode.USER.DYNAMIC_PASSWORD);
			ResultUtil.sendResult(
					response,
					userService.registerUser(user, dynamicPassword,
							session.getId()));
		} catch (RuntimeException e) {
			e.printStackTrace();
			ResultUtil.sendResult(response,
					ResultUtil.fail(Message.REGISTER_FAIL));
		}
	}

	/**
	 * 用户登陆操作
	 * 
	 * @param loginUser
	 *            登陆用户Dto
	 * @param password
	 *            密码
	 * @param randomCode
	 *            验证码
	 * @param session
	 * @param response
	 * @param request
	 * @author xiongwu@iflytek.com
	 * @created 2015年12月15日 下午8:57:29
	 * @lastModified
	 * @history
	 */
	@RequestMapping(value = "/user/userLogin.do", method = RequestMethod.POST)
	public void userLogin(LoginUserDto loginUser, String password,
			String randomCode, HttpSession session,
			HttpServletResponse response, HttpServletRequest request) {
		ResultDto rd = null;
		try {
			TZlUserPerson user = userService.queryLoginUser(loginUser);
			if (user != null) {
				if (StringUtils.equals(MD5Util.fiveEncode(password),
						user.getPassword())) {
					// 登录成功
					session.setAttribute(SysCode.CURRENT_USER, user);
					int lastLoginTime = userService
							.updateLastTimeLogin(loginUser);
					if (lastLoginTime == 0) {
						rd = new ResultDto(SysCode.TRUE, Message.FAILURE);
					}

					rd = new ResultDto(SysCode.TRUE, Message.LOGIN_SUCCESS,
							user);
				} else {
					// 密码错误
					rd = new ResultDto(SysCode.FALSE, Message.PASSWORD_ERROR);
				}
			} else {
				// 账号错误
				rd = new ResultDto(SysCode.FALSE, Message.LOGINNAME_ERROR);
			}
		} catch (Exception e) {
			e.printStackTrace();
			rd = new ResultDto(SysCode.FALSE, Message.LOAD_ERROR);
		}
		ResultUtil.sendResult(response, rd);
	}

	/**
	 * 用户登出
	 * 
	 * @param session
	 * @param response
	 * @param request
	 * @author xiongwu@iflytek.com
	 * @created 2015年12月16日 下午5:09:38
	 * @lastModified
	 * @history
	 */
	@RequestMapping(value = "/user/loginout.do", method = RequestMethod.POST)
	public void userLogout(HttpSession session, HttpServletResponse response,
			HttpServletRequest request) {
		try {
			SessionUtil.removeSession(session);
			ResultUtil
					.sendResult(response, ResultUtil.success(Message.SUCCESS));
		} catch (Exception e) {
			e.printStackTrace();
			ResultUtil.sendResult(response, ResultUtil.fail(Message.FAILURE));
		}
	}

	/**
	 * 找回密码
	 * 
	 * @param session
	 * @param response
	 * @param request
	 * @author xiongwu@iflytek.com
	 * @created 2015年12月22日 下午7:35:54
	 * @lastModified
	 * @history
	 */
	@RequestMapping(value = "/user/findPwd.do", method = RequestMethod.POST)
	public void findPwd(HttpSession session, String ForgotEmailValidateCode,
			String email, HttpServletResponse response,
			HttpServletRequest request) {
		ResultDto rd = null;

		try {
			// 从session中取出邮箱验证码
			String dynamicPassword = (String) session
					.getAttribute(SysCode.USER.DYNAMIC_PASSWORD);

			if (ForgotEmailValidateCode.equals(dynamicPassword)) {
				rd = new ResultDto(SysCode.TRUE, Message.SUCCESS,
						dynamicPassword);
			} else {
				rd = new ResultDto(SysCode.TRUE, Message.EMAIL_RANDOM_ERROR);
			}

			ResultUtil.sendResult(response, rd);

		} catch (RuntimeException e) {
			e.printStackTrace();
			ResultUtil.sendResult(response, ResultUtil.fail(Message.FAILURE));
		}
	}

	/**
	 * 修改密码
	 * 
	 * @param objectid
	 *            用户ID
	 * @param OriginalPwd
	 *            原始密码
	 * @param newPassword
	 *            新密码
	 * @param response
	 * @param request
	 * @author xiongwu@iflytek.com
	 * @created 2015年12月23日 下午1:46:17
	 * @lastModified
	 * @history
	 */
	@RequestMapping(value = "/user/updatePwd.do", method = RequestMethod.POST)
	public void updatePwd(String email, String OriginalPwd, String newPassword,
			HttpServletResponse response, HttpServletRequest request) {
		ResultDto rd = null;
		try {
			// 如果原始密码为空，则为找回密码
			if (OriginalPwd == null) {
				int num = userService.updatePwd(email,
						MD5Util.fiveEncode(newPassword));
				if (num > 0) {
					rd = new ResultDto(SysCode.TRUE, Message.SUCCESS);
				} else {
					rd = new ResultDto(SysCode.FALSE, Message.FAILURE);
				}
			} else {

			}

			ResultUtil.sendResult(response, rd);

		} catch (RuntimeException e) {
			e.printStackTrace();
			ResultUtil.sendResult(response, ResultUtil.fail(Message.FAILURE));
		}
	}

	/**
	 * 更换头像
	 * 
	 * @param response
	 *            服务器响应
	 * @param request
	 *            服务器请求
	 * @param headPhotoUrl
	 *            新头像地址
	 * @author xiongwu@iflytek.com
	 * @created 2016年2月22日 下午5:03:24
	 * @lastModified
	 * @history
	 */
	@RequestMapping(value = "/user/updateHead.do", method = RequestMethod.POST)
	public void updateHeadPhoto(HttpServletResponse response,
			HttpServletRequest request, HttpSession session, String headPhotoUrl) {
		ResultDto rd = null;

		// 获取当前用户
		TZlUserPerson user = (TZlUserPerson) session
				.getAttribute(SysCode.CURRENT_USER);

		// base64字符串转化成图片
		String filePath = ImageUtil.GenerateImage(
				headPhotoUrl.substring(22, headPhotoUrl.length() - 1),
				basicSysCodeManager.getUploadHeadUrl(),
				basicSysCodeManager.getImgFormat());

		// 将头像图片保存到FastDFS
		File file = new File(filePath);
		String headUrl = attachmentService.uploadHead(file);
		try {
			int num = userService.updateHeadPhoto(user.getObjectid(), headUrl);
			if (num > 0) {
				rd = new ResultDto(SysCode.TRUE, Message.SUCCESS);
			} else {
				rd = new ResultDto(SysCode.FALSE, Message.FAILURE);
			}

			ResultUtil.sendResult(response, rd);
		} catch (RuntimeException e) {
			e.printStackTrace();
			ResultUtil.sendResult(response, ResultUtil.fail(Message.FAILURE));
		}
	}

	/**
	 * 	获取当前用户信息
	 *  
	 *  @param response 服务器响应
	 *  @param request 服务器请求
	 *  @param session session对象
	 *  @return
	 *  @author xiongwu@iflytek.com
	 *  @created 2016年2月23日 下午4:19:22
	 *  @lastModified       
	 *  @history
	 */
	@RequestMapping(value = "/user/getUserPerson.do", method = RequestMethod.POST)
	public void getUserPerson(HttpServletResponse response,
			HttpServletRequest request, HttpSession session) {
		// 获取当前用户
		TZlUserPerson user = (TZlUserPerson) session
				.getAttribute(SysCode.CURRENT_USER);
		TZlUserPerson userPerson = userService.getUserPerson(user.getObjectid());
		ResultUtil.sendObject(response, userPerson);
	}
}
