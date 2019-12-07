package org.javaIO.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CharBasedExam {
	public static void main(String[] args) {
		BufferedReader br = 
new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		try {
			line = br.readLine();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println(line);
	}
}
