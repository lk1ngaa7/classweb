package com.classweb.model;

	/**
	 * 班级相册类
	 * @author MingYates
	 *
	 */
public class Album {

	/**
	 * 属性
	 * 图片路径：img_href
	 */
	private String img_href;

	
	/**
	 * 无参构造方法
	 */
	public Album() {
		super();
	}
	
	/**
	 * 有参构造方法
	 * @param img_href
	 */
	public Album(String img_href) {
		super();
		this.img_href = img_href;
	}

	public String getImg_href() {
		return img_href;
	}

	public void setImg_href(String img_href) {
		this.img_href = img_href;
	}
	
	
	
}
