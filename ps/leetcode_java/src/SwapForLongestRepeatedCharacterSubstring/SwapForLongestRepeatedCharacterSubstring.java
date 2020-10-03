package SwapForLongestRepeatedCharacterSubstring;

public class SwapForLongestRepeatedCharacterSubstring {
    public int maxRepOpt1(String text) {
        int ret = 1;
        int slen = text.length();
        int[] lseq = new int[slen];
        int[] rseq = new int[slen];
        int[] cnt = new int[26];
        lseq[0] = 1;
        rseq[slen-1] = 1;
        ++cnt[text.charAt(0)-'a'];
        for(int i=1; i<slen; ++i){
            char c = text.charAt(i);
            ++cnt[c-'a'];
            if(text.charAt(i)==text.charAt(i-1))
                lseq[i] = lseq[i-1] + 1;
            else
                lseq[i] = 1;
            if(text.charAt(slen-1-i)==text.charAt(slen-i))
                rseq[slen-1-i] = rseq[slen-i] + 1;
            else
                rseq[slen-1-i] = 1;
            ret = Math.max(ret, lseq[i]);
        }
        for(int i=0; i<slen; ++i){
            char c = text.charAt(i);
            boolean ldiff = (i!=0 && text.charAt(i-1)!=c);
            boolean rdiff = (i!=slen-1 && text.charAt(i+1)!=c);
            if(ldiff && rdiff && text.charAt(i-1)==text.charAt(i+1)) {
                char tc = text.charAt(i - 1);
                if (lseq[i - 1] + rseq[i + 1] < cnt[tc - 'a']) {
                    ret = Math.max(ret, lseq[i - 1] + 1 + rseq[i + 1]);
                } else {
                    ret = Math.max(ret, lseq[i - 1] + rseq[i + 1]);
                }
            }
            else{
                if(ldiff){
                    char tc = text.charAt(i - 1);
                    if(lseq[i-1] < cnt[tc-'a']){
                        ret = Math.max(ret, lseq[i - 1] + 1);
                    }
                }
                if(rdiff){
                    char tc = text.charAt(i + 1);
                    if(rseq[i+1] < cnt[tc-'a']){
                        ret = Math.max(ret, rseq[i + 1] + 1);
                    }
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        SwapForLongestRepeatedCharacterSubstring sol = new SwapForLongestRepeatedCharacterSubstring();
        System.out.println(sol.maxRepOpt1("acbaaa"));
    }

}
