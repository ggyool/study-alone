package mystack;

public class Main {
	public static void main(String[] args) {
		MyStack stk = new MyStack();
		stk.push("abc");
		System.out.println(stk.top());
		stk.pop();
	}
}
