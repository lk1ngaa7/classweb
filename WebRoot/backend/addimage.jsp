<%@page import="com.classweb.model.Album"%>
<%@page import="com.classweb.util.fileutil.AddContent"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%
AddContent act = new AddContent();
String url = getServletContext().getRealPath("/images");
String imgs = act.addImg(url,"album");
session.setAttribute("img", imgs);
response.sendRedirect("img_manage_add.jsp?id=y");
%>
</body>
</html>