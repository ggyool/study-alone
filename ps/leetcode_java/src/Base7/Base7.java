package Base7;

public class Base7 {
    public String convertToBase7(int num) {
        if (num == 0) return "0";
        boolean isNegative = num < 0;
        StringBuilder sb = new StringBuilder();
        if (isNegative) num *= -1;
        while (num > 0) {
            sb.append((char)((num % 7) + '0'));
            num /= 7;
        }
        if (isNegative) sb.append('-');
        sb.reverse();
        return sb.toString();
    }
}
