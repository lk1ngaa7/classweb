package com.classweb.util.fileutil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class CopyToProject {

	/**
	 * ��ѡ�е��ļ����Ƶ���Ŀ�ļ�
	 * @param url :Դ�ļ���ȫ·���������ļ����ͺ�׺����
	 * @param curl ��Ŀ���ļ���·��Ŀ¼
	 * @return ���سɹ�����״̬��Ϣ
	 */
	@SuppressWarnings("resource")
	public boolean copyFile(String url,String curl){
		
		File file=new File(url);
		FileInputStream fis=null;
		@SuppressWarnings("unused")
		OutputStreamWriter osw=null;
															/*curl=System.getProperty("user.dir")+ "/pictures/ac_album/";*/
															/*curl="D:/Javaweb/workspace/classweb/pictures/ac_album/";*/
		String purl=curl + file.getName();
		File cfile=new File(purl);
															/*curl="D:\\Javaweb\\workspace\\classweb\\pictures\\ac_album\\";*/
															/*String purl=curl +"\\" + file.getName()*/
		try {
			fis=new FileInputStream(file);
			FileOutputStream fos=new FileOutputStream(cfile);
			int each=512;
			byte[] buffer =new byte[each];
			while((fis.read(buffer, 0, each)!=-1)){
				fos.write(buffer, 0, each);
			}
			fos.close();
			fis.available();		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(cfile.length()!=0){
			return true;
		}
		return false;
	}
}
