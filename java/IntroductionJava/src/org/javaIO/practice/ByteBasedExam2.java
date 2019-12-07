package org.javaIO.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

// 512 바이트씩 읽어들이기 
public class ByteBasedExam2 {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		// 꼭 exception 처리 해야한다.
		try {
			fis = new FileInputStream("src/org/javaIO/practice/ByteBasedExam.java");
			fos = new FileOutputStream("byte.txt");
			// 읽어들이는 수
			int readCount = -1;
			byte[] buffer = new byte[512];
			while((readCount = fis.read(buffer)) != -1)
			{
				fos.write(buffer,0,readCount);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			try {
				fis.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
