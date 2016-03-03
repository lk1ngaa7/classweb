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
	 * 获得相册方法
	 * @param 活动的idac_id
	 * @return 返回字符串数组——图片路径集合
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
			
			db.close(rs, pstm, conn);     //关闭连接
			
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
	 * 添加图片方法
	 * 
	 * @param Ac_album 对象 picture（路径、活动名）
	 * @return 添加成功返回true，失败返回false
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
			
			db.close(rs, pstm, conn);     //关闭连接
			
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
	 * 删除相册方法
	 * @param 活动id：ac_id
	 * @return 删除成功返回true，失败返回false
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
			
			//状态标示status
			int status=pstm.executeUpdate();
			
			db.close(rs, pstm, conn);     //关闭连接
			
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
