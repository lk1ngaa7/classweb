package com.classweb.model;
	/**
	 * 活动相册类
	 * @author MingYates
	 *
	 */
public class Ac_album {
	/**
	 * 属性
	 * 图片路径（ac_img_href）
	 * 活动id：（ac_id）
	 * 
	 */
	private String ac_img_href;
	private int ac_id;
	
	
	/**
	 * 无参构造方法
	 */
	public Ac_album() {
		super();
	}
	
	/**
	 * 有参构造方法
	 * @param ac_img_href
	 * @param ac_id
	 */
	public Ac_album(String ac_img_href, int ac_id) {
		super();
		this.ac_img_href = ac_img_href;
		this.ac_id = ac_id;       
	}
	public String getAc_img_href() {
		return ac_img_href;
	}
	public void setAc_img_href(String ac_img_href) {
		this.ac_img_href = ac_img_href;
	}
	public int getAc_id() {
		return ac_id;
	}
	public void setAc_id(int ac_id) {
		this.ac_id = ac_id;
	}
	
}
