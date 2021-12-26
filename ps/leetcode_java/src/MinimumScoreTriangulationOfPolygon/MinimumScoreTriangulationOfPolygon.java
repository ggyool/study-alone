package MinimumScoreTriangulationOfPolygon;

public class MinimumScoreTriangulationOfPolygon {

    public static void main(String[] args) {
        MinimumScoreTriangulationOfPolygon sol = new MinimumScoreTriangulationOfPolygon();
        int[] values = {3, 7, 4, 5};
        System.out.println(sol.minScoreTriangulation(values));
    }

    public int minScoreTriangulation(int[] values) {
        int len = values.length;
        int dp[][] = new int[len][len];
        return solve(0, len - 1, values, dp);
    }

    // 가장 작은 인덱스 i, 큰 인덱스 j 중간인덱스 k
    private int solve(int i, int j, int[] values, int[][] dp) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        if (j - i <= 1) {
            return 0;
        }
        int ret = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            ret = Math.min(ret, values[i] * values[j] * values[k] + solve(k, j, values, dp) + solve(i, k, values, dp));
        }
        dp[i][j] = ret;
        return ret;
    }
}
