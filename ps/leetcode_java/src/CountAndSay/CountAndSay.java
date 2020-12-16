package CountAndSay;

public class CountAndSay {
    public String countAndSay(int n) {
        String s = "1";
        for (int i = 2; i <= n; i++) {
            System.out.println(s);
            s = count(s);

        }
        return s;
    }

    private String count(String old) {
        StringBuilder sb = new StringBuilder();

        int n = 1;
        for (int i = 1; i < old.length(); i++) {
            char c = old.charAt(i);
            char bef = old.charAt(i - 1);
            if (c != bef) {
                sb.append(n);
                sb.append(bef);
                n = 1;
            } else {
                n++;
            }
        }
        char last = old.charAt(old.length() - 1);
        sb.append(n);
        sb.append(last);
        return sb.toString();
    }

    public static void main(String[] args) {
        CountAndSay sol = new CountAndSay();
        System.out.println(sol.countAndSay(10));
    }
}
