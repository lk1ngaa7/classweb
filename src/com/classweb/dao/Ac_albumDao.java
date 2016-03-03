package com.classweb.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.classweb.model.Ac_album;
import com.classweb.util.DBUtil;

public class Ac_albumDao {

	/**
	 * �����᷽��
	 * @param ���idac_id
	 * @return �����ַ������顪��ͼƬ·������
	 */
	public String[] getAlbum(int ac_id){
		
		String[] album =new String[100];
		
		String sql="select ac_img_href from activity_album where ac_id=?;";		
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;

		DBUtil db=new DBUtil();
		try {
			conn=db.getConn();
			pstm=conn.prepareStatement(sql);
			pstm.setInt(1, ac_id);
			rs=pstm.executeQuery();
			
			for(int i=0;rs.next();i++){
				album[i++]=rs.getString("ac_img_href");
			}
			
			db.close(rs, pstm, conn);     //�ر�����
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return album;
	}
	/**
	 * ���ͼƬ����
	 * 
	 * @param Ac_album ���� picture��·���������
	 * @return ��ӳɹ�����true��ʧ�ܷ���false
	 */
	public boolean addPicture(Ac_album picture){
		
		String sql="insert into activity_album values(?,?);";		
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;

		DBUtil db=new DBUtil();
		try {
			
			conn=db.getConn();
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, picture.getAc_img_href());
			pstm.setInt(2, picture.getAc_id());
			
			int status=pstm.executeUpdate();
			
			db.close(rs, pstm, conn);     //�ر�����
			
			if(status>0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;	
	}
	
	/**
	 * ɾ����᷽��
	 * @param �id��ac_id
	 * @return ɾ���ɹ�����true��ʧ�ܷ���false
	 */
public boolean deleteAlbum(int ac_id){
		
		String sql="detele from activity_album where ac_id=?;";		
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;

		DBUtil db=new DBUtil();
		try {
			conn=db.getConn();
			pstm=conn.prepareStatement(sql);
			pstm.setInt(1, ac_id);
			
			//״̬��ʾstatus
			int status=pstm.executeUpdate();
			
			db.close(rs, pstm, conn);     //�ر�����
			
			if(status>0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;	
	}	
}
