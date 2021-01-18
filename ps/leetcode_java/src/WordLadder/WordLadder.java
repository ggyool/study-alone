package WordLadder;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        wordSet.remove(beginWord);
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            level++;
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if (cur.equals(endWord)) {
                    return level;
                }
                List<String> neighbors = getNeighbors(cur);
                for (String neighbor : neighbors) {
                    if (wordSet.contains(neighbor)) {
                        wordSet.remove(neighbor);
                        q.add(neighbor);
                    }
                }
            }
        }
        return 0;
    }

    private List<String> getNeighbors(String cur) {
        char[] chars = cur.toCharArray();
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            char temp = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                chars[i] = c;
                ret.add(new String(chars));
            }
            chars[i] = temp;
        }
        return ret;
    }

    public static void main(String[] args) {

    }
}

