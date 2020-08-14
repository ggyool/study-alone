package TopKFrequentElements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int num : nums){
            if(mp.containsKey(num)){
                mp.replace(num, mp.get(num)+1);
            }
            else{
                mp.put(num, 1);
            }
        }
        List<Data> list = new ArrayList<>();
        for (Integer key : mp.keySet()) {
            list.add(new Data(key, mp.get(key)));
        }
        Collections.sort(list);

        List<Integer> ret = new ArrayList<>();
        for(int i=0; i<k; ++i){
            ret.add(list.get(i).val);
        }
        return ret.stream().mapToInt(Integer::intValue).toArray();
    }
}

class Data implements Comparable<Data>{
    int val, cnt;
    public Data(int val, int cnt) {
        this.val = val;
        this.cnt = cnt;
    }
    @Override
    public int compareTo(Data o) {
        return o.cnt - cnt;
    }
}
