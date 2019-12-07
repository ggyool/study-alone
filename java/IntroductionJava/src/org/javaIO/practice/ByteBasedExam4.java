package org.javaIO.practice;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class ByteBasedExam4 {
	public static void main(String[] args) {
		try(DataInputStream inp = new DataInputStream(new FileInputStream("data.txt")))
		{
			System.out.println(inp.readInt());
			System.out.println(inp.readBoolean());
			System.out.println(inp.readDouble());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
	}

}
