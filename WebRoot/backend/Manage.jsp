<%@page import="com.classweb.model.Manager"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="../css/backend/manage.css">
<title>后台管理界面</title>
</head>
<body>
<%
Manager user = new Manager();
String name = "";
try{user = (Manager)session.getAttribute("user");//如果直接进来会产生manage这个session么？
name = user.getName();
session.removeAttribute("user");
session.setAttribute("user", user);
}catch(Exception e){
	response.sendRedirect("Login.jsp");
}
%>

<div id="head">欢迎<span><%=name%></span>使用后台管理系统</div>
<div id="body">
<ol id="main">
<li><a href="user_manage.jsp">用户管理</a><br/>
<li><a href="img_manage.jsp">相册管理</a><br/>
<li><a href="news_manage.jsp">新闻管理</a><br/>
<li><a href="ac_manage.jsp">活动管理</a><br/><!-- 管理页面要实现的一般功能：增、删、改 -->
<li><a href="../index.jsp">退出</a>
</ol>
</div>
</body>
</html>