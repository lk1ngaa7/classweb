<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.classweb.dao.AlbumDao"%>
<%@page import="com.classweb.model.Album"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>班级相册</title>
<link rel="stylesheet" type="text/css" href="css/album.css"/>
<link rel="stylesheet" type="text/css" href="css/base2.css"/>

</head>

<body>
	<!-- 导航栏 -->
	<%@include file="nav.jspf"%>
    
    <div id="containter">
    	<!-- 头部 -->
    	<div id="head">
    		<div id="head_title">班级相册</div>
        	<div id="head_message">
            	计算机五班，我们是一个拳头。
            </div>
        </div>
        <!-- 内容 -->
        <%
		Album album = new Album();
		AlbumDao ald = new AlbumDao();
		List<Album> list2 = new ArrayList<Album>();
		list2 = ald.getAlbum();
		int size2 = list2.size();
		%>
        <div id="content">
        	<div>
                <div id="border"></div>
                <div id="screen" style="background: rgba(200, 200, 200,0) none repeat scroll 0%; position: absolute; width: 1000px; height: 1500px; -moz-background-clip: -moz-initial; -moz-background-origin: -moz-initial; -moz-background-inline-policy: -moz-initial;">
                    <%
					for(int j=0;j<size2;j++){
						album = list2.get(j);
					%>
                    <span><img src="<%=album.getImg_href() %>" alt=""></span>
                    <%} %>
                </div>
            </div>
            <script type="text/javascript">
            	var picNum = <%=size2 %>;
			</script>
			<script type="text/javascript" src="js/album.js"></script>
            <script type="text/javascript"><!--
            // starter
            load();
            //-->
            </script>
        </div>
	</div>
</body>
</html>