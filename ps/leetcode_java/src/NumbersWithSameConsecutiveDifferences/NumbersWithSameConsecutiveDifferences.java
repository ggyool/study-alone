package NumbersWithSameConsecutiveDifferences;

import java.util.LinkedList;
import java.util.Queue;

public class NumbersWithSameConsecutiveDifferences {
    public int[] numsSameConsecDiff(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= 9; i++) {
            q.add(i);
        }
        for (int i = 0; i < n - 1; i++) {
            int qlen = q.size();
            for (int j = 0; j < qlen; j++) {
                int cur = q.poll();
                int last = cur % 10;
                if (last + k <= 9) {
                    q.add(10 * cur + last + k);
                }
                if (k == 0) continue;
                if (last - k >= 0) {
                    q.add(10 * cur + last - k);
                }
            }
        }
        return q.stream().mapToInt(Integer::intValue).toArray();
    }
}
