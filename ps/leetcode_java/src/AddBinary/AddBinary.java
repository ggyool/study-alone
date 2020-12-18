package AddBinary;

public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int remain = 0;
        while (i >= 0 || j >= 0) {
            int na = (i >= 0) ? a.charAt(i) - '0' : 0;
            int nb = (j >= 0) ? b.charAt(j) - '0' : 0;
            int sum = na + nb + remain;
            remain = sum / 2;
            sb.append(Character.forDigit(sum % 2, 10));
            i--;
            j--;
        }
        if (remain == 1) sb.append('1');
        return sb.reverse().toString();
    }
}
