package com.classweb.model;

	/**
	 * �༶�����
	 * @author MingYates
	 *
	 */
public class Album {

	/**
	 * ����
	 * ͼƬ·����img_href
	 */
	private String img_href;

	
	/**
	 * �޲ι��췽��
	 */
	public Album() {
		super();
	}
	
	/**
	 * �вι��췽��
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
