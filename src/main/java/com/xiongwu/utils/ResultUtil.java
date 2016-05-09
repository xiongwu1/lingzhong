/**	
 * <br>
 * Copyright 2013 IFlyTek. All rights reserved.<br>
 * <br>			 
 * Package: com.iflytek.utils <br>
 * FileName: ResultUtil.java <br>
 * <br>
 * @version
 * @author hyzha@iflytek.com
 * @created 2013-3-21
 * @last Modified 
 * @history
 */

package com.xiongwu.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.iflytek.iframework.orm.Page;
import com.iflytek.iframework.utils.WebUtils;
import com.xiongwu.utils.dto.ResultDto;

/**
 * 	结果构造工具
 *  
 *  @author xiongwu@iflytek.com
 *  @created 2015年12月9日 下午1:20:12
 *  @lastModified       
 *  @history
 */
public class ResultUtil {

	/**
	 * 成功
	 */
	public static final String TRUE = "true";

	/**
	 * 失败
	 */
	public static final String FALSE = "false";

	/**
	 * 	封装成功消息
	 *  
	 *  @param result 消息
	 *  @return
	 *  @author xiongwu@iflytek.com
	 *  @created 2015年12月9日 下午1:20:29
	 *  @lastModified       
	 *  @history
	 */
	public static ResultDto success(String result) {
		ResultDto dto = new ResultDto();
		dto.setFlag(TRUE);
		dto.setResult(result);
		return dto;
	}

	/**
	 * 	封装失败消息
	 *  
	 *  @param result 消息
	 *  @return
	 *  @author xiongwu@iflytek.com
	 *  @created 2015年12月9日 下午1:20:56
	 *  @lastModified       
	 *  @history
	 */
	public static ResultDto fail(String result) {
		ResultDto dto = new ResultDto();
		dto.setFlag(FALSE);
		dto.setResult(result);
		return dto;
	}
	
	/**
	 * 	封装成功消息
	 *  
	 *  @param result 消息结果
	 *  @param data 需要返回的数据
	 *  @return 结果对象
	 *  @author xiongwu@iflytek.com
	 *  @created 2015年12月9日 下午1:21:17
	 *  @lastModified       
	 *  @history
	 */
	public static ResultDto success(String result,Object data) {
		return new ResultDto(TRUE,result,data);
	}
	
	/**
	 * 	封装失败消息
	 *  
	 *  @param result 消息结果
	 *  @param data 需要返回的数据
	 *  @return 结果对象
	 *  @author xiongwu@iflytek.com
	 *  @created 2015年12月9日 下午1:21:42
	 *  @lastModified       
	 *  @history
	 */
	public static ResultDto fail(String result,Object data) {
		return new ResultDto(FALSE,result,data);
	}

	/**
	 * 	返回json格式
	 *  
	 *  @param flag 返回结果状态
	 *  @param result 结果
	 *  @return
	 *  @author xiongwu@iflytek.com
	 *  @created 2015年12月9日 下午1:22:04
	 *  @lastModified       
	 *  @history
	 */
	private static String jsonResult(String flag, String result) {
		return "{\"returnFlag\":" + flag + ",\"data\":\"" + result + "\"}";
	}

	/**
	 * 	返回json格式
	 *  
	 *  @param result
	 *  @return
	 *  @author xiongwu@iflytek.com
	 *  @created 2015年12月9日 下午1:22:27
	 *  @lastModified       
	 *  @history
	 */
	private static String jsonResult(ResultDto result) {
		return "{\"returnFlag\":" + result.getFlag() + ",\"data\":\""
				+ result.getResult() + "\",\"returnData\":\"" + result.getData() + "\"}";
	}

	/**
	 * 	构造空page
	 * 
	 *  @param <T>  模板
	 *  @param page 分页实体
	 *  @return 构造后page
	 *  @author xiongwu@iflytek.com
	 *  @created 2015年12月9日 下午1:22:44
	 *  @lastModified       
	 *  @history
	 */
	public static <T> Page<T> emptyPage(Page<T> page) {
		page.setResult(new ArrayList<T>(0));
		page.setTotalCount(0l);
		return page;
	}

	/**
	 * 	回复结果到页面ajax请求
	 *  
	 *  @param response 回执消息
	 *  @param flag 标识
	 *  @param result 结果
	 *  @author xiongwu@iflytek.com
	 *  @created 2015年12月9日 下午1:23:24
	 *  @lastModified       
	 *  @history
	 */
	public static void sendResult(HttpServletResponse response, String flag,
			String result) {
		WebUtils.sendDirectToClient(response, WebUtils.CONTENTTYPE_TEXTHTML,
				WebUtils.CONTENT_CHARSET_UTF8, jsonResult(flag, result));
	}

	/**
	 * 	回复结果到页面ajax请求
	 *  
	 *  @param response
	 *  @param result
	 *  @author xiongwu@iflytek.com
	 *  @created 2015年12月9日 下午1:23:58
	 *  @lastModified       
	 *  @history
	 */
	public static void sendResult(HttpServletResponse response, ResultDto result) {
		WebUtils.sendDirectToClient(response, WebUtils.CONTENTTYPE_TEXTHTML,
				WebUtils.CONTENT_CHARSET_UTF8, jsonResult(result));
	}

	/**
	 * 	回复结果到页面ajax请求
	 *  
	 *  @param response 回执消息
	 *  @param result 结果
	 *  @author xiongwu@iflytek.com
	 *  @created 2015年12月9日 下午1:24:13
	 *  @lastModified       
	 *  @history
	 */
	public static void sendString(HttpServletResponse response, String result) {
		WebUtils.sendDirectToClient(response, WebUtils.CONTENTTYPE_TEXTHTML,
				WebUtils.CONTENT_CHARSET_UTF8, result);
	}

	/**
	 * 	回复消息到页面ajax请求
	 *  
	 *  @param response 回执对象
	 *  @param flag 标识
	 *  @param msg 消息
	 *  @author xiongwu@iflytek.com
	 *  @created 2015年12月9日 下午1:24:35
	 *  @lastModified       
	 *  @history
	 */
	public static void sendMsg(HttpServletResponse response, String flag,
			String msg) {
		WebUtils.sendDirectToClient(response, WebUtils.CONTENTTYPE_TEXTJSON,
				WebUtils.CONTENT_CHARSET_UTF8, jsonResult(flag, msg));
	}

	/**
	 * 	回复消息到页面ajax请求
	 *  
	 *  @param response
	 *  @param dto
	 *  @author xiongwu@iflytek.com
	 *  @created 2015年12月9日 下午1:25:16
	 *  @lastModified       
	 *  @history
	 */
	public static void sendMsg(HttpServletResponse response, ResultDto dto) {
		WebUtils.sendDirectToClient(response, WebUtils.CONTENTTYPE_TEXTJSON,
				WebUtils.CONTENT_CHARSET_UTF8, jsonResult(dto));
	}

	/**
	 * 	回复列表
	 *  
	 *  @param response 回执对象
	 *  @param list 列表
	 *  @author xiongwu@iflytek.com
	 *  @created 2015年12月9日 下午1:25:29
	 *  @lastModified       
	 *  @history
	 */
	public static void sendList(HttpServletResponse response, List<?> list) {
		WebUtils.sendDirectToClient(response, WebUtils.CONTENTTYPE_TEXTJSON,
				WebUtils.CONTENT_CHARSET_UTF8, JSONArray.fromObject(list)
						.toString());
	}

	/**
	 * 	回复对象
	 *  
	 *  @param response  回执对象
	 *  @param obj 对象
	 *  @author xiongwu@iflytek.com
	 *  @created 2015年12月9日 下午1:25:51
	 *  @lastModified       
	 *  @history
	 */
	public static void sendObject(HttpServletResponse response, Object obj) {
		WebUtils.sendDirectToClient(response, WebUtils.CONTENTTYPE_TEXTJSON,
				WebUtils.CONTENT_CHARSET_UTF8, JSONObject.fromObject(obj)
						.toString());
	}

	/**
	 * 	回复对象
	 *  
	 *  @param response 回执对象
	 *  @param obj 对象
	 *  @param ignore 忽略的属性集合
	 *  @author xiongwu@iflytek.com
	 *  @created 2015年12月9日 下午1:26:10
	 *  @lastModified       
	 *  @history
	 */
	public static void sendObject(HttpServletResponse response, Object obj,
			String... ignore) {
		JsonConfig config = new JsonConfig();
		config.setExcludes(ignore);
		WebUtils.sendDirectToClient(response, WebUtils.CONTENTTYPE_TEXTJSON,
				WebUtils.CONTENT_CHARSET_UTF8,
				JSONObject.fromObject(obj, config).toString());
	}

	/**
	 * 	回复对象
	 *  
	 *  @param response 回执对象
	 *  @param obj 对象
	 *  @author xiongwu@iflytek.com
	 *  @created 2015年12月9日 下午1:26:36
	 *  @lastModified       
	 *  @history
	 */
	public static void sendObjectText(HttpServletResponse response, Object obj) {
		WebUtils.sendDirectToClient(response, WebUtils.CONTENTTYPE_TEXTHTML,
				WebUtils.CONTENT_CHARSET_UTF8, JSONObject.fromObject(obj)
						.toString());
	}

	/**
	 * 	回复分页
	 *  
	 *  @param response 回执对象
	 *  @param page 分页对象
	 *  @author xiongwu@iflytek.com
	 *  @created 2015年12月9日 下午1:26:57
	 *  @lastModified       
	 *  @history
	 */
	public static void sendPage(HttpServletResponse response, Page<?> page) {
		String pageJson = (new StringBuilder("{\"total\":"))
				.append(page.getTotalCount()).append(",\"rows\":")
				.append(JSONArray.fromObject(page.getResult())).append("}")
				.toString();
		WebUtils.sendDirectToClient(response, WebUtils.CONTENTTYPE_TEXTJSON,
				WebUtils.CONTENT_CHARSET_UTF8, pageJson);
	}

	/**
	 * 	回复分页
	 *  
	 *  @param response 回执对象
	 *  @param page 分页对象
	 *  @author xiongwu@iflytek.com
	 *  @created 2015年12月9日 下午1:27:19
	 *  @lastModified       
	 *  @history
	 */
	public static void sendHTMLPage(HttpServletResponse response, Page<?> page) {
		WebUtils.sendDirectToClient(response, WebUtils.CONTENTTYPE_TEXTHTML,
				WebUtils.CONTENT_CHARSET_UTF8, page.getJartJsonResult());
	}

	/**
	 * 	回复MAP
	 *  
	 *  @param response
	 *  @param map
	 *  @author xiongwu@iflytek.com
	 *  @created 2015年12月9日 下午1:27:44
	 *  @lastModified       
	 *  @history
	 */
	public static void sendMap(HttpServletResponse response, Map<?,?> map) {
		WebUtils.sendDirectToClient(response, WebUtils.CONTENTTYPE_TEXTJSON,
				WebUtils.CONTENT_CHARSET_UTF8, JSONObject.fromObject(map)
						.toString());
	}

}
