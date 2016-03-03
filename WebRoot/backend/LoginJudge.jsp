<%@page import="com.classweb.model.Manager"%>
<%@page import="com.classweb.dao.ManagerDao"%>
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
ManagerDao md = new ManagerDao();
Manager user = new Manager();
user.setName(request.getParameter("user"));
user.setPassword(request.getParameter("pwd"));
session.setAttribute("user", user);
if(md.login(user)){
	response.sendRedirect("Manage.jsp");
}else{
	%>
	<c:redirect url="Login.jsp">
	<c:param name="info" value="password or username wrong!!!" ></c:param>
	</c:redirect>
	<%
}
%>
</body>
</html>