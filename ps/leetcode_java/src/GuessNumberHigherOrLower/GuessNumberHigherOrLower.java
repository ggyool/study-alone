package GuessNumberHigherOrLower;

public class GuessNumberHigherOrLower {
    /**
     * Forward declaration of guess API.
     * @param  num   your guess
     * @return 	     -1 if num is lower than the guess number
     *			      1 if num is higher than the guess number
     *               otherwise return 0
     * int guess(int num);
     */
    private int guess(int n){
        return 1;
    }

    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        int mid = 0;
        while (true) {
            mid = left + (right-left)/2;
            int res = guess(mid);
            if(res==0) break;
            else if(res==1){
                left = mid+1;
            }
            else {
                right = mid-1;
            }
        }
        return mid;
    }
}
