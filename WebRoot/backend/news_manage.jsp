<%@page import="com.classweb.model.Manager"%>
<%@page import="java.util.List"%>
<%@page import="com.classweb.dao.NewsDao"%>
<%@page import="com.classweb.model.News"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="../css/backend/ac_news_manage.css">
<title>新闻管理</title>
<script src="../js/common.js" ></script>
</head>
<body>
<!-- show all news -->
<!-- title --><!-- brief --><!-- delete --><!-- edit -->
<%
Manager user = new Manager();
try{
user = (Manager)session.getAttribute("user");
String name = user.getName();
session.removeAttribute("user");
session.setAttribute("user", user);
}catch(Exception e){
	response.sendRedirect("Login.jsp");
}
NewsDao nd = new NewsDao();
List<News> list = nd.getNewsGroup();
int size = list.size();
%>
<div id="head">新闻管理</div>
${param.info }<br/>
<div id="thead">
	<div class="no">编号</div>
	<div class="title">标题</div>
	<div class="date">日期</div>
	<div class="operation">操作</div>
</div>
<div id="tbody">
<%
for(int i=0;i<size;i++){
	News news = list.get(i);
	int id = news.getNews_id();
	session.setAttribute("news"+i, news);
	%>
	<div class="row_div">
		<div class="no"><%=i+1%></div>
		<div class="title"><a href="/classweb/new_detail.jsp?id=<%=id %>"><%=news.getTilte() %></a></div>
		<div class="date"><%=news.getPublish_time() %></div>
		<div class="operation">
			<input type="button" value="删除" onclick="to('news_manage_delete.jsp?id=<%=id %>')">
			<input type="button" value="编辑" onclick="to('news_manage_edit.jsp?id=<%=id %>&li=<%=i%>')">
		</div>
	</div>
	<%
}
%>
</div>
<div id="manage_button">
<input type="button" value="添加" onclick="to('news_manage_add.jsp?id=0')"/>&nbsp;
<input type="button" value="主页" onclick="to('Manage.jsp')"/>&nbsp;
<input type="button" value="返回" onclick="back()"/>
</div>
</body>
</html>