<%@page import="com.classweb.model.Manager"%>
<%@page import="com.classweb.dao.NewsDao"%>
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
//每个子页面都加一个session以保证登录期间能对所有页面进行访问，以及保证session不会自动消除，当登陆后超过30分钟没有操作，session自动销毁，用户就得重新登陆。
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
NewsDao nd = new NewsDao();
if(nd.deleteNews(id)){
	response.sendRedirect("news_manage.jsp");
}else{
	try{
	%>
	<c:redirect url="news_manage.jsp">
	<c:param name="info" value="删除失败！！"></c:param>
	</c:redirect>
	<%}catch(Exception e){
	}
}
%>
</body>
</html>