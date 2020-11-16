package DistributeCandiesToPeople;

public class DistributeCandiesToPeople {

    // 1    2    3    4
    // 5    6    7    8
    // 9    10   11   12
    // 13   14   3


    // 15 18 21 24
    public int[] distributeCandies(int candies, int num_people) {
        int[] ret = new int[num_people];
        int val = (int)findValue(candies);
        // 몇 번째 줄인지
        int line = (val-1)/num_people + 1;
        // 마지막 줄 전까지의 합
        int n = line-1;
        int d = num_people;
        int start = n * (2 + (n-1)*d)/2;
        int l = 1 + n*d;
        long sum = (l-1)*l/2;
        for(int i=0; i<num_people; ++i){
            ret[i] = start + i*n;
            if(sum+l+i<=candies){
                ret[i] += l+i;
                sum += l+i;
            }
            else{
                ret[i] += candies-sum;
                sum = candies;
            }
        }
        return ret;
    }

    // candies 보다 크거나 같아지는 mid
//    private long findValue(int candies){
//        long left = 0;
//        long right = 50000;
//        long mid = 0;
//        long ret = Long.MAX_VALUE;
//        while(left<=right){
//            mid = left + (right-left)/2;
//            long val = mid*(mid+1)/2;
//            if(val<candies) left = mid+1;
//            else if(val>=candies){
//                ret = Math.min(ret, mid);
//                right = mid-1;
//            }
//        }
//        return ret;
//    }

    private long findValue(int candies){
        int n = (int)Math.sqrt((double)(2*candies));
        if(n*(n+1)/2 >=candies) return n;
        return n+1;
    }

    public static void main(String[] args) {
        DistributeCandiesToPeople sol = new DistributeCandiesToPeople();
        sol.distributeCandies(10,3);
    }

}
