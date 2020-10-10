package NumberOfSubmatricesThatSumToTarget;

import java.util.HashMap;

public class NumberOfSubmatricesThatSumToTarget {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;
        // psum[i][j] = matrix[i][0]~matrix[i][j] 의 합
        int[][] psum = new int[r][c];
        for(int i=0; i<r; ++i){
            for(int j=0; j<c; ++j){
                 if(j==0) psum[i][j] = matrix[i][j];
                 else psum[i][j] = psum[i][j-1] + matrix[i][j];
            }
        }
        int ans = 0;
        // 가로 s~f, 세로 i
        for(int s=0; s<c; ++s){
            for(int f=s; f<c; ++f){
                HashMap<Integer, Integer> mp = new HashMap<>();
                int sum = 0;
                mp.put(0, 1);
                for(int i=0; i<r; ++i){
                    sum += (psum[i][f] - psum[i][s] + matrix[i][s]);
                    if(mp.containsKey(sum-target)){
                        ans += mp.get(sum-target);
                    }
                    mp.put(sum, mp.getOrDefault(sum, 0) + 1);
                }
            }
        }
        return ans;
    }
}
