package AsteroidCollision;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

// linked list 사용
public class AsteroidCollision {

    private int abs(int n){
        if(n<0) return -n;
        return n;
    }
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> list = new LinkedList<>();
        for(int val : asteroids){
            list.add(val);
        }
        ListIterator<Integer> it = list.listIterator();
        Integer prev = null;
        Integer next = null;
        while (it.hasNext()){
            next = it.next();
            if((prev!=null && prev>0) && next<0){
                if(abs(prev) == abs(next)){
                    it.previous();
                    it.remove();
                    it.previous();
                    it.remove();
                }
                else if(abs(prev)<abs(next)){
                    it.previous();
                    it.previous();
                    it.remove();
                }
                else{
                    it.remove();
                }
                if(it.hasPrevious()){
                    prev = it.previous();
                    it.next();
                }
                else{
                    prev = null;
                }
            }
            else{
                prev = next;
            }
        }
        int[] ret = new int[list.size()];
        int i = 0;
        for (Integer integer : list) {
            ret[i++] = integer;
        }
        return ret;
    }

    public static void main(String[] args) {
        AsteroidCollision sol = new AsteroidCollision();
        int[] arr = {10,2,-5};
        int[] ints = sol.asteroidCollision(arr);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}


