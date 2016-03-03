<%@page import="com.classweb.model.Manager"%>
<%@page import="com.classweb.model.Activity"%>
<%@page import="java.sql.Date"%>
<%@page import="com.classweb.model.News"%>
<%@page import="com.classweb.util.fileutil.CopyToProject"%>
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
String type = "";
int num = -1;
int sid = -1;
try{
	type = request.getParameter("type");
	num = Integer.parseInt(request.getParameter("num"));
	sid = Integer.parseInt(request.getParameter("sid"));
}catch(Exception e){
	type = "";
	num = -1;
	sid = -1;
}
AddContent act = new AddContent();
String url = getServletContext().getRealPath("/images");
if(id.equals("news")){
	String img = act.addImg(url,id);
	String title = request.getParameter("title");
	String author = request.getParameter("author");
	String content = request.getParameter("content");
	News news = new News(0,title,img,content,author,null);
	if(type.equals("edit")){
		String href = "news_manage_edit.jsp?id="+sid+"&li="+num;
		session.setAttribute("news"+num, news);
		response.sendRedirect(href);
	}else{
		session.setAttribute("news_button", news);
		response.sendRedirect("news_manage_add.jsp?id=y_news");
	}
	}else{
		String img = act.addImg(url,id);
		String name = request.getParameter("name");
		String date = request.getParameter("time");
		Date time = Date.valueOf(date);
		String content = request.getParameter("content");
		Activity activity = new Activity(0,name,time,img,content);
		if(type.equals("edit")){
			String href = "ac_manage_edit.jsp?id="+sid+"&li="+num;
			session.setAttribute("activity"+num, activity);
			response.sendRedirect(href);
		}else{
			session.setAttribute("ac_button", activity);
			response.sendRedirect("ac_manage_add.jsp?id=y_ac");
		}
	}
%>
</body>
</html>