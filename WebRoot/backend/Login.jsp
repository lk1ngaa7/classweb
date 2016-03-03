<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>管理员登录</title>
<link href="../css/style.css" rel="stylesheet" type="text/css"/>
<script src="../js/common.js" ></script>
</head>
<body  bgcolor="#c5d9ed">
<%
try{
	session.removeAttribute("user");
}catch(Exception e){}
%>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<div align="center">
	<font size=6>欢迎使用后台管理系统</font>
	</div>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
<div  align="center">
<form action="LoginJudge.jsp" method="post">
	用户姓名：<input name="user" type="text" style="width:100px"/><br/><br/>
	用户密码：<input name="pwd" type="password" style="width:100px"/><br/><br/><br/>
  <input type="submit" value="登陆"  style="width:80px" />
<input type="reset" value="重置" style="width:80px" />
</form>
 ${param.info }
</div>
</body>
</html>