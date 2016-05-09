/**	
 * <br>
 * Copyright 2016 IFlyTek. All rights reserved.<br>
 * <br>			 
 * Package: com.xiongwu.lingzhong.service <br>
 * FileName: IFeedBackService.java <br>
 * <br>
 * @version
 * @author xiongwu
 * @created 2016年5月4日
 * @last Modified 
 * @history
 */

package com.xiongwu.lingzhong.service;

import com.xiongwu.lingzhong.domain.TZlUserPerson;
import com.xiongwu.utils.dto.ResultDto;

/**
 *  意见反馈接口
 *  
 *  @author xiongwu
 *  @created 2016年5月4日 下午7:59:30
 *  @lastModified       
 *  @history           
 */

public interface IFeedBackService {
	
	/**
	 *  保存意见反馈内容
	 *  
	 *  @param zlSuggest 意见反馈
	 *  @param currentUser 当前用户
	 *  @return
	 *  @author xiongwu
	 *  @created 2016年5月4日 下午8:02:14
	 *  @lastModified       
	 *  @history
	 */
	public ResultDto saveFeedBack(String feedBackContent, String feedBackTel, TZlUserPerson currentUser);
}




