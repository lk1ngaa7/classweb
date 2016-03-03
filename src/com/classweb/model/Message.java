package com.classweb.model;

import java.sql.Date;
	/**
	 * 班级寄语类
	 * @author MingYates
	 *
	 */
public class Message {

	/**
	 * 属性
	 * 寄语id（msg_id）
	 * 发布人昵称（nick_name）
	 * 内容（msg_content）
	 * 发布时间（msg_time）
	 * 
	 */
	
	private String nick_name;
	private String msg_content;
	private Date msg_time;
	private int msg_id;
	
	/**
	 * 无参构造方法		
	 */
	public Message() {
		super();
	}

	/**
	 * 有参构造方法
	 * @param nick_name
	 * @param msg_content
	 * @param msg_time
	 * @param msg_id
	 */
	public Message(String nick_name, String msg_content, Date msg_time,
			int msg_id) {
		super();
		this.nick_name = nick_name;
		this.msg_content = msg_content;
		this.msg_time = msg_time;
		this.msg_id = 0;    //自增主键，初始化为0
	}
	public String getNick_name() {
		return nick_name;
	}
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}
	public String getMsg_content() {
		return msg_content;
	}
	public void setMsg_content(String msg_content) {
		this.msg_content = msg_content;
	}
	public Date getMsg_time() {
		return msg_time;
	}
	public void setMsg_time(Date msg_time) {
		this.msg_time = msg_time;
	}
	public int getMsg_id() {
		return msg_id;
	}
	public void setMsg_id(int msg_id) {
		this.msg_id = msg_id;
	}
	
}
