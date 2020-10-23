package MaxIncreaseToKeepCitySkyline;

public class MaxIncreaseToKeepCitySkyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[] rMax = new int[r];
        int[] cMax = new int[c];
        for(int i=0; i<r; ++i){
            for(int j=0; j<c; ++j){
                rMax[i] = Math.max(rMax[i], grid[i][j]);
                cMax[j] = Math.max(cMax[j], grid[i][j]);
            }
        }
        int ret = 0;
        for(int i=0; i<r; ++i){
            for(int j=0; j<c; ++j){
                ret += Math.min(rMax[i], cMax[j]) - grid[i][j];
            }
        }
        return ret;
    }
}
