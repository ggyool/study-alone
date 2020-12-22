package ReconstructItinerary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ReconstructItinerary {
    Map<String, List<String>> mp;
    int ticketLen;

    public List<String> findItinerary(List<List<String>> tickets) {
        ticketLen = tickets.size();
        List<String> ret = new ArrayList<>();
        mp = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            if (mp.containsKey(from)) {
                List<String> edges = mp.get(from);
                edges.add(to);
            } else {
                List<String> edges = new ArrayList<>();
                edges.add(to);
                mp.put(from, edges);
            }
        }
        Map<String, List<Boolean>> visited = new HashMap<>();
        for (String key : mp.keySet()) {
            List<String> edges = mp.get(key);
            Collections.sort(edges);

            List<Boolean> list = new ArrayList<>();
            for (int i = 0; i < edges.size(); i++) {
                list.add(false);
            }
            visited.put(key, list);
        }

        String start = "JFK";
        ret.add(start);

        dfs(ret, visited);
        return ret;
    }

    private boolean dfs(List<String> ret, Map<String, List<Boolean>> visited) {
        if (ret.size() == ticketLen + 1) {
            return true;
        }
        int lastIdx = ret.size() - 1;
        String cur = ret.get(lastIdx);
        List<String> edges = mp.get(cur);
        if (edges == null) return false;
        List<Boolean> visitiedEdge = visited.get(cur);
        for (int i = 0; i < edges.size(); i++) {
            if (visitiedEdge.get(i)) continue;
            String next = edges.get(i);
            visitiedEdge.set(i, true);
            ret.add(next);
            if (dfs(ret, visited))
                return true;
            visitiedEdge.set(i, false);
            ret.remove(ret.size() - 1);
        }
        return false;
    }
}

