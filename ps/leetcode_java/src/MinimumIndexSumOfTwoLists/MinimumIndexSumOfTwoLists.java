package MinimumIndexSumOfTwoLists;

import java.util.*;

public class MinimumIndexSumOfTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> mp = new HashMap<>();
        int len1 = list1.length;
        int len2 = list2.length;
        for(int i=0; i<len1; ++i){
            mp.put(list1[i], i);
        }
        int minVal = Integer.MAX_VALUE;
        List<String> lst = new ArrayList<>();
        for(int i=0; i<len2; ++i){
            String s2 = list2[i];
            if(mp.containsKey(s2)){
                int idx = mp.get(s2) + i;
                if(idx<minVal){
                    minVal = idx;
                    lst.clear();
                    lst.add(s2);
                }
                else if(idx==minVal){
                    lst.add(s2);
                }
            }
        }
        return lst.toArray(new String[lst.size()]);
    }
}
