/**	
 * <br>
 * Copyright 2015 IFlyTek. All rights reserved.<br>
 * <br>			 
 * Package: com.xiongwu.lingzhong.persistence <br>
 * FileName: ZlBlogOperate.java <br>
 * <br>
 * @version
 * @author xiongwu@iflytek.com
 * @created 2016年1月23日
 * @last Modified 
 * @history
 */

package com.xiongwu.lingzhong.persistence;

import java.util.List;

import com.iflytek.iframework.orm.hibernate.HibernateEntityDao;
import com.iflytek.iframework.utils.HqlMaker;
import com.xiongwu.lingzhong.base.SysCode;
import com.xiongwu.lingzhong.domain.TZlBlogOperate;

/**
 * 	邻文操作Dao
 *  
 *  @author xiongwu@iflytek.com
 *  @created 2016年1月23日 下午4:15:43
 *  @lastModified       
 *  @history           
 */

public class ZlBlogOperateDao extends HibernateEntityDao<TZlBlogOperate> {

	
	/**
	 * 	根据邻文ID统计点赞数量
	 *  
	 *  @param lwBlogId 邻文ID
	 *  @return
	 *  @author xiongwu@iflytek.com
	 *  @created 2016年1月23日 下午4:24:24
	 *  @lastModified       
	 *  @history
	 */
	public int queryLwLikeSum(String lwBlogId) {
		
		StringBuffer sql = new StringBuffer();
		
		sql.append(" select count(1) from t_zl_blog_operate t1               ");
		sql.append(" where 1=1        ");
		
		//查询条件：邻文ID
		sql.append(HqlMaker.popuHqlEq("t1.blogid", lwBlogId));
		//操作类型：赞
		sql.append(HqlMaker.popuHqlEq("t1.operate_type", SysCode.IS_FLAG));
		//未删除
		sql.append(HqlMaker.popuHqlEq("t1.delete_staues", SysCode.NO_FLAG));
		
		return (int) super.countSqlResult(sql.toString());
	}
	
	/**
	 * 	查询该条邻文是否已被收藏
	 *  
	 *  @param currentUserId 当前用户ID
	 *  @param lwBlogId 邻文ID
	 *  @return
	 *  @author xiongwu@iflytek.com
	 *  @created 2016年2月1日 下午4:51:29
	 *  @lastModified       
	 *  @history
	 */
	public TZlBlogOperate queryIsCollection(String currentUserId,String lwBlogId) {
		StringBuffer sql = new StringBuffer();
		
		sql.append("from TZlBlogOperate where userId=? and blogId=? and operateType='1' ");
		
		@SuppressWarnings("unchecked")
		List<TZlBlogOperate> list = this.createQuery(sql.toString(),currentUserId,lwBlogId).list();
        if(list.size()>0){
        	return list.get(0);
        }else{
        	return null;
        }
	}
	
	/**
	 * 	取消收藏操作
	 *  
	 *  @param currentUserId 当前用户ID
	 *  @param lwBlogId 邻文ID
	 *  @author xiongwu@iflytek.com
	 *  @created 2016年2月1日 下午5:41:45
	 *  @lastModified       
	 *  @history
	 */
	public void cancelCollection(String currentUserId,String lwBlogId) {
		StringBuffer sql = new StringBuffer();
		sql.append("delete from TZlBlogOperate where userId=? and blogId=? and operateType='1'");
		super.createQuery(sql.toString(), currentUserId,lwBlogId).executeUpdate();
	}
	
	/**
	 * 	查询该条邻文是否已被点赞
	 *  
	 *  @param currentUserId 当前用户ID
	 *  @param lwBlogId 邻文ID
	 *  @return
	 *  @author xiongwu@iflytek.com
	 *  @created 2016年2月2日 上午9:39:32
	 *  @lastModified       
	 *  @history
	 */
	public TZlBlogOperate queryIsLike(String currentUserId,String lwBlogId) {
		StringBuffer sql = new StringBuffer();
		
		sql.append("from TZlBlogOperate where userId=? and blogId=? and operateType='0' ");
		
		@SuppressWarnings("unchecked")
		List<TZlBlogOperate> list = this.createQuery(sql.toString(),currentUserId,lwBlogId).list();
        if(list.size()>0){
        	return list.get(0);
        }else{
        	return null;
        }
	}
	
	/**
	 * 	取消点赞操作
	 *  
	 *  @param currentUserId 当前用户ID
	 *  @param lwBlogId 邻文ID
	 *  @author xiongwu@iflytek.com
	 *  @created 2016年2月2日 上午9:40:45
	 *  @lastModified       
	 *  @history
	 */
	public void cancelLike(String currentUserId,String lwBlogId) {
		StringBuffer sql = new StringBuffer();
		sql.append("delete from TZlBlogOperate where userId=? and blogId=? and operateType='0' ");
		super.createQuery(sql.toString(), currentUserId,lwBlogId).executeUpdate();
	}
}



