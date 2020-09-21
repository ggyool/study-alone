package ShuffleAnArray;

import java.util.*;

public class ShuffleAnArray {

    List<Integer> originList;

    public ShuffleAnArray(int[] nums) {
        originList = new ArrayList<>();
        for (int num : nums) {
            originList.add(num);
        }
    }

    public int[] reset() {
        int len = originList.size();
        int[] ret = new int[len];
        for(int i=0; i<len; ++i){
            ret[i] = originList.get(i);
        }
        return ret;
    }

    public int[] shuffle() {
        List<Integer> list = new ArrayList<>(originList);
        Collections.shuffle(list);
        int len = list.size();
        int[] ret = new int[len];
        for(int i=0; i<len; ++i){
            ret[i] = list.get(i);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        List<Integer> list = Arrays.asList(1,2,3);
        ShuffleAnArray sol = new ShuffleAnArray(arr);
        sol.shuffle();

    }
}
