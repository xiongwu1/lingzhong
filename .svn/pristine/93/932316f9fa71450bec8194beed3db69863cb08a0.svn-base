/**	
 * <br>
 * Copyright 2015 IFlyTek. All rights reserved.<br>
 * <br>			 
 * Package: com.xiongwu.lingzhong.persistence <br>
 * FileName: AttachmentDao.java <br>
 * <br>
 * @version
 * @author xiongwu@iflytek.com
 * @created 2016年1月16日
 * @last Modified 
 * @history
 */

package com.xiongwu.lingzhong.persistence;

import com.iflytek.iframework.orm.hibernate.HibernateEntityDao;
import com.xiongwu.lingzhong.domain.TZlImage;

/**
 * 	图片附件管理Dao
 *  
 *  @author xiongwu@iflytek.com
 *  @created 2016年1月16日 上午10:41:22
 *  @lastModified       
 *  @history           
 */

public class AttachmentDao extends HibernateEntityDao<TZlImage>{
	
	
	/**
	 * 	根据图片ID获取图片的信息
	 *  
	 *  @param imgId 图片ID
	 *  @return
	 *  @author xiongwu@iflytek.com
	 *  @created 2016年1月16日 下午3:58:39
	 *  @lastModified       
	 *  @history
	 */
	public TZlImage queryImgByImgId(String imgId) {
		
		StringBuilder hql = new StringBuilder(" from TZlImage where objectid=?");
        return (TZlImage) this.createQuery(hql.toString(),imgId).list().get(0);
		
	}

}




