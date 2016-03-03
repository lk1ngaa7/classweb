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
		
		//新建选择文件的操作类
		TxtChoose txtc=new TxtChoose();
		File file;
		//新建文件，指向源文件
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
			//新建输入流
			BufferedReader br=new BufferedReader(new FileReader(file));
			
			//开始读取文件内容
			while((str=br.readLine())!=null){
				
				content=content+str+"<br/>";
			}
			//关闭输入流
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
		
		//新建选择文件的操作类
		ImageChoose imgc=new ImageChoose();

		//仙剑复制文件到项目的操作类
		CopyToProject copy=new CopyToProject();
		
		//设置目的目录
		String curl=url + "/photos/" + loc + "/";
		//这里改成数组
		ImageFileFilter iff = new ImageFileFilter();
		String path;
		List<String> list = new ArrayList<String>();

		String status = "";
		try{
			list = imgc.getImagePath();
			int i = list.size();
			for(int n=0;n<i;n++){
				path = list.get(n);
				//新建文件，指向源文件
				File file=new File(path);
				
				if(iff.accept(file)){

					String name = file.getName();
					
					//将文件复制到项目，返回状态值flag
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
