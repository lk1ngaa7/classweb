package com.classweb.util.fileutil;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class TxtFileFilter extends FileFilter{

	public boolean accept(File f) {
		String filename = f.getName();
		 if(filename.endsWith(".txt")){
			 return true;
		}
		return false;
	}

	public String getDescription() {
		return "*.txt";
	}
}
