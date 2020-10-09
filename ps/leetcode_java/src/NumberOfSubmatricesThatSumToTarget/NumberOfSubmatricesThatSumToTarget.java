package NumberOfSubmatricesThatSumToTarget;

public class NumberOfSubmatricesThatSumToTarget {

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] psum = new int[r][c];
        psum[0][0] = matrix[0][0];
        for(int j=1; j<c; ++j){
            psum[0][j] = psum[0][j-1] + matrix[0][j];
        }
        for(int i=1; i<r; ++i){
            psum[i][0] = matrix[i][0] + psum[i-1][0];
            for(int j=1; j<c; ++j){
                psum[i][j] = psum[i-1][j] + psum[i][j-1] - psum[i-1][j-1] + matrix[i][j];
            }
        }
        int ans = 0;
        for(int y=0; y<r; ++y){
            for(int x=0; x<c; ++x){
                for(int i=y; i<r; ++i){
                    for(int j=x; j<c; ++j){
                        int res = psum[i][j];
                        if(y-1>=0) res -= psum[y-1][j];
                        if(x-1>=0) res -= psum[i][x-1];
                        if(x-1>=0 && y-1>=0)res += psum[y-1][x-1];
                        if(res==target) {
                            ++ans;
                        }

                    }
                }
            }
        }
        return ans;
    }
}
