/**	
 * <br>
 * Copyright 2015 IFlyTek. All rights reserved.<br>
 * <br>			 
 * Package: com.xiongwu.lingzhong.persistence <br>
 * FileName: LwBlogDao.java <br>
 * <br>
 * @version
 * @author xiongwu@iflytek.com
 * @created 2016年1月16日
 * @last Modified 
 * @history
 */

package com.xiongwu.lingzhong.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.iflytek.iframework.orm.Page;
import com.iflytek.iframework.orm.hibernate.HibernateEntityDao;
import com.iflytek.iframework.utils.HqlMaker;
import com.xiongwu.lingzhong.base.SysCode;
import com.xiongwu.lingzhong.domain.TZlBlog;
import com.xiongwu.lingzhong.domain.dto.LwBlogDto;
import com.xiongwu.lingzhong.domain.dto.LwBlogListDto;
import com.xiongwu.utils.HibernateUtil;

/**
 * 	邻文Dao
 *  
 *  @author xiongwu@iflytek.com
 *  @created 2016年1月16日 下午3:28:59
 *  @lastModified       
 *  @history           
 */

public class LwBlogDao extends HibernateEntityDao<TZlBlog>{
	
	/**
	 * hibernate查询工具
	 */
	@Autowired
	public HibernateUtil<LwBlogListDto> hibernateUtil;
	
	/**
	 * 	查询最新的邻文分页结果
	 *  
	 *  @param page 分页
	 *  @return
	 *  @author xiongwu@iflytek.com
	 *  @created 2016年1月19日 下午1:55:48
	 *  @lastModified       
	 *  @history
	 */
	public Page<LwBlogListDto> queryNewLwBlogPage(Page<LwBlogListDto> page){
		
		StringBuffer sql = new StringBuffer();
		
		 sql.append(" select t1.objectid,t1.content,t1.release_time,t1.release_place,t2.nick_name,t2.head_portrait  ");
		 sql.append("     from t_zl_blog t1                                                                            ");
		 sql.append("     inner join t_zl_user_person t2                                                                ");
		 sql.append("     on t1.userid = t2.objectid                                                                   ");
		 sql.append("     where 1=1   ");
		 
		//未删除状态
		sql.append(HqlMaker.popuHqlEq("t1.delete_staues", SysCode.NO_FLAG));
		//公开状态
		sql.append(HqlMaker.popuHqlEq("t1.is_open", SysCode.IS_FLAG));
		sql.append("order by t1.release_time desc");
		
		/*// 总条数
		page.setTotalCount(super.countSqlResult(sql.toString()));
		@SuppressWarnings("unchecked")
		List<LwBlogListDto> list = this
				.createSqlQuery(sql.toString())
				.setFirstResult((page.getCurrentPageNo() - 1) * page.getPageSize())
				.setMaxResults(page.getPageSize())
				.setResultTransformer(ResultTransformers.aliasToBean(LwBlogListDto.class)).list();
		// set 结果
		page.setResult(list);
		return page;*/
		
		return hibernateUtil.findSqlPage(page, sql.toString(),
				LwBlogListDto.class);
	}
	
	/**
	 * 	查询我的好友最新的邻文分页结果
	 *  
	 *  @param page 分页
	 *  @param currentUserId 当前用户ID
	 *  @return
	 *  @author xiongwu@iflytek.com
	 *  @created 2016年1月28日 上午11:20:09
	 *  @lastModified       
	 *  @history
	 */
	public Page<LwBlogListDto> queryMyFriendsNewLwPage(Page<LwBlogListDto> page,String currentUserId){
		
		StringBuffer sql = new StringBuffer();
		
		sql.append(" select t7.user_id,t7.objectid,t7.content,t7.release_time,t7.release_place,t7.nick_name,t7.head_portrait from                  ");
		sql.append(" (select t4.objectid user_id,t3.objectid,t3.content,t3.release_time,t3.release_place,t4.nick_name,t4.head_portrait"						);
		sql.append(" from t_zl_user_person t1                                                                                           ");
		sql.append(" inner join t_zl_user_relation t2                                                                                   ");
		sql.append(" on t1.objectid = t2.promoter                                                                                       ");
		sql.append(" inner join t_zl_blog t3                                                                                            ");
		sql.append(" on t2.recipient = t3.userid                                                                                        ");
		sql.append(" inner join t_zl_user_person t4                                                                                     ");
		sql.append(" on t2.recipient = t4.objectid                                                                                      ");
		sql.append(" where t1.objectid = ? and t3.delete_staues = '1' and t3.is_open = '0'             ");
		sql.append(" union                                                                                                              ");
		sql.append(" select t5.objectid user_id,t6.objectid,t6.content,t6.release_time,t6.release_place,t5.nick_name,t5.head_portrait                                   ");
		sql.append(" from t_zl_user_person t5                                                                                           ");
		sql.append(" inner join t_zl_blog t6                                                                                            ");
		sql.append(" on t5.objectid = t6.userid                                                                                         ");
		sql.append(" where t5.objectid = ? and t6.delete_staues = '1' and t6.is_open = '0' ) t7        ");
		sql.append(" order by t7.release_time desc                                                                                      ");
		
		return hibernateUtil.findSqlPage(page, sql.toString(),
				LwBlogListDto.class,currentUserId,currentUserId);
	}
	
	/**
	 * 	删除我的邻文
	 *  
	 *  @param lwBlogId 我的邻文ID
	 *  @return
	 *  @author xiongwu@iflytek.com
	 *  @created 2016年1月30日 下午2:13:37
	 *  @lastModified       
	 *  @history
	 */
	public int deleteLwBlog(String lwBlogId) {
		StringBuffer sql = new StringBuffer();
		sql.append("update TZlBlog set deleteStaues=:deleteStaues where objectid=:objectid");
		return createQuery(sql.toString()).setParameter("deleteStaues", SysCode.IS_FLAG)
				.setParameter("objectid", lwBlogId).executeUpdate();
	
	}
	
	/**
	 * 	根据邻文ID统计邻文被转发数量
	 *  
	 *  @param lwBlogId 邻文ID
	 *  @return
	 *  @author xiongwu@iflytek.com
	 *  @created 2016年1月23日 下午5:08:41
	 *  @lastModified       
	 *  @history
	 */
	public int queryLwforwardSum(String lwBlogId) {
		
		StringBuffer sql = new StringBuffer();
		
		sql.append(" select count(1) from t_zl_blog t               ");
		sql.append(" where 1=1        ");
		
		//查询条件：原邻文ID
		sql.append(HqlMaker.popuHqlEq("t.before_blogid", lwBlogId));
		//未删除状态
		sql.append(HqlMaker.popuHqlEq("t.delete_staues", SysCode.NO_FLAG));
		//公开状态
		sql.append(HqlMaker.popuHqlEq("t.is_open", SysCode.IS_FLAG));
		
		return (int) super.countSqlResult(sql.toString());
	}
	
	/**
	 * 	查询最新的10条邻文数据
	 *  
	 *  @return
	 *  @author xiongwu@iflytek.com
	 *  @created 2016年1月25日 下午2:04:55
	 *  @lastModified       
	 *  @history
	 */
	public List<LwBlogDto> queryNewLwBlogList() {
		
		StringBuffer sql = new StringBuffer();
		
		sql.append(" select * from (select t.objectid,t.content,t.release_time from t_zl_blog t        ");
		sql.append(" where 1=1            ");
		
		//未删除状态
		sql.append(HqlMaker.popuHqlEq("t.delete_staues", SysCode.NO_FLAG));
		//公开状态
		sql.append(HqlMaker.popuHqlEq("t.is_open", SysCode.IS_FLAG));
		
		sql.append(" order by t.release_time desc) where rownum <= 10        ");
		
		return hibernateUtil.findSqlList(sql.toString(),
				LwBlogDto.class);
	}
	

}




