<%@page import="com.classweb.model.Activity"%>
<%@page import="java.sql.Date"%>
<%@page import="com.classweb.model.News"%>
<%@page import="com.classweb.util.fileutil.AddContent"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");
String id = request.getParameter("id");
AddContent act = new AddContent();
String content = act.addTxt();
if(id.equals("news")){
	String title = request.getParameter("title");
	String author = request.getParameter("author");
	String img = request.getParameter("link");
	News news = new News(0,title,img,content,author,null);
	session.setAttribute("news_button", news);
	response.sendRedirect("news_manage_add.jsp?id=y_news");
	}else{
		String name = request.getParameter("name");
		String date = request.getParameter("time");
		Date time = Date.valueOf(date);
		String link = request.getParameter("link");
		Activity activity = new Activity(0,name,time,link,content);
		session.setAttribute("ac_button", activity);
		response.sendRedirect("ac_manage_add.jsp?id=y_ac");
	}
%>
</body>
</html>