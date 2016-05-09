/**	
 * <br>
 * Copyright 2015 IFlyTek. All rights reserved.<br>
 * <br>			 
 * Package: com.xiongwu.lingzhong.persistence <br>
 * FileName: ZlImageDao.java <br>
 * <br>
 * @version
 * @author xiongwu@iflytek.com
 * @created 2016年1月22日
 * @last Modified 
 * @history
 */

package com.xiongwu.lingzhong.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.iflytek.iframework.orm.hibernate.HibernateEntityDao;
import com.iflytek.iframework.utils.HqlMaker;
import com.xiongwu.lingzhong.base.SysCode;
import com.xiongwu.lingzhong.domain.dto.LwBlogListDto;
import com.xiongwu.lingzhong.domain.dto.LwImageListDto;
import com.xiongwu.utils.HibernateUtil;

/**
 * 	邻文图片Dao
 *  
 *  @author xiongwu@iflytek.com
 *  @created 2016年1月22日 下午1:55:07
 *  @lastModified       
 *  @history           
 */

public class ZlImageDao extends HibernateEntityDao<LwImageListDto>{
	
	/**
	 * hibernate查询工具
	 */
	@Autowired
	public HibernateUtil<LwBlogListDto> hibernateUtil;
	
	/**
	 * 	根据邻文ID查出图片列表
	 *  
	 *  @param lwBlogId
	 *  @return
	 *  @author xiongwu@iflytek.com
	 *  @created 2016年1月22日 下午2:11:33
	 *  @lastModified       
	 *  @history
	 */
	public List<LwImageListDto> queryLwImagesByLwBlogId(String lwBlogId) {
		
		StringBuffer sql = new StringBuffer();

		sql.append(" select t1.blogid,t1.image_name,t1.image_url            ");
		sql.append(" from t_zl_image t1  where 1=1                          ");
		//查询条件：邻文ID
		sql.append(HqlMaker.popuHqlEq("t1.blogid", lwBlogId));
		//未删除状态
		sql.append(HqlMaker.popuHqlEq("t1.delete_staues", SysCode.NO_FLAG));
		sql.append("order by t1.UPLOAD_TIME desc");
		
		return hibernateUtil.findSqlList(sql.toString(),
				LwImageListDto.class);
		
	
	}

}




