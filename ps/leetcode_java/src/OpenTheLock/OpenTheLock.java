package OpenTheLock;

import java.util.*;

public class OpenTheLock {

    public int openLock(String[] deadends, String target) {
        HashSet<String> st = new HashSet<>();
        HashMap<String, Integer> dist = new HashMap<>();
        for (String deadend : deadends) {
            if(deadend.equals("0000")) return -1;
            st.add(deadend);
        }
        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        dist.put("0000", 0);
        while(!q.isEmpty()){
            String cur = q.poll();
            int curDist = dist.get(cur);
            if(cur.equals(target)) return curDist;
            char[] carr = cur.toCharArray();
            for(int i=0; i<4; ++i){
                char[] narr = carr.clone();
                String next;
                narr[i] = (char)((narr[i] - '0' + 1)%10 + '0');
                next = new String(narr);
                if(!dist.containsKey(next) && !st.contains(next)){
                    q.offer(next);
                    dist.put(next, curDist+1);
                }
                narr = carr.clone();
                narr[i] = (char)((narr[i] - '0' - 1 + 10)%10 + '0');
                next = new String(narr);
                if(!dist.containsKey(next) && !st.contains(next)){
                    q.offer(next);
                    dist.put(next, curDist+1);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        OpenTheLock sol = new OpenTheLock();
        System.out.println(sol.openLock(new String[]{"0000"}, "8888"));
    }
}
