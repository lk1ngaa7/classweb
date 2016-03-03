<%@page import="com.classweb.model.Manager"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="../css/backend/user_manage.css">
<title>用户管理</title>
<script src="../js/common.js" ></script>
</head>
<body>
<%
Manager user = new Manager();
String name = "";
String password = "";
try{
user = (Manager)session.getAttribute("user");
name = user.getName();
password = user.getPassword();
session.removeAttribute("user");
session.setAttribute("user", user);
}catch(Exception e){
	response.sendRedirect("Login.jsp");
}
%>
<div id="main">
<form action="user_update.jsp" method="post">
	<div id="one">
		<label for="username">用户名:</label>
		<input id="username" type="text" name="user_name" value=<%=name%>>
	</div>
	<div id="two">
		<label for="password">密　码:</label>
		<input id="password" type="text" name="password" value=<%=password%>>
	</div>
	<div id="three">
		<input type="submit" value="修改"/>
		<input type="button" value="取消" onclick="back()"/>
	</div>
</form>
</div>
</body>
</html>