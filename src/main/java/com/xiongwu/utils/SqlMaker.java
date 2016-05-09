/**	
 * <br>
 * Copyright 2011 IFlyTek. All rights reserved.<br>
 * <br>			 
 * Package: com.iflytek.uaac.base.utils <br>
 * FileName: SqlMaker.java <br>
 * <br>
 * @version
 * @author ycli7
 * @created 2014年9月4日
 * @last Modified 
 * @history
 */

package com.xiongwu.utils;

import java.util.Map;

/**
 * 	SQL构造工具
 *  
 *  @author xiongwu@iflytek.com
 *  @created 2015年12月16日 下午5:11:25
 *  @lastModified       
 *  @history
 */
public class SqlMaker{

	/*** 分隔符号--百分号 ***/
	private static final String SPLIT_FLAG_BFH = "%";
	
	/**
	 *  sql方式的模糊查询
	 *  @param value 存放参数的map
	 *  @param column 表列名
	 *  @param paramValue 对应的值
	 *  @return 拼接好的sql语句
	 *  @author xiongwu@iflytek.com
	 *  @created 2015年12月16日 下午5:11:40
	 *  @lastModified       
	 *  @history           
	 */
	public static String popuSqlLike(Map<String, Object> value, final String column,final String paramValue) {
		if (StringUtil.isNotBlank(paramValue)) {
			StringBuilder sql = new StringBuilder(200);
			sql.append(" and ").append(column).append(" like :")
			.append(column);
			value.put(column,SPLIT_FLAG_BFH + paramValue.trim() + SPLIT_FLAG_BFH);
			return sql.toString();
		}else{
			return "";
		}
	}
	
	/**
	 *  sql方式的等值查询
	 *  @param value 存放参数的map
	 *  @param column 表列名
	 *  @param paramValue 对应的值
	 *  @return 拼接好的sql语句
	 *  @author xiongwu@iflytek.com
	 *  @created 2015年12月16日 下午5:12:00
	 *  @lastModified       
	 *  @history           
	 */
	public static String popuSqlEq(Map<String, Object> value, final String column,final String paramValue) {
		if (StringUtil.isNotBlank(paramValue)) {
			StringBuilder sql = new StringBuilder(200);
			sql.append(" and ").append(column).append("=:")
					.append(column);
			value.put(column,paramValue.trim());
			return sql.toString();
		}else{
			return "";
		}
	}
}




