package com.xiongwu.lingzhong.web;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iflytek.iframework.business.cache.impl.PublicZdCacheLoadImpl;
import com.iflytek.iframework.business.cache.vo.PublicDict;
import com.iflytek.iframework.utils.WebUtils;
import com.xiongwu.lingzhong.base.CommboboxBean;

/**
 * 	通用业务逻辑处理
 *  
 *  @author xiongwu@iflytek.com
 *  @created 2015年12月4日 下午4:05:27
 *  @lastModified       
 *  @history
 */
@Controller
public class CommonController {
	
	/**
	 * 	组合框字典列表加载 返回 [{text:"xx",value:"xx"}]格式列表
	 *  
	 *  @param lxjp 类型简拼
	 *  @param response 服务端响应
	 *  @author xiongwu@iflytek.com
	 *  @created 2015年12月4日 下午4:05:41
	 *  @lastModified       
	 *  @history
	 */
    @RequestMapping("/common/commboDict.do")
    public void getCommboboxDict(String lxjp,HttpServletResponse response){
        List<PublicDict> list = PublicZdCacheLoadImpl.getListByLxjp(lxjp);
        List<CommboboxBean> commboboxBeans = new ArrayList<CommboboxBean>();
        for (PublicDict dict:list){
            commboboxBeans.add(new CommboboxBean(dict.getMc(),dict.getDm()));
        }
        WebUtils.sendDirectToClient(response,WebUtils.CONTENTTYPE_TEXTJSON,WebUtils.CONTENT_CHARSET_UTF8,JSONArray.fromObject(commboboxBeans).toString());
    }
    
    /**
     * 	获取list<map>字典
     *  
     *  @param lxjp 类型简拼
     *  @param dm 代码
     *  @param response void
     *  @author xiongwu@iflytek.com
     *  @created 2015年12月4日 下午4:06:00
     *  @lastModified       
     *  @history
     */
     @RequestMapping("/common/dict.do")
     public void getDictionary(String lxjp,String dm,HttpServletResponse response){
         if (StringUtils.isBlank(dm)){
             List<PublicDict> list = PublicZdCacheLoadImpl.getListByLxjp(lxjp);
             Map<String,String> map=new HashMap<String, String>();
             for (PublicDict dict:list){
                 map.put(dict.getDm(),dict.getMc());
             }
             WebUtils.sendDirectToClient(response,WebUtils.CONTENTTYPE_TEXTJSON,WebUtils.CONTENT_CHARSET_UTF8,JSONObject.fromObject(map).toString());
         }else {
             PublicDict dict = PublicZdCacheLoadImpl.getDict(lxjp,dm);
             WebUtils.sendDirectToClient(response,WebUtils.CONTENTTYPE_TEXTJSON,WebUtils.CONTENT_CHARSET_UTF8,JSONObject.fromObject(dict).toString());
         }
     }
    
}