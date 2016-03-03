package com.classweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.tomcat.util.buf.Utf8Encoder;


import com.classweb.dao.MessageDao;
import com.classweb.model.Message;


public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MessageServlet(){
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//设置使用UTF-8字符集解析请求参数
		request.setCharacterEncoding("UTF-8");
		
		//获取请求的值
		String nick_name=request.getParameter("nick_name");
		String msg_content=request.getParameter("msg_content");
	
		//新建Message操作类
		MessageDao msgdao=new MessageDao();
		//新建Message对象
		Message msg=new Message();
		
		//若请求的值非空，存入数据库
		if(nick_name!=null && msg_content!=null){
			
			//把请求传回的值存到Message对象中
			msg.setNick_name(nick_name);
			msg.setMsg_content(msg_content);
					
			//初始化Message对象时间
			Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR)-1900; 
			int month = c.get(Calendar.MONTH); 
			int date = c.get(Calendar.DATE); 
			msg.setMsg_time(new Date(year,month,date));
			
			//将寄语添加到数据库
			msgdao.addMessage(msg);
			//msgdao.addMessage(msg);
		}
		List<Message> list=new ArrayList<Message>();
		list=msgdao.getMessageGroup();
		
		//设置响应类型
		response.setContentType("text/html;charset=UTF-8");
		
		//获取页面输出流
		PrintWriter out=response.getWriter();
		String html=new String();
		String html_paper=new String();
		
	/*	String info="[汉字]";
		System.out.println(info);
		info=info.replaceAll("\\[汉字\\]", "<汉字>");
		System.out.println(info);
		*/
		
		
		for(int i=0;i<list.size();i++){
			msg=list.get(i);
			int paper_num=(i%5)+1;
			String content=msg.getMsg_content();
			content=replace(content);
			
			//每个留言的html片段
			html_paper="<dl class='paper a"+paper_num+"'>"+
					"<dt>"+
						"<span class='username'>"+msg.getNick_name()+"</span>"+
						"<span class='num'>"+msg.getMsg_id()+"</span>"+
					"</dt>"+
					"<dd class='content'>"+content+"</dd>"+
					"<dd class='bottom'>"+
						"<span class='time'>"+msg.getMsg_time()+"</span>"+
						"<a href='' class='close'></a>"+
					"</dd>"+
				"</dl>";
			
			html=html+html_paper; 
		}
		
		//生成响应
		out.println(html); 
		out.flush();
		//关闭流
		/*out.close(); */
	}

	private String replace(String content) {
		// TODO Auto-generated method stub
		
		//将表情字符替换成图片标签显示
		content=content.replaceAll("\\[抓狂\\]", "<img src='images/wish_Images/phiz/zhuakuang.gif'/>");
		content=content.replaceAll("\\[抱抱\\]", "<img src='images/wish_Images/phiz/baobao.gif'/>");
		content=content.replaceAll("\\[害羞\\]", "<img src='images/wish_Images/phiz/haixiu.gif'/>");
		content=content.replaceAll("\\[酷\\]", "<img src='images/wish_Images/phiz/ku.gif'/>");
		content=content.replaceAll("\\[嘻嘻\\]", "<img src='images/wish_Images/phiz/xixi.gif'/>");
		content=content.replaceAll("\\[太开心\\]", "<img src='images/wish_Images/phiz/taikaixin.gif'/>");
		content=content.replaceAll("\\[偷笑\\]", "<img src='images/wish_Images/phiz/touxiao.gif'/>");
		content=content.replaceAll("\\[钱\\]", "<img src='images/wish_Images/phiz/qian.gif'/>");
		content=content.replaceAll("\\[花心\\]", "<img src='images/wish_Images/phiz/huaxin.gif'/>");
		content=content.replaceAll("\\[挤眼\\]", "<img src='images/wish_Images/phiz/jiyan.gif'/>");
		
		//将替换后的内容返回
		return content;
	}
}
