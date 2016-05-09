/**	
 * <br>
 * Copyright 2015 IFlyTek. All rights reserved.<br>
 * <br>			 
 * Package: com.xiongwu.lingzhong.persistence <br>
 * FileName: ZlUserRelationDao.java <br>
 * <br>
 * @version
 * @author xiongwu@iflytek.com
 * @created 2016年1月26日
 * @last Modified 
 * @history
 */

package com.xiongwu.lingzhong.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.iflytek.iframework.orm.hibernate.HibernateEntityDao;
import com.iflytek.iframework.utils.HqlMaker;
import com.xiongwu.lingzhong.base.SysCode;
import com.xiongwu.lingzhong.domain.TZlUserRelation;
import com.xiongwu.lingzhong.domain.dto.LoginUserDto;
import com.xiongwu.lingzhong.domain.dto.LwBlogListDto;
import com.xiongwu.utils.HibernateUtil;

/**
 * 	众邻-用户关系Dao
 *  
 *  @author xiongwu@iflytek.com
 *  @created 2016年1月26日 上午10:13:06
 *  @lastModified       
 *  @history           
 */

public class ZlUserRelationDao extends HibernateEntityDao<TZlUserRelation>{
	
	/**
	 * hibernate查询工具
	 */
	@Autowired
	public HibernateUtil<LwBlogListDto> hibernateUtil;
	
	
	/**
	 * 	获取最新登陆的TOP10用户
	 *  
	 *  @return
	 *  @author xiongwu@iflytek.com
	 *  @created 2016年1月25日 下午3:56:54
	 *  @lastModified       
	 *  @history
	 */
	public List<LoginUserDto> queryTopTenZlUser() {
		
		StringBuffer sql = new StringBuffer();
		
		sql.append(" select * from (select t.objectid,t.nick_name,t.last_login_time from t_zl_user_person t        ");
		sql.append(" where 1=1          ");
		
		//注册用户：非管理员账号
		sql.append(HqlMaker.popuHqlEq("t.user_type", SysCode.NO_FLAG));
		//用户未锁定
		sql.append(HqlMaker.popuHqlEq("t.is_lock", SysCode.NO_FLAG));
		
		sql.append(" and t.last_login_time is not null");
		sql.append(" order by t.last_login_time desc ) where rownum <= 10    ");
		
		return hibernateUtil.findSqlList(sql.toString(),
				LoginUserDto.class);
	}
	
	/**
	 * 	查询该用户是否被关注
	 *  
	 *  @param currentUserId 当前用户ID
	 *  @param attentUserId 被关注者ID
	 *  @return
	 *  @author xiongwu@iflytek.com
	 *  @created 2016年1月26日 下午2:31:42
	 *  @lastModified       
	 *  @history
	 */
	public TZlUserRelation queryIsAttention(String currentUserId,String attentUserId) {
		
		StringBuffer sql = new StringBuffer();
		
		sql.append("from TZlUserRelation where promoter=? and recipient=?");
		
		@SuppressWarnings("unchecked")
		List<TZlUserRelation> list = this.createQuery(sql.toString(),currentUserId,attentUserId).list();
        if(list.size()>0){
        	return list.get(0);
        }else{
        	return null;
        }
	}
	
	/**
	 * 	取消关注操作
	 *  
	 *  @param currentUserId 当前用户ID
	 *  @param attentUserId  被关注用户ID
	 *  @author xiongwu@iflytek.com
	 *  @created 2016年1月27日 下午12:41:59
	 *  @lastModified       
	 *  @history
	 */
	public void cancelAttention(String currentUserId,String attentUserId) {
		StringBuffer sql = new StringBuffer();
		sql.append("delete from TZlUserRelation where promoter=? and recipient=?");
		super.createQuery(sql.toString(), currentUserId,attentUserId).executeUpdate();
	}
	
	/**
	 * 	统计我所关注的人数
	 * 
	 *  @param currentUserId 当前用户ID
	 *  @return
	 *  @author xiongwu@iflytek.com
	 *  @created 2016年1月29日 上午9:29:34
	 *  @lastModified       
	 *  @history
	 */
	public String queryCountAttention(String currentUserId) {
		
		StringBuffer sql = new StringBuffer();
		
		sql.append(" select to_char(count(1)) from t_zl_user_relation t                ");
		sql.append(" where 1=1      ");
		
		//查询条件：当前用户
		sql.append(HqlMaker.popuHqlEq("t.promoter", currentUserId));
		return hibernateUtil.findSqlUnique(sql.toString());
	}
	
	/**
	 * 	统计我的粉丝数
	 *  
	 *  @param currentUserId 当前用户ID
	 *  @return
	 *  @author xiongwu@iflytek.com
	 *  @created 2016年1月29日 上午11:24:20
	 *  @lastModified       
	 *  @history
	 */
	public String queryCountFans(String currentUserId) {
		
		StringBuffer sql = new StringBuffer();
		
		sql.append(" select to_char(count(1)) from t_zl_user_relation t                ");
		sql.append(" where 1=1      ");
		
		//查询条件：当前用户
		sql.append(HqlMaker.popuHqlEq("t.recipient", currentUserId));
		return hibernateUtil.findSqlUnique(sql.toString());
		
	}
	
	/**
	 * 	统计我的邻文数
	 *  
	 *  @param currentUserId 当前用户ID
	 *  @return
	 *  @author xiongwu@iflytek.com
	 *  @created 2016年1月29日 下午1:12:06
	 *  @lastModified       
	 *  @history
	 */
	public String queryCountLwBlog(String currentUserId) {
		StringBuffer sql = new StringBuffer();
		
		sql.append(" select to_char(count(1)) from t_zl_blog t                ");
		sql.append(" where 1=1      ");
		
		//查询条件：当前用户
		sql.append(HqlMaker.popuHqlEq("t.userid", currentUserId));
		//邻文未被删除
		sql.append(HqlMaker.popuHqlEq("t.DELETE_STAUES", SysCode.NO_FLAG));
		return hibernateUtil.findSqlUnique(sql.toString());
	}

}




