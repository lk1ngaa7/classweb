<%@page import="com.classweb.model.Manager"%>
<%@page import="com.classweb.util.fileutil.AddContent"%>
<%@page import="com.classweb.model.Activity"%>
<%@page import="com.classweb.model.News"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>添加活动</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="../css/backend/ac_news_manage_save.css">
<link rel="stylesheet" type="text/css" href="../timepicker/css/jquery-ui.css" />
<style type="text/css">
	.ui-datepicker .ui-widget-header { margin-bottom: 8px; font-size:80%;}
	.ui-datepicker dl { text-align: left; }
	.ui-datepicker dl dt { height: 25px; margin-bottom: -25px; }
	.ui-datepicker dl dd { margin: 0 10px 10px 65px; }
	.ui-datepicker td { font-size: 90%; }
</style>

<script src="../js/common.js" ></script>
<script type="text/javascript" src="../ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="../js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="../timepicker/js/jquery-ui.js"></script>
<script type="text/javascript" src="../timepicker/js/jquery-ui-slide.min.js"></script>
<script type="text/javascript" src="../timepicker/js/jquery-ui-timepicker-addon.js"></script>
<script type="text/javascript">
	$(function(){
		$('#time').datepicker();
	});
</script>
</head>
<body>
<%
int id = 0;
String t = "t";
String jdg = "";
Manager user = new Manager();
try{
user = (Manager)session.getAttribute("user");
String name = user.getName();
session.removeAttribute("user");
session.setAttribute("user", user);
jdg = request.getParameter("id");
}catch(Exception e){
	response.sendRedirect("Login.jsp");
}
if(jdg.equals("y_news")){
	%>
	<div align="center"><font size=4 color="red">非常抱歉，网页出错了！！！</font></div>
	<%
}else if(jdg.equals("y_ac")){
	Activity activity = (Activity)session.getAttribute("ac_button");
	%>
	<div id="main">
	<form name="form" action="ac_manage_add_database.jsp?id=<%=id %>&msg=<%=t %>" method="post">
		<div id="one">
			<label for="name">活动名称：</label>
			<input id="name" name="name" type="text" value=<%=activity.getAc_name() %>><br/>
		</div>
		<div id="two">
			<label for="link">图片链接：</label>
			<input id="link" name="link" type="text" value=<%=activity.getAc_img_href() %>>
			<input type="submit" value="浏览" onclick="form.action'getImage.jsp?id=ac&type=edit'"/><br/>
		</div>
		<div id="three">
			<label for="time">活动时间：</label>
			<input id="time" name="time" type="text" value=<%=activity.getAc_time() %>><br/><br/>
		</div>
		
		<!-- 活动简介：<textarea cols="50" rows="3"></textarea><br/> -->
		<div id="four">
			<label for="content">活动内容：</label>
			<textarea id="content" class="ckeditor" name="content"><%=activity.getAc_content() %></textarea>
			<!-- 加入ckeditor，不需要此项  
			<div id="import_div">
				<label for="import">导入TXT文件</label>
				<input id="import" type="submit" value="浏览" onclick="form.action='getText.jsp?id=ac'"><br/>
			</div>-->
		</div>
	
		<div id="five">
			<input type="submit" value="添加" />
			<input type="button" value="返回" onclick="back()"/>
		</div>
	</form>
	<div align="center"><font size=3 color="red"><b>时间请以yyyy-mm-dd的格式输入</b></font></div>
	</div>
	<%
}else{
%>
<div id="main">
<form name="form" action="ac_manage_add_database.jsp?id=<%=id %>&msg=<%=t %>" method="post">
	<div id="one">
		<label for="name">活动名称：</label>
		<input id="name" name="name" type="text" value=""/><br/>
	</div>
	<div id="two">
		<label for="link">图片链接：</label>
		<input id="link" name="link" type="text" value="输入图片链接">
		<input type="submit" value="浏览" onclick="form.action='getImage.jsp?id=ac'"/><br/>
	</div>
	<div id="three">
		<label for="time">活动时间：</label>
		<input id="time" name="time" type="text"/><br/><br/>
	</div>
	<!-- 活动简介：<textarea cols="50" rows="3"></textarea><br/> -->
	<div id="four">
		<label for="content">活动内容：</label>
		<textarea id="content" class="ckeditor" name="content"></textarea>
		<!-- 加入ckeditor，不需要此项  
		<div id="import_div">
			<label for="import">导入TXT文件</label>
			<input id="import" type="submit" value="浏览" onclick="form.action='getText.jsp?id=ac'"><br/>
		</div>-->
	</div>
	<div id="five">
		<input type="submit" value="添加" />
		<input type="button" value="返回" onclick="back()"/>
	</div>
</form>
<!--  
<div align="center"><font size=3 color="red"><b>时间请以yyyy-mm-dd的格式输入</b></font></div>-->
</div>
<%} %>
</body>
</html>