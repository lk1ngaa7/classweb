package com.classweb.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.classweb.model.News;
import com.classweb.util.DBUtil;

public class NewsDao {

	/**
	 * ��ȡ�������ŷ���
	 * 
	 * @return ����News��������
	 */
	public List<News> getNewsGroup() {
		String sql = "select * from class_news;";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<News> list = new ArrayList<News>();
		News news = null;
		DBUtil db = new DBUtil();

		try {
			conn = db.getConn();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {
				news = new News();
				news.setNews_id(rs.getInt("news_id"));
				news.setTilte(rs.getString("tilte"));
				news.setImg_href(rs.getString("img_href"));
				news.setContent(rs.getString("content"));
				news.setPublisher(rs.getString("publisher"));
				news.setPublish_time(rs.getTimestamp("publish_time"));
				list.add(news);
			}
			db.close(rs, pstm, conn);     //�ر�����
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * ��ȡ����������
	 * 
	 * @param ����id
	 *            ��news_id
	 * @return �������Ŷ���
	 */
	public News getNewsById(int news_id) {
		String sql = "select * from class_news where news_id=? ;";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		News news = new News();

		DBUtil db = new DBUtil();

		try {

			conn = db.getConn();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, news_id);
			rs = pstm.executeQuery();
			while (rs.next()) {
				news.setNews_id(news_id);
				news.setTilte(rs.getString("tilte"));
				news.setImg_href(rs.getString("img_href"));
				news.setContent(rs.getString("content"));
				news.setPublisher(rs.getString("publisher"));
				news.setPublish_time(rs.getTimestamp("publish_time"));
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

		return news;
	}

	/**
	 * ������ŷ���
	 * 
	 * @param News����news
	 * @return ��ӳɹ�����true��ʧ�ܷ���false
	 */
	public boolean addNews(News news) {

		String sql = "insert into class_news (tilte,img_href,content,publisher,publish_time) values(?,?,?,?,?);";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		DBUtil db = new DBUtil();
		try {
			conn = db.getConn();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, news.getTilte());
			pstm.setString(2, news.getImg_href());
			pstm.setString(3, news.getContent());
			pstm.setString(4, news.getPublisher());
			pstm.setTimestamp(5, news.getPublish_time());
			int status = pstm.executeUpdate();
			
			db.close(rs, pstm, conn);     //�ر�����
			
			if (status > 0) {
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
	 * ɾ�����ŷ���
	 * 
	 * @param ����id
	 *            ��news_id
	 * @return ɾ���ɹ�����true��ʧ�ܷ���false
	 */
	public boolean deleteNews(int news_id) {
		String sql = "delete from class_news where news_id=?;";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		DBUtil db = new DBUtil();
		try {
			conn = db.getConn();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, news_id);

			int status = pstm.executeUpdate();
			
			db.close(rs, pstm, conn);     //�ر�����
			
			if (status > 0) {
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
	 * �޸����ŷ���
	 * 
	 * @param News����news
	 * @return �޸ĳɹ�����true��ʧ�ܷ���false
	 */
	public boolean modifyNews(News news) {

		String sql = "update class_news set tilte=?,img_href=?,content=?,publisher=?,publish_time=? where news_id=?;";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		DBUtil db = new DBUtil();
		try {
			conn = db.getConn();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, news.getTilte());
			pstm.setString(2, news.getImg_href());
			pstm.setString(3, news.getContent());
			pstm.setString(4, news.getPublisher());
			pstm.setTimestamp(5, news.getPublish_time());
			pstm.setInt(6, news.getNews_id());

			int status = pstm.executeUpdate();
			
			db.close(rs, pstm, conn);     //�ر�����
			
			if (status > 0) {
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
