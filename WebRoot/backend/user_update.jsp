<%@page import="com.classweb.dao.ManagerDao"%>
<%@page import="com.classweb.model.Manager"%>
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
request.setCharacterEncoding("utf-8");
Manager user = new Manager();
ManagerDao md = new ManagerDao();
user.setName(request.getParameter("user_name"));
user.setPassword(request.getParameter("password"));
md.update(user);
session.setAttribute("user", user);
response.sendRedirect("Manage.jsp");
%>
</body>
</html>