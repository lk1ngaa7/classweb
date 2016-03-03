<%@page import="com.classweb.model.Manager"%>
<%@page import="com.classweb.model.News"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="../css/backend/ac_news_manage_save.css">
<script src="../js/common.js" ></script>
<script type="text/javascript" src="../ckeditor/ckeditor.js"></script>
<title>编辑新闻</title>
</head>
<body>
<%
int id = -1;
String i = "";
News news = new News();
Manager user = new Manager();
try{
	user = (Manager)session.getAttribute("user");
	String name = user.getName();
	session.removeAttribute("user");
	session.setAttribute("user", user);
	id = Integer.parseInt(request.getParameter("id"));
	i = request.getParameter("li");
	news = (News)session.getAttribute("news"+i);
	session.removeAttribute("news"+i);
}catch(Exception e){
	response.sendRedirect("Login.jsp");
}
String f = "f";
String href = "getImage.jsp?id=news&sid="+id+"&type=edit&num="+i;
%>
<div id="main">
<form action="news_manage_add_database.jsp?id=<%=id %>&msg=<%=f %>" method="post">
	<div id="one">
		<label for="title">标题：</label>
		<input id="title" name="title" type="text" value=<%=news.getTilte() %>><br/>
	</div>
	<div id="two">
		<label for="author">作者：</label>
		<input id="author" name="author" type="text" value=<%=news.getPublisher() %>><br/>
	</div>
	<!-- 新闻无图片 
	<div id="three">
		<label for="link">链接：</label>
		<input id="link" name="link" type="text" value=<%--=news.getImg_href() %>>
		<input type="submit" value="浏览" onclick="form.action='<%=href --%>'"><br/><br/>
	</div>-->
	<div id="four">
		<label for="content">内容：</label>
		<textarea id="content" class="ckeditor" name="content" cols="50" rows="15"><%=news.getContent() %></textarea>
	</div>
	<!-- auto get time -->
	<div id="five">
		<input type="submit" value="保存" />
		<input type="button" value="返回" onclick="back()"/>
	</div>
</form>
</div>
</body>
</html>