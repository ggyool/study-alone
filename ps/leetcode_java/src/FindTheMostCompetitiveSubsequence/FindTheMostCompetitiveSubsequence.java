package FindTheMostCompetitiveSubsequence;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// 갑이 작은 순으로 정렬, 같다면 인덱스 작은 순
public class FindTheMostCompetitiveSubsequence {
    public int[] mostCompetitive(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        PriorityQueue<Info> pq = new PriorityQueue<>();
        int minIdx = -1;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int notSee = len - i;
            if (notSee < k) {
                Info poll = pq.poll();
                minIdx = poll.index;
                list.add(poll.value);
                k--;
                while (!pq.isEmpty() && pq.peek().index < minIdx) {
                    pq.poll();
                }
            }
            pq.add(new Info(nums[i], i));
        }
        while (k > 0) {
            list.add(pq.poll().value);
            k--;
        }
        return list.stream()
                .mapToInt(Integer::valueOf)
                .toArray();
    }

    public static void main(String[] args) {
        FindTheMostCompetitiveSubsequence sol = new FindTheMostCompetitiveSubsequence();
        int[] arr = {3,5,2,6};
        System.out.println(sol.mostCompetitive(arr, 2));
    }
}

class Info implements Comparable<Info> {
    int value;
    int index;

    public Info(int value, int index) {
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(Info o) {
        if (value == o.value) {
            return index - o.index;
        }
        return value - o.value;
    }
}