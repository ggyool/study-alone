package Sqrtx;

public class Sqrtx {
    public int mySqrt(int x) {
        long left = 0L;
        long right = (long)x;
        long mid;
        long ans = 0L;
        while(left<=right){
            mid = left + (right-left)/2;
            if(mid*mid <= x){
                ans = mid;
                left = mid + 1;
            }
            else{
                right = mid -1;
            }
        }
        return (int)ans;
    }
}
