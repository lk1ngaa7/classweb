package com.classweb.model;
	/**
	 * ������
	 * @author MingYates
	 *
	 */
public class Ac_album {
	/**
	 * ����
	 * ͼƬ·����ac_img_href��
	 * �id����ac_id��
	 * 
	 */
	private String ac_img_href;
	private int ac_id;
	
	
	/**
	 * �޲ι��췽��
	 */
	public Ac_album() {
		super();
	}
	
	/**
	 * �вι��췽��
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
