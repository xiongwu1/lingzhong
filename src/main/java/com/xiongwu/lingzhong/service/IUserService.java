/**	
 * <br>
 * Copyright 2015 IFlyTek. All rights reserved.<br>
 * <br>			 
 * Package: com.xiongwu.lingzhong.service <br>
 * FileName: IUserService.java <br>
 * <br>
 * @version
 * @author xiongwu@iflytek.com
 * @created 2015年12月5日
 * @last Modified 
 * @history
 */

package com.xiongwu.lingzhong.service;

import com.xiongwu.lingzhong.domain.TZlUserPerson;
import com.xiongwu.lingzhong.domain.dto.LoginUserDto;
import com.xiongwu.utils.dto.ResultDto;

/**
 *  注册用户接口
 *  
 *  @author xiongwu@iflytek.com
 *  @created 2015年12月5日 下午4:48:52
 *  @lastModified       
 *  @history           
 */

public interface IUserService {
	
	/**
	 * 注册个人用户，返回相应的错误码
	 * 1、校验身份证号、登录名唯一性
	 * 3、校验邮箱验证码是否正确
	 * 4、保存用户信息
	 * 
	 *  @param user 个人用户信息
	 *  @param phoneValidateCode 手机验证吗
	 *  @param sessionId
	 *  @return
	 *  @author xiongwu@iflytek.com
	 *  @created 2015年12月9日 下午1:35:16
	 *  @lastModified       
	 *  @history
	 */
	ResultDto registerUser(TZlUserPerson user, String phoneValidateCode,String sessionId);

	/**
	 * 验证邮箱唯一性
	 * @param email 邮箱
	 * @return
	 */
	public ResultDto checkUserByEmail(String eamil);
	
	
	/**
	 * 	用户登陆
	 *  
	 *  @param loginUser 登陆用户Dto
	 *  @return
	 *  @author xiongwu@iflytek.com
	 *  @created 2015年12月15日 下午8:10:07
	 *  @lastModified       
	 *  @history
	 */
	public TZlUserPerson queryLoginUser(LoginUserDto loginUser);
	
	/**
	 * 	更新最后一次登陆时间
	 *  
	 *  @param loginName 登陆名
	 *  @return
	 *  @author xiongwu@iflytek.com
	 *  @created 2016年1月25日 下午4:55:49
	 *  @lastModified       
	 *  @history
	 */
	public int updateLastTimeLogin(LoginUserDto loginUser);
	
	
	/**
	 * 	修改密码
	 *  
	 *  @param email 邮箱
	 *  @param newPassword 新密码
	 *  @return
	 *  @author xiongwu@iflytek.com
	 *  @created 2015年12月23日 下午1:27:25
	 *  @lastModified       
	 *  @history
	 */
	public int updatePwd(String email, String newPassword);
	
	
	/**
	 * 	更换头像
	 *  
	 *  @param userId 当前用户ID
	 *  @param newHeadPhoto 新头像地址
	 *  @return
	 *  @author xiongwu@iflytek.com
	 *  @created 2016年2月22日 下午5:04:39
	 *  @lastModified       
	 *  @history
	 */
	public int updateHeadPhoto(String userId, String newHeadPhoto);
	
	/**
	 * 	根据当前用户ID获取用户信息
	 *  
	 *  @param userId 用户ID
	 *  @return
	 *  @author xiongwu@iflytek.com
	 *  @created 2016年2月23日 下午4:13:36
	 *  @lastModified       
	 *  @history
	 */
	public TZlUserPerson getUserPerson(String userId);
}




