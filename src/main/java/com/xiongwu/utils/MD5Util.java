package com.xiongwu.utils;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.util.StringUtils;

/**
 * 	MD5摘要工具
 *  
 *  @author xiongwu@iflytek.com
 *  @created 2015年12月5日 下午2:29:48
 *  @lastModified       
 *  @history
 */
public class MD5Util {   
       
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5',
        '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private static final String encodingAlgorithm="MD5";

    private static String characterEncoding;

    public static void main(String[] args) {
		System.out.println(MD5Util.encode("iflytek!"));
	}
    
    public static String encode(final String password) {
        if (password == null) {
            return null;
        }

        try {
            MessageDigest messageDigest = MessageDigest
                .getInstance(encodingAlgorithm);

            if (StringUtils.hasText(characterEncoding)) {
                messageDigest.update(password.getBytes(characterEncoding));
            } else {
                messageDigest.update(password.getBytes());
            }


            final byte[] digest = messageDigest.digest();

            return getFormattedText(digest);
        } catch (final NoSuchAlgorithmException e) {
            throw new SecurityException(e);
        } catch (final UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Takes the raw bytes from the digest and formats them correct.
     * 
     * @param bytes the raw bytes from the digest.
     * @return the formatted bytes.
     */
    private static String getFormattedText(byte[] bytes) {
        final StringBuilder buf = new StringBuilder(bytes.length * 2);

        for (int j = 0; j < bytes.length; j++) {
            buf.append(HEX_DIGITS[(bytes[j] >> 4) & 0x0f]);
            buf.append(HEX_DIGITS[bytes[j] & 0x0f]);
        }
        return buf.toString();
    }
    
    /**
     * ｛对密码进行5次MD5加密｝
     *  
     *  @param  pwd 需要加密的密码
     *  @return password 加密后的密码
     *  @author xiongwu@iflytek.com
     *  @created 2015年12月5日 下午2:30:02
     *  @lastModified       
     *  @history
     */
	public static String fiveEncode(String pwd){
		if (pwd == null) {
            return null;
        }
		String password = pwd;
		//对密码进行5次加密
		for (int i = 0; i < 5; i++) {
			password =  MD5Util.encode(password);
		}
		return password;
	}

}  
