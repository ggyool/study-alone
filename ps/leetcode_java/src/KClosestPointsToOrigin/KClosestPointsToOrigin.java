package KClosestPointsToOrigin;

import CourseSchedule.CourseSchedule;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class Pair implements Comparable<Pair>{
    // 거리 값과 idx
    int val, idx;
    public Pair(int val, int idx) {
        this.val = val;
        this.idx = idx;
    }
    @Override
    public int compareTo(Pair o) {
        return this.val - o.val;
    }
}

public class KClosestPointsToOrigin {
    public int calcSquareDistance(int p0, int p1){
        return p0*p0 + p1*p1;
    }
    public int[][] kClosest(int[][] points, int K) {
        List<Pair> list = new ArrayList<>();
        int len = points.length;
        for(int i=0; i<len; ++i){
            list.add(new Pair(calcSquareDistance(points[i][0], points[i][1]), i));
        }
        Collections.sort(list);
        int[][] ret = new int[K][2];
        for(int i=0; i<K; ++i){
            int idx = list.get(i).idx;
            ret[i] = points[idx];
        }
        return ret;
    }
    public static void main(String[] args) {
        KClosestPointsToOrigin sol = new KClosestPointsToOrigin();
        int[][] arr = new int[][] {{3,3},{5,-1},{-2,4}};
        sol.kClosest(arr, 2);
    }
}
