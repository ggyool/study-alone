package UniqueNumberOfOccurrences;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberOfOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> occurrences = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        for (int num : arr) {
            int count = occurrences.getOrDefault(num, 0);
            occurrences.put(num, count + 1);
        }

        for (int key : occurrences.keySet()) {
            int val = occurrences.get(key);
            if (visited.contains(val)) {
                return false;
            }
            visited.add(val);
        }

        return true;
    }
}
