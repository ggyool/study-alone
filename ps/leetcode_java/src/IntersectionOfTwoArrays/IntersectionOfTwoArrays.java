package IntersectionOfTwoArrays;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> st1 = new HashSet<>();
        HashSet<Integer> st2 = new HashSet<>();

        for(int num1 : nums1){
            st1.add(num1);
        }
        for(int num2 : nums2){
            st2.add(num2);
        }
        List<Integer> list = new ArrayList<>();
        for (Integer num1 : st1) {
            if(st2.contains(num1)){
                list.add(num1);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
