package RotateImage;

public class RotateImage {
    public void rotate(int[][] matrix) {
        final int n = matrix.length;
        if (n % 2 == 1) {
            runOddCase(matrix);
        } else {
            runEvenCase(matrix);
        }
    }

    // 홀수인 경우 시작점 0<=y<cy, 0<=x<=cx
    private void runOddCase(final int[][] matrix) {
        int n = matrix.length;
        int cy = n / 2;
        int cx = n / 2;
        for (int i = 0; i < cy; i++) {
            for (int j = 0; j <= cx; j++) {
                moveFourth(i, j, n, matrix);
            }
        }
    }

    // 짝수인 경우 1/4 사각형이 시작점
    private void runEvenCase(final int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                moveFourth(i, j, n, matrix);
            }
        }
    }

    private void moveFourth(int i, int j, final int n, final int[][] matrix) {
        int ni, nj;
        int tmp = matrix[i][j];
        int swapValue = 0;
        for (int t = 0; t < 4; t++) {
            ni = j;
            nj = n - 1 - i;
            swapValue = tmp;
            tmp = matrix[ni][nj];
            matrix[ni][nj] = swapValue;
            i = ni;
            j = nj;
        }
    }
}
