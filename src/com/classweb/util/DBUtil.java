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
	 * �õ����ݿ�����ͨ�÷���
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Connection getConn() throws IOException, ClassNotFoundException,
			SQLException {
		Connection conn = null;
		// �õ������ļ�
		// 1.�õ��ļ�·��
		//File f = new File("/src/connection.properties");
		// 2.�õ������ļ�ʵ��
		Properties p = new Properties();
		p.load(this.getClass().getClassLoader().getResourceAsStream("connection.properties"));
		// 3.������
		//InputStream input = new BufferedInputStream(new FileInputStream(f));
		//p.load(input);
		//input.close();
		String className = p.getProperty("jdbc.Driver");
		String url = p.getProperty("jdbc.url");
		String username = p.getProperty("jdbc.user");
		String password = p.getProperty("jdbc.pwd");
		// ע����߼�������
		Class.forName(className);
		conn = DriverManager.getConnection(url, username, password);
		return conn;
	}

	
	/**
	 * ͨ�ùرշ���
	 * 
	 * @param rs
	 *            �Y����
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
