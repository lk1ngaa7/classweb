<%@page import="com.classweb.dao.NewsDao"%>
<%@page import="com.classweb.model.News"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>班级新闻</title>
<link rel="stylesheet" type="text/css" href="css/new_detail.css"/>
<link rel="stylesheet" type="text/css" href="css/base2.css"/>

</head>

<body>
	<!-- 导航栏 -->
	<%@include file="nav.jspf"%>
    
    <div id="containter">
    	<!-- 头部 -->
    	<div id="head">
    		<div id="head_title">班级新闻</div>
        	<div id="head_message">
            	计算机五班，我们是一个拳头。
            </div>
        </div>
        <!-- 内容 -->
        <%
        int id = Integer.parseInt(request.getParameter("id"));
        News news = new News();
        NewsDao nd = new NewsDao();
        news = nd.getNewsById(id);
        %>
        <div id="content">
        	<div id="new_detail_title"><%=news.getTilte() %></div>
            <div id="new_detail_time"><%=news.getPublish_time() %></div>
            <div id="new_detail_content">
            <%=news.getContent() %>		
			</div>
        </div>
	</div>
</body>
</html>