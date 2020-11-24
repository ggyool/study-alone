package NumberOfEquivalentDominoPairs;

public class NumberOfEquivalentDominoPairs {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[][] visited = new int[10][10];
        int ret = 0;
        for (int[] domino : dominoes) {
            int a = domino[0];
            int b = domino[1];
            if (a > b) {
                int tmp = a;
                a = b;
                b = tmp;
            }
            // 10C2 == sum(1~9) 와 같으므로 가능
            ret += visited[a][b]++;
        }
//        for (int i=1; i<=9; ++i){
//            for (int j=i; j<=9; ++j) {
//                ret += addCombination(visited[i][j]);
//            }
//        }
        return ret;
    }

    private int addCombination(int n) {
        return n * (n-1) / 2;
    }
}
