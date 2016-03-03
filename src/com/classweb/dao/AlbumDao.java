package com.classweb.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.classweb.model.Album;
import com.classweb.util.DBUtil;

public class AlbumDao {

	/**
	 * 获取相册方法
	 * @return 返回图片路径组成的字符串数组
	 */
public List<Album> getAlbum(){
	
		Album album = null;
		List<Album> list = new ArrayList<Album>();
		
		String sql="select * from class_album;";		
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;

		DBUtil db=new DBUtil();
		try {
			conn=db.getConn();
			pstm=conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			
			while(rs.next()){
				album = new Album();
				album.setImg_href(rs.getString("img_href"));
				list.add(album);
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
	
		return list;
	}
	/**
	 * 添加图片方法
	 * @param Ac_album 对象 picture（路径、活动名）
	 * @return 添加成功返回true，失败返回false
	 */
	public boolean addPicture(List<Album> list){
		
		int size = list.size();		
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		Album picture = null;

		DBUtil db=new DBUtil();
		
			try {
				conn=db.getConn();
				conn.setAutoCommit(false);
				String sql="insert into class_album values(?);";
				pstm=conn.prepareStatement(sql);
				for(int i=0;i<size;i++){
					picture = new Album();
					picture = list.get(i);
					pstm.setString(1, picture.getImg_href());
					pstm.addBatch();
				}
				pstm.executeBatch();
				conn.commit();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				try {
					if(conn.isClosed()){
						conn.rollback();
						return false;
						}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{

				try {
					db.close(rs, pstm, conn);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}     //关闭连接
			}
		
		return true;
		
	}
	
	/**
	 * 删除相册方法
	 * @param 活动id：ac_id
	 * @return 删除成功返回true，失败返回false
	 */
public boolean deletePicture(Album picture){
		
		String sql="delete from class_album where img_href=?;";		
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;

		DBUtil db=new DBUtil();
		try {
			conn=db.getConn();
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, picture.getImg_href());
			
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
