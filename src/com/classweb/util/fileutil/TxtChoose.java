package com.classweb.util.fileutil;

import java.io.File;

import javax.swing.JFileChooser;

public class TxtChoose {
	
	
	public String getTxtPath(){
		File file=null;
		
		// �����ļ�ѡ������ 
		JFileChooser fc=new JFileChooser();
		
		//�趨�ļ�ѡ������
		fc.addChoosableFileFilter(new TxtFileFilter());
		fc.setAcceptAllFileFilterUsed(false);
		fc.setDialogTitle("ѡ���ı��ĵ�");
		
		//��ʾ�ļ�ѡ�����ѡ��󽫽�����浽returnVal������ 
		@SuppressWarnings("unused")
		int returnVal = fc.showOpenDialog(fc);
		file = fc.getSelectedFile();
		return file.getPath();
	}
}
