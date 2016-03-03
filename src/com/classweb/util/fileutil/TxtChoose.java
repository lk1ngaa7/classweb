package com.classweb.util.fileutil;

import java.io.File;

import javax.swing.JFileChooser;

public class TxtChoose {
	
	
	public String getTxtPath(){
		File file=null;
		
		// 建立文件选择框对象 
		JFileChooser fc=new JFileChooser();
		
		//设定文件选择框标题
		fc.addChoosableFileFilter(new TxtFileFilter());
		fc.setAcceptAllFileFilterUsed(false);
		fc.setDialogTitle("选择文本文档");
		
		//显示文件选择框，在选择后将结果储存到returnVal变量中 
		@SuppressWarnings("unused")
		int returnVal = fc.showOpenDialog(fc);
		file = fc.getSelectedFile();
		return file.getPath();
	}
}
