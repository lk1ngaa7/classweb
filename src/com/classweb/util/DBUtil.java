package com.classweb.util;

//import java.io.BufferedInputStream;
//import java.io.File;
//import java.io.FileInputStream;
import java.io.IOException;
//import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


public class DBUtil {
	/**
	 * 得到数据库连接通用方法
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Connection getConn() throws IOException, ClassNotFoundException,
			SQLException {
		Connection conn = null;
		// 得到属性文件
		// 1.得到文件路径
		//File f = new File("/src/connection.properties");
		// 2.得到属性文件实例
		Properties p = new Properties();
		p.load(this.getClass().getClassLoader().getResourceAsStream("connection.properties"));
		// 3.输入流
		//InputStream input = new BufferedInputStream(new FileInputStream(f));
		//p.load(input);
		//input.close();
		String className = p.getProperty("jdbc.Driver");
		String url = p.getProperty("jdbc.url");
		String username = p.getProperty("jdbc.user");
		String password = p.getProperty("jdbc.pwd");
		// 注册或者加载驱动
		Class.forName(className);
		conn = DriverManager.getConnection(url, username, password);
		return conn;
	}

	
	/**
	 * 通用关闭方法
	 * 
	 * @param rs
	 *            結果集
	 * @param pstm
	 * @param conn
	 * @throws SQLException
	 */
	
	public void close(ResultSet rs, PreparedStatement pstm,
			Connection conn) throws SQLException {
		if (rs != null) {
			rs.close();
		}
		if (pstm != null) {
			pstm.close();
		}
		if (conn != null) {
			conn.close();
		}
	}
}
