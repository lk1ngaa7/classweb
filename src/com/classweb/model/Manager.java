package com.classweb.model;


	/**
	 * 管理员类
	 * @author MingYates
	 *
	 */
public class Manager {

	/**
	 *属性
	 *登录名：name
	 *登录密码：password 
	 */
	
	private String name;
	private String password;
	
	
	/**
	 * 无参构造方法
	 */
	public Manager() {
		super();
	}
	/**
	 * 有参构造方法
	 * @param name
	 * @param password
	 */
	public Manager(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
