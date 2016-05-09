/**	
 * <br>
 * Copyright 2015 IFlyTek. All rights reserved.<br>
 * <br>			 
 * Package: com.xiongwu.lingzhong.service.impl <br>
 * FileName: UserServiceImpl.java <br>
 * <br>
 * @version
 * @author xiongwu@iflytek.com
 * @created 2015年12月5日
 * @last Modified 
 * @history
 */

package com.xiongwu.lingzhong.service.impl;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.xiongwu.lingzhong.base.Message;
import com.xiongwu.lingzhong.base.SysCode;
import com.xiongwu.lingzhong.domain.TZlUserPerson;
import com.xiongwu.lingzhong.domain.dto.LoginUserDto;
import com.xiongwu.lingzhong.persistence.UserDao;
import com.xiongwu.lingzhong.service.IUserService;
import com.xiongwu.utils.DateUtils;
import com.xiongwu.utils.MD5Util;
import com.xiongwu.utils.ResultUtil;
import com.xiongwu.utils.StringUtil;
import com.xiongwu.utils.dto.ResultDto;

/**
 * 	注册用户接口实现类
 *  
 *  @author xiongwu@iflytek.com
 *  @created 2015年12月5日 下午4:49:27
 *  @lastModified       
 *  @history           
 */

public class UserServiceImpl implements IUserService {

	
	@Autowired
	private UserDao userDao;
	
	//log
	private Logger log = Logger.getLogger(this.getClass());
	
	/**
	 * 注册个人用户，返回相应的错误码
	 * 1、校验身份证号、登录名唯一性
	 * 3、校验邮箱验证码是否正确
	 * 4、保存用户信息
	 * 
	 * @param user 个人用户信息
	 * @return
	 */
	public ResultDto registerUser(TZlUserPerson user, String eamilValidateCode,String sessionId) {

		//校验登录名唯一性
		if(!userDao.verifyUserInfo(SysCode.USER.CLASSNAME, SysCode.USER.LOGINNAME, user.getLoginName())){
			return ResultUtil.fail(Message.LOGINNAME_NONUNIQUE);
		}
		//校验邮箱唯一性
		if(!userDao.verifyUserInfo(SysCode.USER.CLASSNAME, SysCode.USER.EMAIL, user.getEmail())){
			return ResultUtil.fail(Message.EMAIL_NONUNIQUE);
		}
		//校验手机号唯一性
		if(!userDao.verifyUserInfo(SysCode.USER.CLASSNAME, SysCode.USER.PHONE, user.getMobilePhone())){
			return ResultUtil.fail(Message.PHONE_NONUNIQUE);
		}
		
		//邮箱验证码
		if(!StringUtil.equals(eamilValidateCode, user.getEmailValidateCode())){
			log.info("#########邮箱验证码不一致############从session获取【"+sessionId+"】：【"+eamilValidateCode+"】,页面传递：【"+user.getEmailValidateCode()+"】");			
			return ResultUtil.fail(Message.EMAIL_RANDOM_ERROR);
		}
		//保存用户信息
		if(StringUtils.isEmpty(user.getObjectid())){
			user.setRegisteredTime(DateUtils.getCurrentGaDate());
			user.setUpdateTime(DateUtils.getCurrentGaDate());
			user.setUserType(SysCode.USER_TYPE.REGISTER);
			user.setIsLock(SysCode.NO_FLAG);
			user.setPassword(MD5Util.fiveEncode(user.getPassword()));
			userDao.save(user);
		}else{
			user.setUpdateTime(DateUtils.getCurrentGaDate());
			userDao.saveOrUpdate(user);
		}
		return ResultUtil.success(Message.REGISTER_SUCCESS);
	}

	
	/**
	 * 验证邮箱唯一性
	 * @param email 邮箱
	 * @return
	 */
	public ResultDto checkUserByEmail(String eamil) {
		//校验邮箱唯一性
		if(!userDao.verifyUserInfo(SysCode.USER.CLASSNAME, SysCode.USER.EMAIL, eamil)){
			return ResultUtil.fail(Message.EMAIL_NONUNIQUE);
		}
		return ResultUtil.success(Message.SUCCESS);
	}


	/**
	 * 	用户登陆
	 * 
	 *  @param loginUser 用户Dto
	 *  @return
	 *  @author xiongwu@iflytek.com
	 *  @created 2015年12月15日 下午8:46:04
	 *  @lastModified      
	 *  @history
	 */
	@Override
	public TZlUserPerson queryLoginUser(LoginUserDto loginUser) {
		TZlUserPerson user=userDao.queryUniqueLoginUser(loginUser);
		return user;
	}

	@Override
	public int updateLastTimeLogin(LoginUserDto loginUser) {
		return userDao.updateLastTimeLogin(loginUser);
	}

	/**
	 *  修改密码
	 *  
	 *  @param email 邮箱
	 *  @param newPassword 新密码
	 *  @return
	 *  @author xiongwu@iflytek.com
	 *  @created 2015年12月23日 下午1:28:21
	 *  @lastModified      
	 *  @history
	 */
	@Override
	public int updatePwd(String email, String newPassword) {
		
		return userDao.updatePwd(email, newPassword);
	}


	/**
	 * 	用户更换头像
	 * 
	 *  @param userId 当前用户ID
	 *  @param newHeadPhoto 新头像地址
	 *  @return
	 *  @author xiongwu@iflytek.com
	 *  @created 2016年2月22日 下午5:06:14
	 *  @lastModified      
	 *  @history
	 */
	@Override
	public int updateHeadPhoto(String userId, String newHeadPhoto) {
		
		return userDao.updateHeadPhoto(userId, newHeadPhoto);
	}
	
	@Override
	public TZlUserPerson getUserPerson(String userId) {
		return userDao.queryUserPerson(userId);
	}
}




