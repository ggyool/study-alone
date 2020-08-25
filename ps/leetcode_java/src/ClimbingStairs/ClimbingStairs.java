package ClimbingStairs;

public class ClimbingStairs {

    public int climbStairs(int n) {
        if(n<=2) return n;
        int bb = 1, b = 2;
        for(int i=0; i<n-2; ++i){
            int tmp = b + bb;
            bb = b;
            b = tmp;
        }
        return b;
    }
}


