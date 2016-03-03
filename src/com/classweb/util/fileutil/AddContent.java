package com.classweb.util.fileutil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//import javax.servlet.ServletContext;


public class AddContent {
	
	/*public static void main(String[] args) {
		String file = System.getProperty("user.dir");
		System.out.println(file);
	}*/
	
	public String addTxt(){
		
		//�½�ѡ���ļ��Ĳ�����
		TxtChoose txtc=new TxtChoose();
		File file;
		//�½��ļ���ָ��Դ�ļ�
		try{
		file=new File(txtc.getTxtPath());}catch(Exception e){
			file = new File("");
		}
		
		TxtFileFilter tff = new TxtFileFilter();
		if(tff.accept(file)){}else{
			return "failed!!";
		}
		
		String content=new String();
		String str=new String();
		try {
			//�½�������
			BufferedReader br=new BufferedReader(new FileReader(file));
			
			//��ʼ��ȡ�ļ�����
			while((str=br.readLine())!=null){
				
				content=content+str+"<br/>";
			}
			//�ر�������
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return content;
	}
	
	public String addImg(String url,String loc){
		
		//�½�ѡ���ļ��Ĳ�����
		ImageChoose imgc=new ImageChoose();

		//�ɽ������ļ�����Ŀ�Ĳ�����
		CopyToProject copy=new CopyToProject();
		
		//����Ŀ��Ŀ¼
		String curl=url + "/photos/" + loc + "/";
		//����ĳ�����
		ImageFileFilter iff = new ImageFileFilter();
		String path;
		List<String> list = new ArrayList<String>();

		String status = "";
		try{
			list = imgc.getImagePath();
			int i = list.size();
			for(int n=0;n<i;n++){
				path = list.get(n);
				//�½��ļ���ָ��Դ�ļ�
				File file=new File(path);
				
				if(iff.accept(file)){

					String name = file.getName();
					
					//���ļ����Ƶ���Ŀ������״ֵ̬flag
					boolean flag=copy.copyFile(path, curl);
					
					if(!flag){
						return "failed!!";
					}

					status = status + ";" + "images/photos/" + loc + "/" + name;

				}else{
					status = "failed!!";
				}
			}
		}catch(Exception e){
			status = "failed!!";
		}
		
		
		return status;
	}

}
