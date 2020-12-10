package MinimumNumberOfFrogsCroaking;

// "croakcroa" -> 1
// "crocakcroraoakk" -> 2

public class MinimumNumberOfFrogsCroaking {
    static final String CROAK = "croak";

    public int minNumberOfFrogs(String croakOfFrogs) {
        int ans = 0;
        int[] count = new int[CROAK.length()];
        int[] index = new int[26];

        for (int i = 0; i < CROAK.length(); i++) {
            index[CROAK.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < croakOfFrogs.length(); i++) {
            char c = croakOfFrogs.charAt(i);
            int idx = index[c - 'a'];
            count[idx]++;
            int firstNumber = getFirstNumber(count);
            int lastNumber = getLastNumber(count);

            if (count[idx] > firstNumber) return -1;
            ans = Math.max(ans, firstNumber - lastNumber);
        }
        if (!isSameAll(count)) return -1;
        return ans;
    }

    private int getFirstNumber(int[] count) {
        return count[0];
    }

    private int getLastNumber(int[] count) {
        return count[count.length - 1];
    }

    private boolean isSameAll(int[] count) {
        for (int i = 1; i < count.length; i++) {
            if (count[i - 1] != count[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MinimumNumberOfFrogsCroaking sol = new MinimumNumberOfFrogsCroaking();
        System.out.println(sol.minNumberOfFrogs("crocakcroraoakk"));
    }
}
