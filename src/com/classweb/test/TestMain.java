package com.classweb.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.classweb.util.DBUtil;

public class TestMain {
	
	/**
	 * 测试入口
	 */
	public static void main() {
		
		Test test=new Test();
		
		System.out.println("?????????????????????????????????????????????");
		
		testDBUtil();
		test.testAc_album();
	
		System.out.println("??????????????????????????????????????????????");
		
	}
	
	
	/**
	 * 数据库连接测试方法
	 */
	public static void testDBUtil(){
		Connection conn=null;
		DBUtil db=new DBUtil();
		
		try {
			conn=db.getConn();
			if(conn!=null){
				System.out.println("***********************************");
				System.out.println("获取数据库连接成功！");
				System.out.println("************************************");
			}
			
			db.close(null, null, conn);
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
