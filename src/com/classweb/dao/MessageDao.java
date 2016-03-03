package com.classweb.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.classweb.model.Message;
import com.classweb.util.DBUtil;

public class MessageDao {

	/**
	 * 获取多条Message方法
	 * 
	 * @return 返回Message对象数组
	 */
	public List<Message> getMessageGroup() {
		String sql = "select * from class_message;";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<Message> list = new ArrayList<Message>();
		
		DBUtil db = new DBUtil();

		try {
			conn = db.getConn();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {
				Message message=new Message();
				message.setMsg_id(rs.getInt("msg_id"));
				message.setMsg_content(rs.getString("msg_content"));
				message.setMsg_time(rs.getDate("msg_time"));
				message.setNick_name(rs.getString("nick_name"));
				list.add(message);
			}
			db.close(rs, pstm, conn);     //关闭连接
			
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
	 * 通过id获取寄语方法
	 * 
	 * @param 寄语id
	 *            ：msg_id
	 * @return 返回信息对象
	 */
	public Message getMessageById(int msg_id) {

		String sql = "select * from class_message where msg_id=? ;";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Message message = new Message();
		DBUtil db = new DBUtil();
		try {

			conn = db.getConn();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, msg_id);
			rs = pstm.executeQuery();
			while (rs.next()) {
				message.setMsg_id(msg_id);
				message.setMsg_content(rs.getString("msg_content"));
				message.setMsg_time(rs.getDate("msg_time"));
				message.setNick_name(rs.getString("nick_name"));
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
		return message;
	}

	/**
	 * 添加寄语方法
	 * 
	 * @param Message对象message
	 * @return 添加成功返回true，失败返回false
	 */
	public boolean addMessage(Message message) {

		String sql = "insert into class_message (nick_name,msg_content,msg_time) values (?,?,?);";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		DBUtil db = new DBUtil();
		try {
			conn = db.getConn();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, message.getNick_name());
			pstm.setString(2, message.getMsg_content());
			pstm.setDate(3, message.getMsg_time());

			int status = pstm.executeUpdate();
			
			db.close(rs, pstm, conn);     //关闭连接
			
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
	 * 删除寄语方法
	 * 
	 * @param 寄语id
	 *            ：msg_id
	 * @return 删除成功返回true，失败返回false
	 */
	public boolean deleteMessage(int msg_id) {
		String sql = "delete from class_message where msg_id=?;";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		DBUtil db = new DBUtil();
		try {
			conn = db.getConn();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, msg_id);

			int status = pstm.executeUpdate();
			
			db.close(rs, pstm, conn);     //关闭连接
			
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
	 * 修改寄语方法
	 * 
	 * @param Message对象message
	 * @return 修改成功返回true，失败返回false
	 */
	public boolean modifyMessage(Message message) {

		String sql = "update class_message set nick_name=?,msg_content=?,msg_time=? where ac_id=?;";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		DBUtil db = new DBUtil();
		try {
			conn = db.getConn();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, message.getNick_name());
			pstm.setString(2, message.getMsg_content());
			pstm.setDate(3, message.getMsg_time());
			pstm.setInt(4, message.getMsg_id());

			int status = pstm.executeUpdate();
			
			db.close(rs, pstm, conn);     //关闭连接
			
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