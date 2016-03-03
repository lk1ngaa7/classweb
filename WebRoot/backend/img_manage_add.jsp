<%@page import="com.classweb.model.Manager"%>
<%@page import="com.classweb.model.Album"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="../css/backend/img_manage_add.css">
<title>添加图片</title>
<script src="../js/common.js" ></script> 
</head>
<body>
<!-- if add more than one picture -->
<%
String jdg = "";
Manager user = new Manager();
try{
user = (Manager)session.getAttribute("user");
String name = user.getName();
session.removeAttribute("user");
session.setAttribute("user", user);
jdg = request.getParameter("id");
}catch(Exception e){
	response.sendRedirect("Login.jsp");
}
String href = "";
if(jdg.equals("y")){
	href = (String)session.getAttribute("img");
}
else{
	href = "输入图片链接";
}
%>
<div id="main">
	<form action="img_manage_add_database.jsp" method="post">
		<div id="one">
			<label for="link">链接：</label>
			<input id="link" name="link" type="text" value=<%=href %>>
			<input type="button" onclick="to('addimage.jsp')" value="浏览">
		</div>
		<div id="two">
			<input type="submit" value="添加" />
			<input type="button" value="返回" onclick="back()"/>
		</div>
	</form>
</div>
</body>
</html>