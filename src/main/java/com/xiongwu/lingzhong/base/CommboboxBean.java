package com.xiongwu.lingzhong.base;

/**
 * 	下拉列表bean
 *  
 *  @author xiongwu@iflytek.com
 *  @created 2015年12月9日 下午2:03:21
 *  @lastModified       
 *  @history
 */
public class CommboboxBean {

	/**
	 * 键
	 */
	private String text;

	/**
	 * 值
	 */
	private String value;

	public CommboboxBean(String text, String value) {
		this.text = text;
		this.value = value;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
