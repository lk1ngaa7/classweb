<%@page import="com.classweb.dao.ActivityDao"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.classweb.model.Activity"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>班级活动</title>
<link rel="stylesheet" type="text/css" href="css/active_list.css"/>
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
        <div id="content">
        	<%
            Activity activity = new Activity();
			List<Activity> list1 = new ArrayList<Activity>();
			ActivityDao ad = new ActivityDao();
			list1 = ad.getActivityGroup();
			int size1 = list1.size();
				%>
        	<ul class="unorderlist">
        	<%
        	for(int n=size1-1;n>=0;n--){
				activity = list1.get(n);
				String name = activity.getAc_name();
				String ac_content = activity.getAc_content();
				if(ac_content.length()>150){
					ac_content = ac_content.substring(0,150);
				}
				int ac_id = activity.getAc_id();
        	%>
            	<li class="list">
                	<!--<div class="time">19:24</div>-->
                	<div class="new">
                    	<div class="new_arrow">
						<img src="images/sgz1.png" />
						<%if(!activity.getAc_img_href().equals("输入图片链接")){%>
						<a href="active_detail.jsp?ac_id=<%=ac_id %>"><img src="<%=activity.getAc_img_href() %>" /></a>
						<%}%>
						</div>
                    	<a href="active_detail.jsp?ac_id=<%=ac_id %>" class="new_title"><%=name %></a>
                        
                        <div class="new_info"><%=ac_content %>...</div>
                        <a href="active_detail.jsp?ac_id=<%=ac_id %>" class="new_detail">点击查看</a>
                    </div>
                </li>
                <%} %>
            </ul>
        </div>
	</div>
</body>
</html>