package CourseSchedule;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public boolean topologicalSort(ArrayList<Integer>[] adj, int[] ind, int num){
        int visitedCnt = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<num; ++i){
            if(ind[i] == 0){
                ++visitedCnt;
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int cur = q.poll(); // peek + pop
            int len = adj[cur].size();
            for(int i=0; i<len; ++i){
                int next = adj[cur].get(i);
                if(ind[next]>0){
                    --ind[next];
                    if(ind[next]==0) {
                        q.add(next);
                        ++visitedCnt;
                    }
                }
            }
        }
        return visitedCnt == num;
    }
    public boolean canFinish(int num, int[][] prerequisites) {
        ArrayList<Integer>[] adj = new ArrayList[num];
        for(int i=0; i<num; ++i){
            adj[i] = new ArrayList<>();
        }
        int[] ind = new int[num];
        for (int[] prerequisite : prerequisites) {
            int from = prerequisite[1];
            int to = prerequisite[0];
            adj[from].add(to);
            ++ind[to];
        }
        return topologicalSort(adj, ind, num);
    }

    public static void main(String[] args) {
        CourseSchedule sol = new CourseSchedule();
        int[][] arr = new int[1][2];
        arr[0][0] = 1;
        arr[0][1] = 0;
        sol.canFinish(2, arr);
    }
}
