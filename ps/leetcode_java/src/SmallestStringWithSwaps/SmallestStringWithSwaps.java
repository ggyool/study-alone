package SmallestStringWithSwaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SmallestStringWithSwaps {
    int n;
    List<Integer>[] adj;
    boolean[] visited;
    String s;

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        this.s = s;
        n = s.length();
        adj = new ArrayList[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (List<Integer> pair : pairs) {
            int from = pair.get(0);
            int to = pair.get(1);
            adj[from].add(to);
            adj[to].add(from);
        }
        return dfsAll();
    }

    private String dfsAll() {
        char[] charArr = s.toCharArray();
        List<Integer> indices = new ArrayList<>();
        List<Character> chars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                indices.clear();
                chars.clear();
                indices.add(i);
                chars.add(s.charAt(i));
                visited[i] = true;
                dfs(i, indices, chars);
                relocation(charArr, indices, chars);
            }
        }
        return String.valueOf(charArr);
    }

    private void dfs(int cur, List<Integer> indices, List<Character> chars) {
        int len = adj[cur].size();
        for (int i = 0; i < len; i++) {
            int next = adj[cur].get(i);
            if (!visited[next]) {
                visited[next] = true;
                indices.add(next);
                chars.add(s.charAt(next));
                dfs(next, indices, chars);
            }
        }
    }

    private void relocation(char[] charArr, List<Integer> indices, List<Character> chars) {
        Collections.sort(indices);
        Collections.sort(chars);
        for (int i = 0; i < indices.size(); i++) {
            int idx = indices.get(i);
            charArr[idx] = chars.get(i);
        }
    }

    public static void main(String[] args) {
        SmallestStringWithSwaps sol = new SmallestStringWithSwaps();
        String s = "dcab";
        List<List<Integer>> pairs = new ArrayList<>();
        pairs.add(Arrays.asList(0, 3));
        pairs.add(Arrays.asList(1, 2));

        System.out.println(sol.smallestStringWithSwaps(s, pairs));
    }
}

