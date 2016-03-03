package com.classweb.test;

import com.classweb.dao.Ac_albumDao;
import com.classweb.model.Ac_album;

public class Test {

	public void testAc_album() {
		Ac_albumDao acbdao=new Ac_albumDao();
		Ac_album picture=new Ac_album("testPicturePath", 1);
		String[] ac_album=new String[50];
		System.out.println("************************************");
		System.out.println("/////Ac_album/////");
		
		boolean status=false;
		status=acbdao.addPicture(picture);
		if(status){
			System.out.println("        addPicture");
		}
		ac_album=acbdao.getAlbum(1);
		
		if(ac_album[0] != null){
			System.out.println("        getAlbum");
		}
		
		status=acbdao.deleteAlbum(1);
		if(status){
			System.out.println("        deleteAlbum");
		}
		System.out.println("************************************");
	}

}
