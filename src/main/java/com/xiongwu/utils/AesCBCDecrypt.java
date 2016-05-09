package com.xiongwu.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;


/**
 * 	解密方法
 *  
 *  @author xiongwu@iflytek.com
 *  @created 2015年12月10日 下午2:32:46
 *  @lastModified       
 *  @history
 */
public class AesCBCDecrypt {
	
	public static String decrypt(String data, String key) throws Exception {
		try{
			String iv = "0123456789abcdef";

			byte[] encrypted1 = new Base64().decode(data.getBytes());
			 
			Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
			SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");
			IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());
			             
			cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);
			  
			byte[] original = cipher.doFinal(encrypted1);
			String originalString = new String(original);
			return originalString.trim();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}