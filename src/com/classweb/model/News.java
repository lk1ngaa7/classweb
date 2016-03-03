package com.classweb.model;

import java.sql.Timestamp;

/**
 * �༶������
 * @author MingYates
 *
 */
public class News {

	/**
	 * ���� 
	 * ����id��news_id��
	 * ���⣨tilte��
	 * �����ͼƬ��img_href
	 * ���ݣ�content��
	 * �����ˣ�publisher��
	 * ����ʱ�䣨publish_time��
	 * 
	 */
	private int news_id;
	private String tilte;
	private String img_href;
	private String content;
	private String publisher;
	private java.sql.Timestamp publish_time;
	
	/*
	 * �޲ι��췽��
	 */
	public News() {
		super();
	}
	/**
	 * �вι��췽��
	 * @param tilte
	 * @param img_href
	 * @param content
	 * @param publisher
	 * @param publish_time
	 */
	public News(int id, String tilte, String img_href, String content,
			String publisher, Timestamp publish_time) {
		super();
		this.news_id = id;    //��������
		this.tilte = tilte;
		this.img_href = img_href;
		this.content = content;
		this.publisher = publisher;
		this.publish_time = publish_time;
	}
	public int getNews_id() {
		return news_id;
	}
	public void setNews_id(int news_id) {
		this.news_id = news_id;
	}
	public String getTilte() {
		return tilte;
	}
	public void setTilte(String tilte) {
		this.tilte = tilte;
	}
	public String getImg_href() {
		return img_href;
	}
	public void setImg_href(String img_href) {
		this.img_href = img_href;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Timestamp getPublish_time() {
		return publish_time;
	}
	public void setPublish_time(Timestamp publish_time) {
		this.publish_time = publish_time;
	}
	
	
}
