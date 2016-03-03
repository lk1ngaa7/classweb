<%@page import="java.sql.Timestamp"%>
<%@page import="com.classweb.dao.NewsDao"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.classweb.model.News"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");
int id = Integer.parseInt(request.getParameter("id"));
String msg = request.getParameter("msg");
String title = request.getParameter("title");
String link = request.getParameter("link");
String author = request.getParameter("author");
String content = request.getParameter("content");
Date datetime=new Date();
Timestamp time = new Timestamp(datetime.getTime());
News news = new News(id,title,link,content,author,time);
NewsDao nd = new NewsDao();
if(msg.equals("f")){
	if(nd.modifyNews(news)){
		response.sendRedirect("news_manage.jsp");
	}else{
	%>
	<c:redirect url="news_manage.jsp">
	<c:param name="info" value="操作失败！！！"></c:param>
	</c:redirect>
	<%
	}}else{
		if(nd.addNews(news)){
			response.sendRedirect("news_manage.jsp");
		}else{
			%>
			<c:redirect url="news_manage.jsp">
			<c:param name="info" value="操作失败！！！"></c:param>
			</c:redirect>
			<%
		}
}
%>
</body>
</html>