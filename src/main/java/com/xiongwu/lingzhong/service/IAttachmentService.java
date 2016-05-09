/**	
 * <br>
 * Copyright 2015 IFlyTek. All rights reserved.<br>
 * <br>			 
 * Package: com.xiongwu.lingzhong.service <br>
 * FileName: IAttachmentService.java <br>
 * <br>
 * @version
 * @author xiongwu@iflytek.com
 * @created 2016年1月15日
 * @last Modified 
 * @history
 */

package com.xiongwu.lingzhong.service;

import java.io.File;
import java.util.Map;

import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * 	上传图片附件接口
 *  
 *  @author xiongwu@iflytek.com
 *  @created 2016年1月15日 下午3:39:15
 *  @lastModified       
 *  @history           
 */

public interface IAttachmentService {
	
	/**
	 * 	多附件（图片）上传
	 *  
	 *  @param multipartRequest
	 *  @return
	 *  @author xiongwu@iflytek.com
	 *  @created 2016年1月15日 下午3:42:46
	 *  @lastModified       
	 *  @history
	 */
	public Map<String, Object> uploadImg(MultipartHttpServletRequest multipartRequest,String userId);

	/**
	 * 	上传头像
	 *  
	 *  @param file 文件
	 *  @return
	 *  @author xiongwu@iflytek.com
	 *  @created 2016年2月23日 下午3:40:43
	 *  @lastModified       
	 *  @history
	 */
	public String uploadHead(File file);
}




