package com.classweb.util.fileutil;

import java.io.File;
import javax.swing.filechooser.FileFilter;

public class ImageFileFilter extends FileFilter { 
	
	public boolean accept(File f) {
		String filename = f.getName();
		if(filename.endsWith(".jpg")||filename.endsWith(".png")||filename.endsWith(".jpeg")||filename.endsWith(".gif")||filename.endsWith(".bmp"))
		{
			return true;
		}
		return false;
	}
	
	public String getDescription() {
		return "*.jpg/*.png/*.jpeg/*.gif/*.bmp";
	}
}
