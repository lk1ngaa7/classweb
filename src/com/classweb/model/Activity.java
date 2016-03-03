package com.classweb.model;

import java.sql.Date;

	/**
	 * 班级活动类
	 * @author MingYates
	 *
	 */
public class Activity {

	/**
	 * 属性
	 * 活动id（ac_id）
	 * 活动名称（ac_name）
	 * 活动时间（ac_time）
	 * 活动标题图片（ac_img_href）
	 * 活动内容（ac_content）
	 */
	
	private int ac_id;
	private String  ac_name;
	private Date ac_time;
	private String ac_img_href;
	private String ac_content;
	
	/**
	 * 无参构造方法	
	 */
	public Activity() {
		super();
	}
	
	/**
	 * 有参构造方法
	 * @param ac_id
	 * @param ac_name
	 * @param ac_time
	 * @param ac_img_href
	 * @param ac_content
	 */
	public Activity(int ac_id, String ac_name, Date ac_time,
			String ac_img_href, String ac_content) {
		super();
		this.ac_id = ac_id;     //自增主键
		this.ac_name = ac_name;
		this.ac_time = ac_time;
		this.ac_img_href = ac_img_href;
		this.ac_content = ac_content;
	}
	public int getAc_id() {
		return ac_id;
	}
	public void setAc_id(int ac_id) {
		this.ac_id = ac_id;
	}
	public String getAc_name() {
		return ac_name;
	}
	public void setAc_name(String ac_name) {
		this.ac_name = ac_name;
	}
	public Date getAc_time() {
		return ac_time;
	}
	public void setAc_time(Date ac_time) {
		this.ac_time = ac_time;
	}
	public String getAc_img_href() {
		return ac_img_href;
	}
	public void setAc_img_href(String ac_img_href) {
		this.ac_img_href = ac_img_href;
	}
	public String getAc_content() {
		return ac_content;
	}
	public void setAc_content(String ac_content) {
		this.ac_content = ac_content;
	}
	
	
}
