<%@page import="com.classweb.dao.ActivityDao"%>
<%@page import="com.classweb.model.Activity"%>
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
request.setCharacterEncoding("utf-8");
int id = Integer.parseInt(request.getParameter("id"));
String msg = request.getParameter("msg");
String name = request.getParameter("name");
String link = request.getParameter("link");
String times = request.getParameter("time");
String content = request.getParameter("content");
java.sql.Date time = java.sql.Date.valueOf(times);
Activity activity = new Activity(id,name,time,link,content);
ActivityDao ad = new ActivityDao();
if(msg.equals("f")){//something wrong!!!
	if(ad.modifyActivity(activity)){
		response.sendRedirect("ac_manage.jsp");
	}else{
	%>
	<c:redirect url="ac_manage.jsp">
	<c:param name="info" value="操作失败！！！"></c:param>
	</c:redirect>
	<%
	}}else{
		if(ad.addActivity(activity)){
			response.sendRedirect("ac_manage.jsp");
		}else{
			%>
			<c:redirect url="ac_manage.jsp">
			<c:param name="info" value="操作失败！！！"></c:param>
			</c:redirect>
			<%
		}
}
%>
</body>
</html>