package ReverseInteger;

public class ReverseInteger {
    public int reverse(int x) {
        boolean isNegative = x < 0;
        if (isNegative) {
            x *= -1;
        }
        long reverseNumber = 0;
        while (x != 0) {
            reverseNumber = 10 * reverseNumber + x % 10;
            x /= 10;
        }
        if (isNegative) {
            reverseNumber *= -1;
        }
        int ret;
        if (reverseNumber > Integer.MAX_VALUE || reverseNumber <Integer.MIN_VALUE) {
            ret = 0;
        } else {
            ret = (int) reverseNumber;
        }
        return ret;
    }
}
