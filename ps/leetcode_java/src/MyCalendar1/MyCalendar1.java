package MyCalendar1;

import java.util.ArrayList;
import java.util.List;
// brute force
public class MyCalendar1 {

    List<Reservation> reservations;

    public MyCalendar1() {
        reservations = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        if(isAble(start, end)){
            reservations.add(new Reservation(start, end));
            return true;
        }
        return false;
    }

    public boolean isAble(int left, int right){
        int len = reservations.size();
        for(int i=0; i<len; ++i){
            Reservation reservation = reservations.get(i);
            int start = reservation.start;
            int end = reservation.end;
            if(start<right && left<end) return false;
        }
        return true;
    }
}


class Reservation{
    int start;
    int end;
    public Reservation(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
