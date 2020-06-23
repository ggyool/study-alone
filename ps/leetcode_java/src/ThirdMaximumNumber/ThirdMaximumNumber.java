package ThirdMaximumNumber;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ThirdMaximumNumber {
    public static int thirdMax(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        for(Integer num : nums) {
            ListIterator<Integer> it = list.listIterator();
            boolean flag = false;
            while (it.hasNext()) {
                int cur = it.next();
                if (num == cur) {
                    flag = true;
                    break;
                }
                if (num > cur) {
                    it.previous();
                    it.add(num);
                    flag = true;
                    break;
                }
            }
            if(list.size()<3 && flag==false){
                it.add(num);
            }
            if(list.size()>3) list.pollLast();
        }

        return list.size()==3 ? list.getLast() : list.getFirst();
    }

    public static void main(String[] args) {
        thirdMax(new int[]{1,2});

    }

}
