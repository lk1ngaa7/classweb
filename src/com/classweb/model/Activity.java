package com.classweb.model;

import java.sql.Date;

	/**
	 * �༶���
	 * @author MingYates
	 *
	 */
public class Activity {

	/**
	 * ����
	 * �id��ac_id��
	 * ����ƣ�ac_name��
	 * �ʱ�䣨ac_time��
	 * �����ͼƬ��ac_img_href��
	 * ����ݣ�ac_content��
	 */
	
	private int ac_id;
	private String  ac_name;
	private Date ac_time;
	private String ac_img_href;
	private String ac_content;
	
	/**
	 * �޲ι��췽��	
	 */
	public Activity() {
		super();
	}
	
	/**
	 * �вι��췽��
	 * @param ac_id
	 * @param ac_name
	 * @param ac_time
	 * @param ac_img_href
	 * @param ac_content
	 */
	public Activity(int ac_id, String ac_name, Date ac_time,
			String ac_img_href, String ac_content) {
		super();
		this.ac_id = ac_id;     //��������
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
