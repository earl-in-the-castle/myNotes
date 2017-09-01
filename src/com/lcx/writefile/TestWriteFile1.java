package com.lcx.writefile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class TestWriteFile1 {
	public static void main(String[] args) throws Exception {
		String filePath1=TestWriteFile.class.getResource("").getPath().substring(1);
		File file = new File(filePath1+"asd.txt");
		file.createNewFile();
		
		FileOutputStream fileOutPutStream=new FileOutputStream(file);
		String s= "jgdsGDUYdsgyuuYGD";
		fileOutPutStream.write(s.getBytes());
		fileOutPutStream.close();
		

		System.out.println((int)file.length());
		byte[] b=new byte[(int)file.length()];
		FileInputStream fileInPutStream= new FileInputStream(file);
		fileInPutStream.read(b);
		
		System.out.println(new String(b));
		
		
	}

}
