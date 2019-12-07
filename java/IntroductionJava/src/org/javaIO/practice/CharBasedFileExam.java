package org.javaIO.practice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class CharBasedFileExam {
	public static void main(String[] args) {
		BufferedReader br = null;
		PrintWriter pw = null;
		try {
			br = new BufferedReader(new FileReader("src/org/javaIO/practice/CharBasedFileExam.java"));
			pw = new PrintWriter(new FileWriter("text.txt"));
			// 발전해서 FileWriter 생략가능
			//pw = new PrintWriter("text.txt");
			String line = null;
			while((line = br.readLine()) != null) {
				pw.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			// BufferReader만 하면 된다고함
			pw.close();	
			try {
				br.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
