<%@page import="com.classweb.model.Manager"%>
<%@page import="com.classweb.dao.AlbumDao"%>
<%@page import="com.classweb.model.Album"%>
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
String id = "";
Album album = new Album();
Manager user = new Manager();
try{
	user = (Manager)session.getAttribute("user");
	String name = user.getName();
	session.removeAttribute("user");
	session.setAttribute("user", user);
	id = request.getParameter("id");
	album = (Album)session.getAttribute("album"+id);
	session.removeAttribute("album"+id);
}catch(Exception e){
	response.sendRedirect("Login.jsp");
}
AlbumDao ad = new AlbumDao();
if(ad.deletePicture(album)){
	response.sendRedirect("img_manage.jsp");
}else{
	try{
%>
	<c:redirect url="img_manage.jsp">
	<c:param name="info" value="删除失败！！！"></c:param>
	</c:redirect>
<%}catch(Exception e){} }%>
</body>
</html>