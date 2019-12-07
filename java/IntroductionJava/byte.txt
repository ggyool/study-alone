package org.javaIO.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteBasedExam {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		// 꼭 exception 처리 해야한다.
		try {
			fis = new FileInputStream("src/org/javaIO/practice/ByteBasedExam.java");
			fos = new FileOutputStream("byte.txt");
			int readData = -1;
			while((readData = fis.read()) != -1)
			{
				fos.write(readData);
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
