<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
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
//需要将addPicture的参数改为List类型
List<Album> list = new ArrayList<Album>();
String links = request.getParameter("link");
String[] link = links.split(";");
Album album = null;
AlbumDao ad = new AlbumDao();
int i = 0;
for(String str:link){
	if(i==0){
		i++;
	}else{
		album = new Album();
		album.setImg_href(str);
		list.add(album);
	}
}
if(ad.addPicture(list)){
	response.sendRedirect("img_manage.jsp");
}else{
%>
	<c:redirect url="img_manage.jsp">
	<c:param name="info" value="操作失败！！！"></c:param>
	</c:redirect>
<%} %>
</body>
</html>