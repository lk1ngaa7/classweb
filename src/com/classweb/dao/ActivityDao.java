package com.classweb.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.classweb.model.Activity;
import com.classweb.util.DBUtil;

public class ActivityDao {

	/**
	 * ��ȡ���������
	 * 
	 * @return ����Activity��������
	 */
	public List<Activity> getActivityGroup() {
		String sql = "select * from class_activity;";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<Activity> list = new ArrayList<Activity>();
		Activity activity = null;
		DBUtil db = new DBUtil();

		try {
			conn = db.getConn();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {
				activity = new Activity();
				activity.setAc_id(rs.getInt("ac_id"));
				activity.setAc_content(rs.getString("ac_content"));
				activity.setAc_name(rs.getString("ac_name"));
				activity.setAc_time(rs.getDate("ac_time"));
				activity.setAc_img_href(rs.getString("ac_img_href"));
				list.add(activity);
			}
			
			db.close(rs, pstm, conn);     //�ر�����
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * ��ȡ�����
	 * 
	 * @param �id
	 *            ��ac_id
	 * @return ����activity����
	 */
	public Activity getActivity(int ac_id) {

		String sql = "select * from class_activity where ac_id=? ;";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Activity activity = new Activity();

		DBUtil db = new DBUtil();

		try {

			conn = db.getConn();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, ac_id);
			rs = pstm.executeQuery();
			while (rs.next()) {
				activity.setAc_id(ac_id);
				activity.setAc_content(rs.getString("ac_content"));
				activity.setAc_name(rs.getString("ac_name"));
				activity.setAc_time(rs.getDate("ac_time"));
				activity.setAc_img_href(rs.getString("ac_img_href"));
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

		return activity;
	}

	/**
	 * ��ӻ����
	 * 
	 * @param Activity����ac
	 * @return ��ӳɹ�����true��ʧ�ܷ���false
	 */
	public boolean addActivity(Activity ac) {

		String sql = "insert into class_activity (ac_name,ac_time,ac_img_href,ac_content) values(?,?,?,?);";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		DBUtil db = new DBUtil();
		try {
			conn = db.getConn();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, ac.getAc_name());
			pstm.setDate(2, ac.getAc_time());
			pstm.setString(3, ac.getAc_img_href());
			pstm.setString(4, ac.getAc_content());

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
	 * ɾ�������
	 * 
	 * @param �id
	 *            ��ac_id
	 * @return ɾ���ɹ�����true��ʧ�ܷ���false
	 */
	public boolean deleteActivity(int ac_id) {
		String sql = "delete from class_activity where ac_id=?;";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		DBUtil db = new DBUtil();
		try {
			conn = db.getConn();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, ac_id);

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
	 * �޸Ļ����
	 * 
	 * @param Activity����activity
	 * @return �޸ĳɹ�����true��ʧ�ܷ���false
	 */
	public boolean modifyActivity(Activity activity) {

		String sql = "update class_activity set ac_name=?,ac_time=?,ac_img_href=?,ac_content=? where ac_id=?;";
		Connection conn = null;
		PreparedStatement pstm = null;

		DBUtil db = new DBUtil();
		try {
			conn = db.getConn();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, activity.getAc_name());
			pstm.setDate(2, activity.getAc_time());
			pstm.setString(3, activity.getAc_img_href());
			pstm.setString(4, activity.getAc_content());
			pstm.setInt(5, activity.getAc_id());

			int status = pstm.executeUpdate();
			
			db.close(null, pstm, conn);     //�ر�����
			
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
