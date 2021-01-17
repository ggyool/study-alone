package WordLadder;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// wordList에 beginWord는 없고, endWord는 포함
// bfs 해야할 듯? 백트랙킹 방밥
public class WordLadder {

    private int wordLen;
    private int[][] count; // i번 word의 알파뱃 개수 정보
    private List<Integer>[] connects;
    private int endIndex = -1;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordLen = wordList.size();
        count = new int[wordLen][];
        connects = new ArrayList[wordLen];
        for (int i = 0; i < wordLen; i++) {
            connects[i] = new ArrayList<>();
            if (endWord.equals(wordList.get(i))) {
                endIndex = i;
            }
        }
        if (endIndex == -1) return 0;
        countAlpha(wordList);
        connectList(wordList);

        return bfs(beginWord, endWord, wordList);
    }

    private void countAlpha(List<String> wordList) {
        for (int i = 0; i < wordLen; i++) {
            count[i] = new int[26];
            String s = wordList.get(i);
            for (char c : s.toCharArray()) {
                count[i][c - 'a']++;
            }
        }
    }

    private void connectList(List<String> wordList) {
        for (int i = 0; i < wordLen - 1; i++) {
            for (int j = i + 1; j < wordLen; j++) {
                if (!checkConnection(wordList, i, j)) continue;
                connects[i].add(j);
                connects[j].add(i);
            }
        }
    }

    private boolean checkConnection(List<String> wordList, int i, int j) {
        String s = wordList.get(i);
        String t = wordList.get(j);
        int diff = 0;
        for (int k = 0; k < 26; k++) {
            diff += Math.abs(count[i][k] - count[j][k]);
        }
        return diff == 2;
    }

    private int bfs(String beginWord, String endWord, List<String> wordList) {
        Queue<Info> q = new LinkedList<Info>();
        int[] beginCount = new int[26];
        for (char c : beginWord.toCharArray()) {
            beginCount[c - 'a']++;
        }
        for (int i = 0; i < wordLen; i++) {
            int diff = 0;
            for (int j = 0; j < 26; j++) {
                diff += Math.abs(beginCount[j] - count[i][j]);
            }
            if (diff == 2) {
                boolean[] visited = new boolean[wordLen];
                visited[i] = true;
                q.add(new Info(i, 2, visited));
            }
        } // 여기까지 initialize

        while (!q.isEmpty()) {
            Info info = q.poll();
            int cur = info.getIdx();
            System.out.println(wordList.get(cur));
            int len = info.getLen();
            boolean[] visited = info.getVisited();
            boolean[] newVisited = new boolean[wordLen];
            System.arraycopy(visited, 0, newVisited, 0, visited.length);
            if (cur == endIndex) {
                return len;
            }
            for (Integer next : connects[cur]) {
                if (visited[next]) continue;
                q.add(new Info(next, len + 1, newVisited));
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        WordLadder sol = new WordLadder();
        String begin = "hit";
        String end = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log");
        int res = sol.ladderLength(begin, end, wordList);
        System.out.println(res);
    }
}

class Info {
    private int idx;
    private int len;
    private boolean[] visited;

    public Info(int idx, int len, boolean[] visited) {
        this.idx = idx;
        this.len = len;
        this.visited = visited;
    }

    public int getIdx() {
        return idx;
    }

    public int getLen() {
        return len;
    }

    public boolean[] getVisited() {
        return visited;
    }
}
