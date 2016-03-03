package com.classweb.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.classweb.model.Manager;
import com.classweb.util.DBUtil;

public class ManagerDao {

	
	/**
	 * ��½��֤����
	 * @param ����Ա����user
	 * @return ��½�ɹ�����true��ʧ�ܷ���false
	 */
	public boolean login(Manager user){
		
		String sql="select * from data_manager where name=? and password=?;";		
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		
		DBUtil db=new DBUtil();
		try {
			conn=db.getConn();
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, user.getName());
			pstm.setString(2, user.getPassword());
			
			rs=pstm.executeQuery();

			if(rs.next()){
				return true;
			}
			
			db.close(rs, pstm, conn);     //�ر�����
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public void update(Manager user){
		
		String sql="update data_manager set name=?,password=?;";		
		Connection conn=null;
		PreparedStatement pstm=null;
		
		DBUtil db=new DBUtil();
		try {
			conn=db.getConn();
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, user.getName());
			pstm.setString(2, user.getPassword());
			
			pstm.executeUpdate();
			db.close(null ,pstm, conn);     //�ر�����
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
