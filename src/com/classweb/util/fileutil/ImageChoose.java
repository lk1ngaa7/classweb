package com.classweb.util.fileutil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;

public class ImageChoose {

	//�������͸�Ϊ����
	public List<String> getImagePath(){
		File[] files=null;
		List<String> list = new ArrayList<String>();
		// �����ļ�ѡ������ 
		JFileChooser fc=new JFileChooser();
		//�趨�ļ�ѡ������
		fc.setMultiSelectionEnabled(true);
		//fc.showOpenDialog(null);
		fc.addChoosableFileFilter(new ImageFileFilter());
		fc.setAcceptAllFileFilterUsed(false);
		fc.setDialogTitle("Open class File");
		//��ʾ�ļ�ѡ�����ѡ��󽫽�����浽returnVal������ 
		int returnVal = fc.showOpenDialog(fc);
		//����û�ѡ�����ļ����������"Opne/��"��ť����ʾ�û�ѡ����ļ�ȫ��·����
		//����û����"Close/�ر�"��ť���Լ�������ʽ�˳��ļ�ѡ�����ʲôҲ������
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
