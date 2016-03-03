<%@page import="com.classweb.model.Manager"%>
<%@page import="com.classweb.model.News"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="../css/backend/ac_news_manage_save.css">
<title>添加新闻</title>
<script src="../js/common.js" ></script>
<script type="text/javascript" src="../ckeditor/ckeditor.js"></script>
</head>
<body>
<%
int id = 0;
String t = "t";
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
if(jdg.equals("y_news")){
	News news = (News)session.getAttribute("news_button");
	%>
	<div id="main">
	<form name="form" action="news_manage_add_database.jsp?id=<%=id %>&msg=<%=t %>" method="post">
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
			<input id="link" name="link" type="text" value=<%--=news.getImg_href() --%>>
			<input type="submit" value="浏览" onclick="form.action='getImage.jsp?id=news'"><br/><br/>
		</div>-->
	
		<!-- 概要：<textarea cols="50" rows="3"></textarea><br/> -->
		<div id="four">
			<label for="content">内容：</label>
			<textarea id="content" class="ckeditor" name="content" cols="50" rows="15"><%=news.getContent() %></textarea>
			<!-- 加入ckeditor，不需要此项  
			<div id="import_div">
				<label for="import">导入TXT文件</label>
				<input id="import" type="submit" value="浏览" onclick="form.action='getText.jsp?id=news'"><br/>
			</div>-->
		</div>
		
		<!-- auto get time -->
		<div id="five">
			<input type="submit" value="添加" />
			<input type="button" value="返回" onclick="back()"/>
		</div>
	</form>
	</div>
	<%
}else if(jdg.equals("y_ac")){
	%>
	<div align="center"><font size=4 color="red">非常抱歉，网页出错了！！！</font></div>
	<%
}else{
%>
<div id="main">
<form name="form" action="news_manage_add_database.jsp?id=<%=id %>&msg=<%=t %>" method="post">
	<div id="one">
		<label for="title">标题：</label>
		<input id="title" name="title" type="text" value=""/><br/>
	</div>
	<div id="two">
		<label for="author">作者：</label>
		<input id="author" name="author" type="text" value=""><br/>
	</div>
	<!-- 新闻无图片 
	<div id="three">
		<label for="link">链接：</label>
		<input id="link" name="link" type="text" value="输入图片链接"/>
		<input type="submit" value="浏览" onclick="form.action='getImage.jsp?id=news'"><br/><br/>
	</div>-->
	
	<!-- 概要：<textarea cols="50" rows="3"></textarea><br/> -->
	<div id="four">
		<label for="content">内容：</label>
		<textarea id="content" class="ckeditor" name="content" cols="50" rows="15"></textarea>
		<!-- 加入ckeditor，不需要此项  
		<div id="import_div">
			<label for="import">导入TXT文件</label>
			<input id="import" type="submit" value="浏览" onclick="form.action='getText.jsp?id=news'"><br/>
		</div>-->
	</div>
	
	<!-- auto get time -->
	<div id="five">
		<input type="submit" value="添加" />
		<input type="button" value="返回" onclick="back()"/>
	</div>
</form>
</div>
<%} %>
</body>
</html>