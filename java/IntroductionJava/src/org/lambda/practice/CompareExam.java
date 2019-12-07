package org.lambda.practice;

public class CompareExam{
	public static void exec(Compare compare)
	{
		int a = 10;
		int b = 20;
		int v = compare.compareTo(a, b);
		System.out.println(v);
	}
	public static void main(String[] args) {
		exec((i,j)->{
			return i-j;
		});		
	}
}
