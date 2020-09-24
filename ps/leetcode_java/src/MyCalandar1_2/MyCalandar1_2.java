package MyCalandar1_2;

import java.util.TreeMap;

public class MyCalandar1_2 {

    TreeMap<Integer, Integer> tree;

    public MyCalandar1_2() {
        tree = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer prev = tree.floorKey(start);
        Integer next = tree.ceilingKey(start);
        // book이 겹치지 않기에 가능한 조건
        // 이전 끝과 start 를 비교할 수 있다.
        // prev와 next는 같을 수 없다.
        if( (prev==null || tree.get(prev)<=start) && (next==null || end<=next) ) {
            tree.put(start, end);
            return true;
        }
        return false;
    }

}
