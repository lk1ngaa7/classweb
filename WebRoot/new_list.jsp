<%@page import="java.sql.Timestamp"%>
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
<title>班级新闻</title>
<link rel="stylesheet" type="text/css" href="css/new_list.css"/>
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
        <div id="content">
        	
        <%
			News news = new News();
			NewsDao nd = new NewsDao();
			List<News> list = new ArrayList<News>();
			list = nd.getNewsGroup();
			int size = list.size();
			Timestamp ts = new Timestamp(0);
			List<News> list1 = new ArrayList<News>();
			List<News> list2 = new ArrayList<News>();
			List<News> list3 = new ArrayList<News>();
			int n = 0;
			int days[] = new int[size+1];
			int year[] = new int[4];int month[] = new int[4];int day[] = new int[4];
			//use method like index
			//show rencently 3 days' news
			List<News> list4 = new ArrayList<News>();
			for(int i=0;i<3;){
				size--;
				if(size<0){
					if(i==0){
						list1 = list4;
						list2 = null;
						list3 = null;
						i = 3;
					}else if(i==1){
						list2 = list4;
						list3 = null;
						i = 3;
					}else{
						list3 = list4;
						i = 3;
					}
				}else
				{
					news = new News();
					news = list.get(size);
					int years = news.getPublish_time().getYear()+1900;
					int months = news.getPublish_time().getMonth()+1;
					int dayss = news.getPublish_time().getDate();
					days[n] = years +months +dayss;
					if(n==0){
						list4.add(news);
					}else{
						if(days[n]==days[n-1]){
							list4.add(news);
						}else{
							if(i==0){
								list1 = list4;
							}else if(i==1){
								list2 = list4;
							}else{
								list3 = list4;
							}
							list4 = new ArrayList<News>();
							list4.add(news);
							i++;
						}
					}
					n++;
				}
			}
			for(int i=0;i<3;){
				list4 = new ArrayList<News>();
				int xinhao = 0;
				if(i==0){
					if(list1==null){
						xinhao = 1;
					}else{
					list4 = list1;}
				}else if(i==1){
					if(list2==null){
						xinhao = 1;
					}else{
						list4 = list2;}
				}else{
					if(list3==null){
						xinhao = 1;
					}else{
						list4 = list3;}
				}
				if(xinhao==0){
				int length = list4.size();
				news = new News();
				news = list4.get(length-1);
				year[i] = news.getPublish_time().getYear()+1900;
				month[i] = news.getPublish_time().getMonth()+1;
				day[i] = news.getPublish_time().getDate();
				%>
			 <div class="timeline_separate">
            	<div class="timeline_date"><%=year[i] %>-<%=month[i] %>-<%=day[i] %></div>
                <div class="timeline_arrow"></div>
          		</div>
            <div class="timeline_list">
                <ul class="unorderlist">
				<%
				for(int j=0;j<length;j++){
					news = new News();
					ts = new Timestamp(0);
					news = list4.get(j);
					int hour = 0;
					int minutes = 0;
					ts = news.getPublish_time();
					hour = ts.getHours();
					minutes = ts.getMinutes();
					String news_content = news.getContent();
					if(news_content.length()>200){
						news_content = news_content.substring(0,200);
					}
		%>
				
                    <li class="list">
                        <div class="time"><%=hour %>:<%=minutes %></div>
                        <div class="new">
                            <div class="new_arrow"></div>
                            <a href="new_detail.jsp?id=<%=news.getNews_id() %>" class="new_title"><%=news.getTilte() %></a>
                            <!-- 查看不跳进详细信息页面 -->
                            <div class="new_info"><%=news_content %></div>
                            <a href="new_detail.jsp?id=<%=news.getNews_id() %>" class="new_detail">点击查看</a>
                        </div>
                    </li>
                 
            <%
				if(j==length-1){
					i++;
					%>
					</ul>
        		</div>
					<%
					}
				}}else{
					i++;
				}
				} %>
           		
        </div>
        
	</div>
</body>
</html>