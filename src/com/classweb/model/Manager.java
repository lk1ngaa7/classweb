package com.classweb.model;


	/**
	 * ����Ա��
	 * @author MingYates
	 *
	 */
public class Manager {

	/**
	 *����
	 *��¼����name
	 *��¼���룺password 
	 */
	
	private String name;
	private String password;
	
	
	/**
	 * �޲ι��췽��
	 */
	public Manager() {
		super();
	}
	/**
	 * �вι��췽��
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
