package RelativeSortArray;

import java.util.HashMap;
import java.util.Map;

public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] ret = new int[arr1.length];
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : arr1) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        int i = 0;
        for (int num : arr2) {
            int repeat = count.get(num);
            for (int j = 0; j < repeat; j++) {
                ret[i++] = num;
            }
            count.put(num, 0);
        }

        for (int num = 0; num <= 1000; num++) {
            if (!count.containsKey(num)) continue;
            if (count.get(num) != 0) {
                int repeat = count.get(num);
                for (int j = 0; j < repeat; j++) {
                    ret[i++] = num;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};
        RelativeSortArray sol = new RelativeSortArray();
        int[] ints = sol.relativeSortArray(arr1, arr2);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
