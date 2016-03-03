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
		
		//����ʹ��UTF-8�ַ��������������
		request.setCharacterEncoding("UTF-8");
		
		//��ȡ�����ֵ
		String nick_name=request.getParameter("nick_name");
		String msg_content=request.getParameter("msg_content");
	
		//�½�Message������
		MessageDao msgdao=new MessageDao();
		//�½�Message����
		Message msg=new Message();
		
		//�������ֵ�ǿգ��������ݿ�
		if(nick_name!=null && msg_content!=null){
			
			//�����󴫻ص�ֵ�浽Message������
			msg.setNick_name(nick_name);
			msg.setMsg_content(msg_content);
					
			//��ʼ��Message����ʱ��
			Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR)-1900; 
			int month = c.get(Calendar.MONTH); 
			int date = c.get(Calendar.DATE); 
			msg.setMsg_time(new Date(year,month,date));
			
			//��������ӵ����ݿ�
			msgdao.addMessage(msg);
			//msgdao.addMessage(msg);
		}
		List<Message> list=new ArrayList<Message>();
		list=msgdao.getMessageGroup();
		
		//������Ӧ����
		response.setContentType("text/html;charset=UTF-8");
		
		//��ȡҳ�������
		PrintWriter out=response.getWriter();
		String html=new String();
		String html_paper=new String();
		
	/*	String info="[����]";
		System.out.println(info);
		info=info.replaceAll("\\[����\\]", "<����>");
		System.out.println(info);
		*/
		
		
		for(int i=0;i<list.size();i++){
			msg=list.get(i);
			int paper_num=(i%5)+1;
			String content=msg.getMsg_content();
			content=replace(content);
			
			//ÿ�����Ե�htmlƬ��
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
		
		//������Ӧ
		out.println(html); 
		out.flush();
		//�ر���
		/*out.close(); */
	}

	private String replace(String content) {
		// TODO Auto-generated method stub
		
		//�������ַ��滻��ͼƬ��ǩ��ʾ
		content=content.replaceAll("\\[ץ��\\]", "<img src='images/wish_Images/phiz/zhuakuang.gif'/>");
		content=content.replaceAll("\\[����\\]", "<img src='images/wish_Images/phiz/baobao.gif'/>");
		content=content.replaceAll("\\[����\\]", "<img src='images/wish_Images/phiz/haixiu.gif'/>");
		content=content.replaceAll("\\[��\\]", "<img src='images/wish_Images/phiz/ku.gif'/>");
		content=content.replaceAll("\\[����\\]", "<img src='images/wish_Images/phiz/xixi.gif'/>");
		content=content.replaceAll("\\[̫����\\]", "<img src='images/wish_Images/phiz/taikaixin.gif'/>");
		content=content.replaceAll("\\[͵Ц\\]", "<img src='images/wish_Images/phiz/touxiao.gif'/>");
		content=content.replaceAll("\\[Ǯ\\]", "<img src='images/wish_Images/phiz/qian.gif'/>");
		content=content.replaceAll("\\[����\\]", "<img src='images/wish_Images/phiz/huaxin.gif'/>");
		content=content.replaceAll("\\[����\\]", "<img src='images/wish_Images/phiz/jiyan.gif'/>");
		
		//���滻������ݷ���
		return content;
	}
}
