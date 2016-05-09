/**	
 * <br>
 * Copyright 2015 IFlyTek. All rights reserved.<br>
 * <br>			 
 * Package: com.xiongwu.utils <br>
 * FileName: StringUtils.java <br>
 * <br>
 * @version
 * @author xiongwu@iflytek.com
 * @created 2015-12-10
 * @last Modified 
 * @history
 */
package com.xiongwu.utils;

import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

/**
 * 	字符处理类
 *  
 *  @author xiongwu@iflytek.com
 *  @created 2015年12月10日 下午2:33:56
 *  @lastModified       
 *  @history
 */
public class StringUtil extends StringUtils{

	/**
	 * 	替换非法字符
	 *  
	 *  @param str 字符串
	 *  @return
	 *  @author xiongwu@iflytek.com
	 *  @created 2015年12月10日 下午2:35:21
	 *  @lastModified       
	 *  @history
	 */
    public static String replace(String str) {
        if (StringUtils.isNotEmpty(str)) {
            /*
             * str = str.replace("'", "''").replace("]", "]]").replace("&",
             * "chr(38)").replace("%", "chr(37)").replace("\\", "chr(92)")
             * .replace("\"", "chr(34)").replace("_", "chr(95)");
             */
            str = str.replace("'", "''").replace("%", "\\%")
                    .replace("\\", "\\\\").replace("_", "\\_");
        }
        return str;
    }
    
    /**
	 *  注：
	 *  \n 回车(\u000a) 
    	\t 水平制表符(\u0009) 
    	\s 空格(\u0008) 
    	\r 换行(\u000d)
	 * @param str
	 * @return
	 */
	public static String replaceBlank(String str) {
        String dest = "";
        if (str!=null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }
    
	/**
	 * 	去掉尾部全部特定字符串
	 *  
	 *  @param str
	 *  @param removeStr
	 *  @return
	 *  @author xiongwu@iflytek.com
	 *  @created 2015年12月10日 下午2:35:47
	 *  @lastModified       
	 *  @history
	 */
    public static String removeEndStr(String str,String removeStr){
        String str2 = StringUtils.removeEnd(str, removeStr);
        while(!str2.equals(str)){
            str = str2;
            str2 = StringUtils.removeEnd(str, removeStr);
        }
        return str2;
    }
    
    /**
     * 	去零
     *  
     *  @param  code 原编码
     *  @param  length “0”的长度
     *  @return 去零后的编码
     *  @author xiongwu@iflytek.com
     *  @created 2015年12月10日 下午2:37:10
     *  @lastModified       
     *  @history
     */
    public static String toNewsCode(String code, int length) {
        if (StringUtils.isNotEmpty(code)) {
            boolean temp = false;
            code = code.replace("\r", "");
            code = code.replace("\n", "");
            String template = String.format("%0" + length + "d", 0);
            while(!temp){
                if (code.length() > length) {
                    String newstr = code.substring(code.length() - length);
                    if (template.equals(newstr))
                        code = code.substring(0, code.length() - length);
                    else
                        temp = true;
                }else{
                    temp = true;
                }
            }
        }
        return code;
    }
    
    /**
     * 	根绝关键词数组和需要查询表的列名数组拼接查询的sql条件
     *  
     *  @param value 存放参数的map
     *  @param searchKeys 关键词数组
     *  @param columNames 列名数组
     *  @return 查询条件的sql语句
     *  @author xiongwu@iflytek.com
     *  @created 2015年12月10日 下午2:37:53
     *  @lastModified       
     *  @history
     */
    public static String makeSearchSql(Map<String,Object> value,String[] searchKeys,String[] columNames){
    	if(searchKeys==null||columNames==null){
    		return "";
    	}
    	StringBuffer sb = new StringBuffer(100);
    	for(int index=0;index<searchKeys.length;index++){
    		if(isBlank(searchKeys[index])){
    			continue;
    		}
    		sb.append(" and (");
    		for(String col:columNames){
    			sb.append(col).append(" like :key").append(index).append(" or ");
    		}
    		//去除最后一个“or”，如果有的话
    		int last=sb.lastIndexOf("or");
    		if(last>0){
    			sb.delete(last, last+2);
    		}
    		sb.append(")");
    		value.put("key"+index, "%"+searchKeys[index]+"%");
    	}
    	return sb.toString();
    }
    
    /**
     * 	获得制定位数的随机整数
     *  
     *  @param lo
     *  @return
     *  @author xiongwu@iflytek.com
     *  @created 2015年12月10日 下午2:38:35
     *  @lastModified       
     *  @history
     */
	public static String getRandNum(int lo) {
		int lo_ = lo;
		if (lo_ < 1) {
			lo_ = 4;
		}
		StringBuffer temp = new StringBuffer();
		Random rand = new Random();
		for (int i = 0; i < lo; ++i) {
			temp.append(String.valueOf(rand.nextInt(10)));
		}
		return temp.toString();
	}
    
}
