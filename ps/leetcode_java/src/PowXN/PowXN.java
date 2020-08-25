package PowXN;

import java.util.HashMap;

public class PowXN {
    // n이 음수인 경우가 있음, 음수 나머지가 좀 이상하다.
    // -1%2 하면 -1이 나온다.
    // 풀이들 보면 -이면 1/x하고 -n 으로 바꾼 코드들도 있다.
    // 복잡도는 같지만 곱하기 나누기 연산 차이인듯
    HashMap<Integer, Double> mp;
    private double recur(double x, int n){
        if(n==0) return 1.;
        if(mp.containsKey(n)) return mp.get(n);
        if(n%2==1){
            double tmp = recur(x, n - 1);
            mp.put(n, tmp*x);
            return tmp*x;
        }
        else if(n%2==-1){
            double tmp = recur(x, n + 1);
            mp.put(n, tmp/x);
            return tmp/x;
        }
        else {
            double tmp = recur(x, n/2);
            mp.put(n, tmp);
            return tmp * tmp;
        }
    }
    public double myPow(double x, int n) {
        mp = new HashMap<>();
        return recur(x, n);
    }
    public static void main(String[] args) {
        PowXN sol = new PowXN();
        System.out.println(sol.myPow(2.0, -1));
    }
}
