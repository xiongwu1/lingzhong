/**	
 * <br>
 * Copyright 2016 IFlyTek. All rights reserved.<br>
 * <br>			 
 * Package: com.xiongwu.lingzhong.service.impl <br>
 * FileName: FeedBackServiceImpl.java <br>
 * <br>
 * @version
 * @author xiongwu
 * @created 2016年5月4日
 * @last Modified 
 * @history
 */

package com.xiongwu.lingzhong.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.xiongwu.lingzhong.base.Message;
import com.xiongwu.lingzhong.base.SysCode;
import com.xiongwu.lingzhong.domain.TZlSuggest;
import com.xiongwu.lingzhong.domain.TZlUserPerson;
import com.xiongwu.lingzhong.persistence.FeedBackDao;
import com.xiongwu.lingzhong.service.IFeedBackService;
import com.xiongwu.utils.DateUtils;
import com.xiongwu.utils.ResultUtil;
import com.xiongwu.utils.dto.ResultDto;

/**
 * 	意见反馈实现类
 *  
 *  @author xiongwu
 *  @created 2016年5月4日 下午8:00:14
 *  @lastModified       
 *  @history           
 */
public class FeedBackServiceImpl implements IFeedBackService{
	
	/**
	 * 意见反馈Dao
	 */
	@Autowired
	private FeedBackDao feedBackDao;

	@Override
	public ResultDto saveFeedBack(String feedBackContent, String feedBackTel, TZlUserPerson currentUser) {
		
		TZlSuggest zlSuggest = new TZlSuggest();
		
		zlSuggest.setSuggestContent(feedBackContent);
		zlSuggest.setMobilePhone(feedBackTel);
		zlSuggest.setSuggestTime(DateUtils.getCurrentGaDate());
		zlSuggest.setSuggestStatus(SysCode.NO_FLAG);
		if(currentUser != null) {
			zlSuggest.setUserid(currentUser.getObjectid());
		}
		feedBackDao.saveOrUpdate(zlSuggest);
		return ResultUtil.success(Message.SUCCESS);
	}

}




