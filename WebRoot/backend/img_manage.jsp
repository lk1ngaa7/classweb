<%@page import="com.classweb.model.Manager"%>
<%@page import="com.classweb.model.Album"%>
<%@page import="java.util.List"%>
<%@page import="com.classweb.dao.AlbumDao"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="../css/backend/img_manage.css">
<title>相册管理</title>
<script src="../js/common.js" ></script>
</head>
<body>
<!-- show all links(loop) -->
<!-- link --><!-- delete -->
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
AlbumDao ad = new AlbumDao();
List<Album> list = ad.getAlbum();
int size = list.size();
%>
<div id="head">相册管理</div>
${param.info}<br/>

<div>
<%
for(int i=0;i<size;i++){
	Album album = list.get(i);
	session.setAttribute("album"+i, album);
	String src = "../" + album.getImg_href();
	%><div class="img_div">
	<img src="<%=src %>" width=160 height=160 alt="Something wrong!!!"/>
	<input type="button" value="删除" onclick="to('img_manage_delete.jsp?id=<%=i %>')">
	<!-- 编辑可以不要，也没什么可以编辑的 --></div>
	<%
}
%>
</div>
<div id="manage_button">
<input type="button" value="新增" onclick="to('img_manage_add.jsp?id=n')"/>&nbsp;
<input type="button" value="主页" onclick="to('Manage.jsp')"/>&nbsp;
<input type="button" value="返回" onclick="back()"/>
</div>
</body>
</html>