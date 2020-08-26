package KthSymbolInGrammar;

public class KthSymbolInGrammar {
    // 관찰하면 이런 규칙이 있다.
    // s[n] = s[n-1] + reverse(s[n-1])
    public int kthGrammar(int N, int K) {
        if(N==1) return 0;
        int len = 1<<(N-1);
        if (K <= len / 2) {
            return kthGrammar(N-1, K);
        }
        else {
            return 1-kthGrammar(N - 1, K - len / 2);
        }
    }
}
