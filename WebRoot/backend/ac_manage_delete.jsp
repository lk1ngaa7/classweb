<%@page import="com.classweb.model.Manager"%>
<%@page import="com.classweb.dao.ActivityDao"%>
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
int id = -1;
Manager user = new Manager();
try{
	user = (Manager)session.getAttribute("user");
	String name = user.getName();
	session.removeAttribute("user");
	session.setAttribute("user", user);
	id = Integer.parseInt(request.getParameter("id"));
}catch(Exception e){
	response.sendRedirect("Login.jsp");
}
ActivityDao ad = new ActivityDao();
if(ad.deleteActivity(id)){
	response.sendRedirect("ac_manage.jsp");
}else{
	try{
	%>
	<c:redirect url="ac_manage.jsp">
	<c:param name="info" value="删除失败！！"></c:param>
	</c:redirect>
	<%}catch(Exception e){}
}
%>
</body>
</html>