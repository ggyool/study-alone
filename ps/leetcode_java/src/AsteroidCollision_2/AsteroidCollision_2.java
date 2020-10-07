package AsteroidCollision_2;

import java.util.ArrayDeque;
import java.util.Deque;

// stack 사용
public class AsteroidCollision_2 {

    int abs(int n){
        if(n<0) return -n;
        return n;
    }
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> dq  = new ArrayDeque<>();
        for (int asteroid : asteroids) {
            while(asteroid!=0 && !dq.isEmpty()){
                if(dq.peekLast()>0 && asteroid<0) {
                    int left = dq.peekLast();
                    if(abs(left)==abs(asteroid)) {
                        dq.pollLast();
                        asteroid = 0;
                    }
                    else if(abs(left) < abs(asteroid)){
                        dq.pollLast();
                    }
                    else {
                        asteroid = 0;
                    }
                }
                else {
                    break;
                }
            }
            if(asteroid!=0) dq.addLast(asteroid);
        }
        int[] ret = new int[dq.size()];
        int i = 0;
        while(!dq.isEmpty()) {
            ret[i++] = dq.pollFirst();
        }
        return ret;
    }
}
