package QueueReconstructionByHeight_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// _2와 다르게 h는 크고, k는 작은 순서대로 정렬해서 푼다.
// list.add 가 n이라 생각해서
// 복잡도는 n**2라고 생각했는데 5ms 밖에 안걸린다.

public class QueueReconstructionByHeight_3 {

    private void printArray(int[][] people) {
        for(int[] person : people) {
            System.out.print(person[0] + " " + person[1]);
            System.out.print(", ");
        }
        System.out.println();
    }


    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (x,y)->{
            // 첫번째 인자 내림차순, 두번째 인자 내림차순
            if(x[0]==y[0]){
                return x[1]-y[1];
            }
            return y[0]-x[0];
        });
        ArrayList<int[]> ret = new ArrayList<>();
        for(int[] person : people) {
            ret.add(person[1], person);
        }
        return ret.toArray(new int[0][0]);
    }

    // _2코드와 비슷한 아이디어인데 신기하게 구현했길래 가져옴
//    public int[][] reconstructQueue(int[][] people) {
//        Arrays.sort(people,(x, y)->(x[0]==y[0]?y[1]-x[1]:x[0]-y[0]));
//        int[][] arr = new int[people.length][2];
//        List<Integer> al = new ArrayList<>();
//        for(int i=0;i<people.length;i++){
//            al.add(i);
//        }
//        for(int i=0;i<people.length;i++){
//            // index
//            int ind = al.get(people[i][1]);
//            arr[ind][0]=people[i][0];
//            arr[ind][1]=people[i][1];
//            al.remove(people[i][1]);
//        }
//        return arr;
//    }

    public static void main(String[] args) {
        int arr[][] = {{0,0},{6,2},{5,5},{4,3},{5,2},{1,1},{6,0},{6,3},{7,0},{5,1}};
        QueueReconstructionByHeight_3 sol = new QueueReconstructionByHeight_3();
        sol.reconstructQueue(arr);
    }
}
