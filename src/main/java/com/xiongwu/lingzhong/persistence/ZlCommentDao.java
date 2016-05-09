/**	
 * <br>
 * Copyright 2015 IFlyTek. All rights reserved.<br>
 * <br>			 
 * Package: com.xiongwu.lingzhong.persistence <br>
 * FileName: ZlCommentDao.java <br>
 * <br>
 * @version
 * @author xiongwu@iflytek.com
 * @created 2016年1月23日
 * @last Modified 
 * @history
 */

package com.xiongwu.lingzhong.persistence;

import com.iflytek.iframework.orm.hibernate.HibernateEntityDao;
import com.iflytek.iframework.utils.HqlMaker;
import com.xiongwu.lingzhong.base.SysCode;
import com.xiongwu.lingzhong.domain.TZlComment;

/**
 * 	邻文评论Dao
 *  
 *  @author xiongwu@iflytek.com
 *  @created 2016年1月23日 下午3:10:05
 *  @lastModified       
 *  @history           
 */

public class ZlCommentDao extends HibernateEntityDao<TZlComment>{
	
	/**
	 * 	根据邻文ID统计评论数量
	 *  
	 *  @param lwBlogId 邻文ID
	 *  @return
	 *  @author xiongwu@iflytek.com
	 *  @created 2016年1月23日 下午3:12:24
	 *  @lastModified       
	 *  @history
	 */
	public int queryLwCommentSum(String lwBlogId) {
		
		StringBuffer sql = new StringBuffer();
		
		sql.append(" select count(1) from t_zl_comment t                      ");
		sql.append(" where 1=1        ");
		
		//查询条件：邻文ID
		sql.append(HqlMaker.popuHqlEq("t.blogid", lwBlogId));
		//未删除
		sql.append(HqlMaker.popuHqlEq("t.delete_staues", SysCode.NO_FLAG));
		
		return (int) super.countSqlResult(sql.toString());
	}

}




