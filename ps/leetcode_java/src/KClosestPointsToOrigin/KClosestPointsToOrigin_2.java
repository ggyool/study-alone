package KClosestPointsToOrigin;

import java.util.Arrays;
public class KClosestPointsToOrigin_2 {
    public int[][] kClosest(int[][] points, int K) {
        int n = points.length;
        int[] dist = new int[n];
        for(int i=0; i<n; ++i){
            dist[i] = calcDist(points[i]);
        }
        Arrays.sort(dist);
        int cri = dist[K-1];
        int[][] ret = new int[K][2];
        int i = 0;
        for(int j=0; j<n; ++j){
            if(calcDist(points[j])<=cri){
                ret[i++] = points[j];
            }
        }
        return ret;
    }
    public int calcDist(int[] p){
        return p[0]*p[0] + p[1]*p[1];
    }
    public static void main(String[] args) {
        KClosestPointsToOrigin_2 sol = new KClosestPointsToOrigin_2();
        int [][] arr = new int[][] {{1,3},{-2,2}};
        int[][] res = sol.kClosest(arr, 1);
        System.out.println(res[0][0] + " " + res[0][1]);
    }
}
