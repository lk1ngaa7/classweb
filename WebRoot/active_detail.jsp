<%@page import="com.classweb.dao.ActivityDao"%>
<%@page import="com.classweb.model.Activity"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>活动详情</title>
<link rel="stylesheet" type="text/css" href="css/new_detail.css"/>
<link rel="stylesheet" type="text/css" href="css/base2.css"/>
</head>

<body>
	<!-- 导航栏 -->
	<%@include file="nav.jspf"%>
    
    <div id="containter">
    	<!-- 头部 -->
    	<div id="head">
    		<div id="head_title">班级活动</div>
        	<div id="head_message">
            	计算机五班，我们是一个拳头。
            </div>
        </div>
        <!-- 内容 -->
        <%
        Activity activity = new Activity();
        int id = Integer.parseInt(request.getParameter("ac_id"));
        ActivityDao ad = new ActivityDao();
        activity = ad.getActivity(id);
        %>
        <div id="content">
        	<div id="new_detail_title"><%=activity.getAc_name() %></div>
            <div id="new_detail_time"><%=activity.getAc_time() %></div>
            <div id="new_detail_content">
            <%if(!activity.getAc_img_href().equals("输入图片链接")){%>
            <p style="text-align: center;">
            	<a href=<%=activity.getAc_img_href() %> target="_blank"><img src=<%=activity.getAc_img_href() %> border="0" width=500 height=350 /></a><br>
            </p>
            <%}%>
            <p><%=activity.getAc_content() %></p>
			</div>
        </div>
	</div>
</body>
</html>