package FirstBadVersion;

public class FirstBadVersion {
    public boolean isBadVersion(int n){return true;}

    public int firstBadVersion(int n) {
        long left = 0L;
        long right = n;
        int mid;
        // lowerBound
        while(left<right){
            mid = (int)(left + (right-left)/2);
            if(isBadVersion(mid)){
                right = mid;
            }
            else{
                left = mid +1;
            }
        }
        return (int)right;
    }
}
