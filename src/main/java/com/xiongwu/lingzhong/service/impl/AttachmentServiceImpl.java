/**	
 * <br>
 * Copyright 2015 IFlyTek. All rights reserved.<br>
 * <br>			 
 * Package: com.xiongwu.lingzhong.service.impl <br>
 * FileName: AttachmentServiceImpl.java <br>
 * <br>
 * @version
 * @author xiongwu@iflytek.com
 * @created 2016年1月15日
 * @last Modified 
 * @history
 */

package com.xiongwu.lingzhong.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.iflytek.thirdparty.fastdfs.IFastDFSComponent;
import com.xiongwu.lingzhong.base.SysCode;
import com.xiongwu.lingzhong.domain.TZlImage;
import com.xiongwu.lingzhong.persistence.AttachmentDao;
import com.xiongwu.lingzhong.service.IAttachmentService;
import com.xiongwu.utils.DateUtils;

/**
 * 	上传图片附件接口实现类
 *  
 *  @author xiongwu@iflytek.com
 *  @created 2016年1月15日 下午3:43:36
 *  @lastModified       
 *  @history           
 */

public class AttachmentServiceImpl implements IAttachmentService {
	
	/**
     * fastDfs上传类
     */
    @Autowired
    private IFastDFSComponent fastDFSFileStoreComponent;
    
    /**
     * 图片附件管理Dao
     */
    @Autowired
    private AttachmentDao attachmentDao;

	@Override
	@SuppressWarnings("rawtypes")
	public Map<String, Object> uploadImg(MultipartHttpServletRequest multipartRequest,String userId) {
		Map<String, Object> resultMap = new Hashtable<String, Object>();
		TZlImage zlImage = new TZlImage();
		//图片路径
		String imgUrl = "";
		try {
			for (Iterator it = multipartRequest.getFileNames(); it.hasNext();) {  
				 String key = (String) it.next();  
				 MultipartFile imgFile = multipartRequest.getFile(key);
				 //如果上传的图片为空
				 if (imgFile == null) {
					 resultMap.put("success", false);
			         resultMap.put("data", "图片上传失败！");
			         return resultMap;
				}else {
					// 上传
					imgUrl = fastDFSFileStoreComponent.saveFile(imgFile.getBytes(),
					       FilenameUtils.getExtension(imgFile.getOriginalFilename()));
					
					//保存图片的信息到库中
					zlImage.setUserid(userId);
					zlImage.setImageName(imgFile.getOriginalFilename());
					zlImage.setUploadTime(DateUtils.getCurrentGaDate());
					zlImage.setImageUrl(imgUrl);
					zlImage.setDeleteStaues(SysCode.NO_FLAG);
					attachmentDao.save(zlImage);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		resultMap.put("success", true);
        resultMap.put("imgIdStr",zlImage.getObjectid());
        resultMap.put("imgUrlStr", imgUrl);
		return resultMap;
	}
	
	@Override
	public String uploadHead(File file) {
		// 上传
		String headUrl = "";
		try {
			headUrl = fastDFSFileStoreComponent.saveFile(file,
			       FilenameUtils.getExtension(file.getName()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return headUrl;
		
	}

}




