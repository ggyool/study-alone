package CinemaSeatAllocation;

import java.util.Arrays;
import java.util.Comparator;

// n은 10**9 큰데 reservedSeats 수가 10**4 이므로 그래프 만들 수 있다.
// 제대로 안 읽고 그래프 못 만드는지 알고 정렬해버림
public class CinemaSeatAllocation {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Arrays.sort(reservedSeats, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }
                else {
                    return o1[0] - o2[0];
                }
            }
        });
        int ans = 2*n;
        int r = -1;
        boolean left, right, center;
        left = right = center = true;
        for(int[] seat : reservedSeats) {
            int y = seat[0];
            int x = seat[1];
            if(y!=r) {
                if(r!=-1){
                    if(left && right);
                    else if(left || right || center) --ans;
                    else ans -= 2;
                }
                r = y;
                left = right = center = true;
            }
            if(2<=x && x<=5) left = false;
            if(4<=x && x<=7) center = false;
            if(6<=x && x<=9) right = false;
        }
        if(r!=-1){
            if(left && right);
            else if(left || right || center) --ans;
            else ans -= 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2},{1,3},{1,8},{2,6},{3,1},{3,10}};
        CinemaSeatAllocation sol = new CinemaSeatAllocation();
        System.out.println(sol.maxNumberOfFamilies(3, arr));
    }
}
