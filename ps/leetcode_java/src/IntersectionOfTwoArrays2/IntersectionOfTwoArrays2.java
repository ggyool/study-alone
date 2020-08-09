package IntersectionOfTwoArrays2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IntersectionOfTwoArrays2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int num : nums1){
            if(mp.containsKey(num)){
                mp.replace(num, mp.get(num)+1);
            }
            else{
                mp.put(num, 1);
            }
        }

        List<Integer> list = new ArrayList<>();
        for(int num : nums2){
            if(mp.containsKey(num)){
                int newVal = mp.get(num)-1;
                if(newVal==0) mp.remove(num);
                else mp.replace(num, newVal);
                list.add(num);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
