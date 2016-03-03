package com.classweb.util.fileutil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;

public class ImageChoose {

	//返回类型改为数组
	public List<String> getImagePath(){
		File[] files=null;
		List<String> list = new ArrayList<String>();
		// 建立文件选择框对象 
		JFileChooser fc=new JFileChooser();
		//设定文件选择框标题
		fc.setMultiSelectionEnabled(true);
		//fc.showOpenDialog(null);
		fc.addChoosableFileFilter(new ImageFileFilter());
		fc.setAcceptAllFileFilterUsed(false);
		fc.setDialogTitle("Open class File");
		//显示文件选择框，在选择后将结果储存到returnVal变量中 
		int returnVal = fc.showOpenDialog(fc);
		//如果用户选择了文件，并点击了"Opne/打开"按钮，显示用户选择的文件全名路径，
		//如果用户点击"Close/关闭"按钮，以及其它方式退出文件选择框，则什么也不做。
		if (returnVal==JFileChooser.APPROVE_OPTION)
		{
			files = fc.getSelectedFiles();
			for (File file : files) {
                list.add(file.getPath());
			}
		}
		return list;
	}
}
