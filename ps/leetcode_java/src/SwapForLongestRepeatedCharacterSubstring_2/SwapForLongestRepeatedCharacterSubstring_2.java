package SwapForLongestRepeatedCharacterSubstring_2;

public class SwapForLongestRepeatedCharacterSubstring_2 {

    public int maxRepOpt1(String text) {
        int[] freq = new int[26];
        int n = text.length();
        for (int i = 0; i < n; i++) {
            freq[text.charAt(i) - 'a']++;
        }
        int s = 0, maxCount = 0, res = 0;
        char maxCountChar = '#';
        int[] count = new int[26];
        for (int f = 0; f < n; f++) {
            if (++count[text.charAt(f) - 'a'] > maxCount) {
                maxCount = count[text.charAt(f) - 'a'];
                maxCountChar = text.charAt(f);
            }
            while (f - s + 1 - maxCount > 1) {
                count[text.charAt(s++) - 'a']--;
            }
            res = Math.max(res, Math.min(freq[maxCountChar - 'a'], f - s + 1));
        }
        return res;
    }

    public static void main(String[] args) {
        SwapForLongestRepeatedCharacterSubstring_2 sol = new SwapForLongestRepeatedCharacterSubstring_2();
        System.out.println(sol.maxRepOpt1("aaabbaaa"));
    }
}
