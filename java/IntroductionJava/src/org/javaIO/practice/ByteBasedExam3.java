package org.javaIO.practice;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class ByteBasedExam3 {
	public static void main(String[] args) {
		try(DataOutputStream out = new DataOutputStream(new FileOutputStream("data.txt")))
		{
			out.writeInt(97);
			out.writeBoolean(true);
			out.writeDouble(3.14);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
