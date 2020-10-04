package LongestRepeatingCharacterReplacement;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int slen = s.length();
        int[] cnt = new int[26];
        int ret = 0;
        int maxCnt = 0;
        int maxChar = '?';
        int i = 0;
        for(int j=0; j<slen; ++j) {
            char ec = s.charAt(j);
            int idx = ec - 'A';
            ++cnt[idx];
            if(maxCnt < cnt[idx]){
                maxCnt = cnt[idx];
                maxChar = ec;
            }
            if(j-i+1 <= maxCnt+k){
                ret = Math.max(ret, j-i+1);
            }
            else{
                while(j-i+1>maxCnt+k){
                    --cnt[s.charAt(i++)-'A'];
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement sol = new LongestRepeatingCharacterReplacement();
        int res = sol.characterReplacement("ABAB", 2);
        System.out.println(res);
    }
}
