package SpecialPositionsInABinaryMatrix;

public class SpecialPositionsInABinaryMatrix {
    public int numSpecial(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;

        int[] row = new int[r];
        int[] col = new int[c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                row[i] += mat[i][j];
                col[j] += mat[i][j];
            }
        }

        int ret = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (mat[i][j] == 1 && row[i] == 1 && col[j] == 1) {
                    ret++;
                }
            }
        }
        return ret;
    }
}
