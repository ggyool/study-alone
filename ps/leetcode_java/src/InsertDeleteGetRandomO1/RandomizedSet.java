package InsertDeleteGetRandomO1;

import java.util.*;


// HashMap, ArrayList 사용
// map에는 문제의 val을 key로 idx를 저장
// 문제의 포인트는 array 중간 빈 값에 대한 처리
public class RandomizedSet {

    HashMap<Integer, Integer> mp;
    List<Integer> arrList;
    public RandomizedSet() {
        mp = new HashMap<>();
        arrList = new ArrayList<>();
    }

    public boolean insert(int val) {
        if(mp.containsKey(val)){
            return false;
        }
        mp.put(val, arrList.size());
        arrList.add(val);
        return true;
    }
    public boolean remove(int val) {
        if(!mp.containsKey(val)){
            return false;
        }
        int idx = mp.get(val);
        mp.remove(val);
        // 마지막에 있는 값을 삭제위치에 넣고, map도 바꿔준다.
        int lastValue = arrList.get(arrList.size()-1);
        arrList.set(idx, lastValue);
        mp.replace(lastValue, idx);
        arrList.remove(arrList.size()-1); // O(1)이라 추측
        return true;
    }
    public int getRandom() {
        // 0<=x<1
        return arrList.get((int)(Math.random() * arrList.size()));
    }
}
