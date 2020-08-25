package FibonacciNumber;

public class FibonacciNumber {
    int[] fibo;
    private int fibFunc(int n){
        if(n<=1) return n;
        if(fibo[n]!=0) return fibo[n];
        return fibo[n] = fibFunc(n-1) + fibFunc(n-2);
    }
    public int fib(int N) {
        fibo = new int[N+1];
        return fibFunc(N);
    }
}
