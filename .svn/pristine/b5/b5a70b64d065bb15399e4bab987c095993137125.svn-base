/**	
 * <br>
 * Copyright 2015 IFlyTek. All rights reserved.<br>
 * <br>			 
 * Package: com.xiongwu.utils <br>
 * FileName: ImageUtil.java <br>
 * <br>
 * @version
 * @author xiongwu@iflytek.com
 * @created 2016年2月23日
 * @last Modified 
 * @history
 */

package com.xiongwu.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import com.primeton.ext.infra.security.BASE64Decoder;

/**
 * 图片处理工具类
 * 
 * @author xiongwu@iflytek.com
 * @created 2016年2月23日 下午2:18:27
 * @lastModified
 * @history
 */

public class ImageUtil {

	/**
	 * base64字符串转化成图片
	 * 
	 * @param imgStr
	 *            base64编码
	 * @return
	 * @author xiongwu@iflytek.com
	 * @created 2016年2月23日 下午2:19:23
	 * @lastModified
	 * @history
	 */
	public static String GenerateImage(String imgStr,String uploadHeadUrl,String ImgFormat) {

		//文件保存路径
		String filePath = uploadHeadUrl + DateUtils.getCurrentGaDate()+ StringUtil.getRandNum(6) + ImgFormat;
		try {
			// 对字节数组字符串进行Base64解码并生成图片
			// 图像数据为空
			if (imgStr == null) {
				return "";
			} else {
				BASE64Decoder decoder = new BASE64Decoder();
				// Base64解码
				byte[] b = decoder.decodeBuffer(imgStr);
				for (int i = 0; i < b.length; ++i) {
					if (b[i] < 0) {// 调整异常数据
						b[i] += 256;
					}
				}
				// 生成jpeg图片
				if  (!new File(uploadHeadUrl).exists()  && !new File(uploadHeadUrl).isDirectory()) {
					new File(uploadHeadUrl).mkdir();
					OutputStream out = new FileOutputStream(filePath);
					out.write(b);
					out.flush();
					out.close();
				}else {
					OutputStream out = new FileOutputStream(filePath);
					out.write(b);
					out.flush();
					out.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filePath;
	}
}
