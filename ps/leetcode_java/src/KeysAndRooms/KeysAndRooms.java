package KeysAndRooms;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        visited[0] = true;
        q.add(0);
        int cnt = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            ++cnt;
            List<Integer> keys = rooms.get(cur);
            for (Integer key : keys) {
                if(visited[key]==false){
                    visited[key] = true;
                    q.add(key);
                }
            }
        }
        return cnt == n;
    }
}
