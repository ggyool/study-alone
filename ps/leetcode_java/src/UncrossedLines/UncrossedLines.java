package UncrossedLines;

// lcs
public class UncrossedLines {
    public static int dp[][];
    public static int alen, blen;
    public int maxUncrossedLines(int[] A, int[] B) {
        alen = A.length;
        blen = B.length;
        dp = new int[alen][blen];

        for(int i=0; i<alen; ++i){
            for(int j=0; j<blen; ++j) {
                dp[i][j] = Math.max(i-1>=0?dp[i-1][j]:0, j-1>=0?dp[i][j-1]:0);
                if(A[i] == B[j]){
                    if(i>0 && j>0) dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + 1);
                    else dp[i][j] = Math.max(dp[i][j], 1);
                }
            }
        }
        return dp[alen-1][blen-1];
    }
}
