<%@page import="com.classweb.dao.AlbumDao"%>
<%@page import="com.classweb.model.Album"%>
<%@page import="com.classweb.dao.ActivityDao"%>
<%@page import="com.classweb.model.Activity"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.classweb.dao.NewsDao"%>
<%@page import="com.classweb.model.News"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>首页</title>
	
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
    <link rel="stylesheet" href="css/wish_index.css"/>
    <link rel="stylesheet" href="css/base1.css"/>
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="js/index.js"></script>
    <script type="text/javascript" src='js/wish_index.js'></script>
    

</head>
  
<body>
  <%
  try{
	  session.removeAttribute("user");
  }catch(Exception e){}
  %>
<div id="zhuye">
  	<!-- 集体照  -->
    <div id="class_photo">
    	<div id="class_slogan">
    		<p>计算机五班，</p>
    		<p>我们是一个拳头。</p>
    	</div>
    	<img alt="集体照" src="images/1.jpg">
    </div>
    <!-- 导航栏 -->
    <div id="nav">
    	<!-- 导航 -->
    	<div>
    		<ul class="ca-menu">
                    <li>
                        <a href="introduce.jsp">
                            <span class="ca-icon">1</span>
                            <div class="ca-content">
                                <h2 class="ca-main">班级简介</h2>
                                <h3 class="ca-sub">Class Profile</h3>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="new_list.jsp">
                            <span class="ca-icon">2</span>
                            <div class="ca-content">
                                <h2 class="ca-main">班级新闻</h2>
                                <h3 class="ca-sub">Class News</h3>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="album.jsp">
                            <span class="ca-icon">0</span>
                            <div class="ca-content">
                                <h2 class="ca-main">班级相册</h2>
                                <h3 class="ca-sub">Class Album</h3>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="active_list.jsp">
                            <span class="ca-icon">5</span>
                            <div class="ca-content">
                                <h2 class="ca-main">班级活动</h2>
                                <h3 class="ca-sub">Class Activity</h3>
                            </div>
                        </a>
                    </li>
                    <li id="classword_li">
                        <a href="javascript:void(0)" onclick="sendEmptyRerquest();showClassWords()">
                            <span class="ca-icon" id="heart">班</span>
                            <div class="ca-content">
                            	<div id="class_emblem">
                                	<img alt="班徽" src="images/2.jpg" width="120px" height="120px;"/>
                                </div>
                            </div>
                        </a>
                    </li>
                </ul>
    	</div>
    </div>
    
	<!--班级内容板块-->
	<div id="class_content">
		<!--班级新闻-->
		<div id = "class_new">
			<div id = "new_name">
				<a href="new_list.jsp"><h3>班级新闻</h3></a>
			</div>
			<%
			News news = new News();
			NewsDao nd = new NewsDao();
			List<News> list = new ArrayList<News>();
			list = nd.getNewsGroup();
			int size = list.size();
			for(int i=0;i<5;i++){
				size--;
				if(size<0){
					news = new News(0,"","","","",null);//""is better than null
				}else{
					news = list.get(size);
				}
				String title = news.getTilte();
				String content = news.getContent();
				if(content.length()>82){
					content = content.substring(0,82);
				}
				int id = news.getNews_id();
			%>
			<div class = "new_content">
				<span class = "new_content_title">
					<a href = "new_detail.jsp?id=<%=id %>"><%=title %></a>
				</span>
				<span class = "new_content_content">
					<a href = "new_detail.jsp?id=<%=id %>"><%=content %>...</a>
				</span>
			</div>
			<%} %>
		</div>
		<!--班级活动-->
		<div id="class_active">
			<div id = "active_name">
				<a href="active_list.jsp"><h3>班级活动</h3></a>
			</div>
			<%
			Activity activity = new Activity();
			List<Activity> list1 = new ArrayList<Activity>();
			ActivityDao ad = new ActivityDao();
			list1 = ad.getActivityGroup();
			int size1 = list1.size();
			for(int n=0;n<4;n++){
				size1--;
				if(size1<0){
					activity = new Activity(0,null,null,null,"");
				}else{
					activity = list1.get(size1);
				}
				String name = activity.getAc_name();
				String ac_content = activity.getAc_content();
				if(ac_content.length()>80){
					ac_content = ac_content.substring(0,80);
				}
				int ac_id = activity.getAc_id();
			%>
			<div class="active_content">
				<a href="active_detail.jsp?ac_id=<%=ac_id %>"><img src="<%=activity.getAc_img_href() %>" alt="图片无法正常显示"/></a>
				<div class= "active_content_words">
					<p>活动名称:<span><%=name %></span></p>
					<p>活动时间:<span><%=activity.getAc_time() %></span></p>
					<p>活动内容:<span><%=ac_content %>...</span></p>
				</div>		
			</div>
			<%} %>
		</div>
		<!--班级相册-->
		<%
		Album album = new Album();
		AlbumDao ald = new AlbumDao();
		List<Album> list2 = new ArrayList<Album>();
		list2 = ald.getAlbum();
		int size2 = list2.size();
		%>
		<div class="long floats" id="camera">
			<div id="camera_name"><!--<a href="#" class="more">更多>></a>--><h3>班级相册</h3></div>
			<div id="camera_show">
				<img src="images/index_bottom_Images/turnleft.jpg" id="turnleft"/>
				<div class="camera_in">
					<ul id="layout_ul">
					<%
					for(int j=0;j<size2;j++){
						album = list2.get(j);
					%>
						<li>
							<a href="album.jsp"><img height= "100" width= "100" src="<%=album.getImg_href() %> "alt="图片无法正常显示"></a>
						</li>
						<%} %>				
					</ul>
				</div>
			  <img src="images/index_bottom_Images/turnright.jpg" id="turnright"/>
			</div>
		  </div>
		</div>
</div>		
    <!-- 同学寄语  -->
    <div id="class_words">  <!--onclick='showClassWords()'-->
		<div id="class_words_content">
			<div id='top'>
				<span id='send'></span>
				<span id='fhsy' onclick='showClassWords()'></span>
			</div>
			<div id='main' >
			
					
			</div>
			<div id='send-form'>
				<p class='title'><span>写下你的寄语</span><a href="" id='close'></a></p>
				<form action="" name='wish'>
					<p>
						<label for="username">昵称：</label>
						<input type="text" name='username' id='username'/>
					</p>
					<p>
						<label for="content">寄语：(您还可以输入&nbsp;<span id='font-num'>50</span>&nbsp;个字)</label>
						<textarea name="content" id='content'></textarea>

						<div id='phiz'>
							<img src="images/wish_Images/phiz/zhuakuang.gif" alt="抓狂" />
							<img src="images/wish_Images/phiz/baobao.gif" alt="抱抱" />
							<img src="images/wish_Images/phiz/haixiu.gif" alt="害羞" />
							<img src="images/wish_Images/phiz/ku.gif" alt="酷" />
							<img src="images/wish_Images/phiz/xixi.gif" alt="嘻嘻" />
							<img src="images/wish_Images/phiz/taikaixin.gif" alt="太开心" />
							<img src="images/wish_Images/phiz/touxiao.gif" alt="偷笑" />
							<img src="images/wish_Images/phiz/qian.gif" alt="钱" />
							<img src="images/wish_Images/phiz/huaxin.gif" alt="花心" />
							<!--  <img src="images/wish_Images/phiz/jiyan.gif" alt="挤眼" />-->
						</div>
					</p>
					<span id='send-btn' onclick="sendRequest()"></span>
				</form>
			</div>
		</div>
    </div>    
    <!-- 字体特效  -->
	<script type="text/javascript" src="js/indexse.js"></script>
	<script type="text/javascript" src="js/index_2.js"></script>
	<script type="text/javascript" src="js/ajax.js"></script>
	
</body>
</html>