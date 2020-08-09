package ContainsDuplicate2;

import java.util.HashMap;

public class ContainsDuplicate2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i=0; i<nums.length; ++i){
            int num = nums[i];
            if(mp.containsKey(num)){
                if(i - mp.get(num) <=k ) return true;
                mp.replace(num, i);
            }
            else{
                mp.put(num, i);
            }
        }
        return false;
    }
}
