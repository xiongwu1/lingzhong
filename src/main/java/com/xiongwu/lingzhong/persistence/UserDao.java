/**	
 * <br>
 * Copyright 2015 IFlyTek. All rights reserved.<br>
 * <br>			 
 * Package: com.xiongwu.lingzhong.persistence <br>
 * FileName: UserDao.java <br>
 * <br>
 * @version
 * @author xiongwu@iflytek.com
 * @created 2015年12月5日
 * @last Modified 
 * @history
 */

package com.xiongwu.lingzhong.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.iflytek.iframework.orm.hibernate.HibernateEntityDao;
import com.iflytek.iframework.utils.HqlMaker;
import com.xiongwu.lingzhong.domain.TZlUserPerson;
import com.xiongwu.lingzhong.domain.dto.LoginUserDto;
import com.xiongwu.lingzhong.domain.dto.LwBlogListDto;
import com.xiongwu.utils.DateUtils;
import com.xiongwu.utils.HibernateUtil;

/**
 *  注册用户Dao
 *  
 *  @author xiongwu@iflytek.com
 *  @created 2015年12月5日 下午4:50:46
 *  @lastModified       
 *  @history           
 */

public class UserDao extends HibernateEntityDao<TZlUserPerson>{
	
	/**
	 * hibernate查询工具
	 */
	@Autowired
	public HibernateUtil<LwBlogListDto> hibernateUtil;
	
	/**
	 * 	验证唯一性
	 *  
	 *  @param classname 表名
	 *  @param fieldName
	 *  @param fieldValue
	 *  @return
	 *  @author xiongwu@iflytek.com
	 *  @created 2015年12月9日 下午1:37:26
	 *  @lastModified       
	 *  @history
	 */
	public boolean verifyUserInfo(String classname, String fieldName, String fieldValue) {
		StringBuilder hql = new StringBuilder("select count(*) from ").append(classname).append(" where 1=1 ");
        hql.append(HqlMaker.popuHqlEq(fieldName, fieldValue));
        if(Integer.parseInt(this.createQuery(hql.toString()).uniqueResult().toString()) > 0){
        	return false;
        }
		return true;
	}
	
	/**
	 * 	登陆
	 *  
	 *  @param loginUser 登陆用户
	 *  @return
	 *  @author xiongwu@iflytek.com
	 *  @created 2015年12月23日 下午1:29:35
	 *  @lastModified       
	 *  @history
	 */
	public TZlUserPerson queryUniqueLoginUser(LoginUserDto loginUser) {
		StringBuilder hql = new StringBuilder(" from TZlUserPerson where ");
		hql.append("loginName=? or email=? or mobilePhone=?");

        @SuppressWarnings("unchecked")
		List<TZlUserPerson> list = this.createQuery(hql.toString(),loginUser.getLoginName(),
				loginUser.getEmail(),loginUser.getMobilePhone()).list();
        if(list.size()>0){
        	return list.get(0);
        }else{
        	return null;
        }
	}
	
	/**
	 * 	更新最后一次登陆时间
	 *  
	 *  @param userId 用户ID
	 *  @return
	 *  @author xiongwu@iflytek.com
	 *  @created 2016年1月25日 下午4:51:18
	 *  @lastModified       
	 *  @history
	 */
	public int updateLastTimeLogin(LoginUserDto loginUser) {
		
		StringBuffer queryHql=new StringBuffer(" ");
		queryHql.append(" update TZlUserPerson set lastLoginTime=:lastLoginTime where loginName=:loginName or email=:email or mobilePhone=:mobilePhone ");
		return createQuery(queryHql.toString()).setParameter("lastLoginTime", DateUtils.getCurrentGaDate()).setParameter("loginName", loginUser.getLoginName())
				.setParameter("email", loginUser.getEmail()).setParameter("mobilePhone", loginUser.getMobilePhone()).executeUpdate();
	}
	
	/**
	 * 	用户修改密码
	 *  
	 *  @param email 邮箱
	 *  @param newPassword 新密码
	 *  @return
	 *  @author xiongwu@iflytek.com
	 *  @created 2015年12月23日 下午1:38:02
	 *  @lastModified       
	 *  @history
	 */
	public int updatePwd(String email, String newPassword) {
		
		StringBuffer queryHql=new StringBuffer(" ");
		queryHql.append(" update TZlUserPerson set password=:password, updateTime=:updateTime where email=:email ");
		int num = createQuery(queryHql.toString()).setParameter("password", newPassword).setParameter("updateTime", DateUtils.getCurrentGaDate()).setParameter("email", email).executeUpdate();
		return num;
	}
	
	/**
	 * 	用户更换头像
	 *  
	 *  @param userId 当前用户ID
	 *  @param newHeadPhoto 新头像的URL
	 *  @return
	 *  @author xiongwu@iflytek.com
	 *  @created 2016年2月22日 下午5:02:08
	 *  @lastModified       
	 *  @history
	 */
	public int updateHeadPhoto(String userId,String newHeadPhoto) {
		
		StringBuffer queryHql=new StringBuffer(" ");
		queryHql.append(" update TZlUserPerson set headPortrait=:headPortrait, updateTime=:updateTime where objectid=:objectid ");
		int num = createQuery(queryHql.toString()).setParameter("headPortrait", newHeadPhoto).setParameter("updateTime", DateUtils.getCurrentGaDate()).setParameter("objectid", userId).executeUpdate();
		return num;
	}
	
	/**
	 * 	根据当前用户ID获取用户信息
	 *  
	 *  @param userId 当前用户ID
	 *  @return
	 *  @author xiongwu@iflytek.com
	 *  @created 2016年2月23日 下午4:18:09
	 *  @lastModified       
	 *  @history
	 */
	public TZlUserPerson queryUserPerson(String userId) {
		StringBuilder hql = new StringBuilder(" from TZlUserPerson where ");
		hql.append("objectid=?");
        @SuppressWarnings("unchecked")
		List<TZlUserPerson> list = this.createQuery(hql.toString(),userId).list();
        if(list.size()>0){
        	return list.get(0);
        }else{
        	return null;
        }
	}
}




