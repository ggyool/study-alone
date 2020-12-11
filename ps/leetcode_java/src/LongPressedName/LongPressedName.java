package LongPressedName;

public class LongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        int j = 0;
        char bef = name.charAt(0);
        for (int i = 0; i < typed.length(); i++) {
            char c = typed.charAt(i);
            char target;
            if (j < name.length()) {
                target = name.charAt(j);
            } else {
                target = name.charAt(name.length() - 1);
            }
            if (c == target) {
                bef = target;
                j++;
            } else if (bef != c) {
                return false;
            }
        }
        return j >= name.length();
    }

    public static void main(String[] args) {
        LongPressedName sol = new LongPressedName();
        System.out.println(sol.isLongPressedName("aavvtkgn", "vttkgnn"));
    }
}
