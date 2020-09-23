package PartitionLabels;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {

    public List<Integer> partitionLabels(String S) {
        int[] idx = new int[26];
        int slen = S.length();
        for(int i=0; i<slen; ++i){
            char c = S.charAt(i);
            idx[c-'a'] = i;
        }
        List<Integer> ret = new ArrayList<>();
        int maxIdx = 0;
        int len = 0;
        for(int i=0; i<slen; ++i) {
            char c = S.charAt(i);
            maxIdx = Math.max(maxIdx, idx[c-'a']);
            ++len;
            if(maxIdx==i){
                ret.add(len);
                len = 0;
            }
        }
        return ret;
    }
}
