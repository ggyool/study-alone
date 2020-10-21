package QueueReconstructionByHeight_2;

import java.util.Arrays;

// h는 작고, k는 큰 순서대로 정렬해서 n**2으로 만든다. 16ms 걸린다.
public class QueueReconstructionByHeight_2 {

    private void printArray(int[][] people) {
        for(int[] person : people) {
            System.out.print(person[0] + " " + person[1]);
            System.out.print(", ");
        }
        System.out.println();
    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (x,y)->{
           // 첫번째 인자 오름차순, 두번째 인자 내림차순
            if(x[0]==y[0]){
                return y[1]-x[1];
            }
            return x[0]-y[0];
        });
        int len = people.length;
        int[][] ret = new int[len][2];
        for(int i=0; i<len; ++i){
            // visited
            ret[i][0] = -1;
        }
        for(int[] person : people) {
            int n = person[0];
            int k = person[1];
            int cnt = 0;
            for(int i=0; i<len; ++i){
                if(ret[i][0]==-1){
                    ++cnt;
                }
                if(cnt==k+1){
                    ret[i][0] = n;
                    ret[i][1] = k;
                    break;
                }
            }
            printArray(ret);
        }
        return null;
    }

    public static void main(String[] args) {
        int arr[][] = {{0,0},{6,2},{5,5},{4,3},{5,2},{1,1},{6,0},{6,3},{7,0},{5,1}};
        QueueReconstructionByHeight_2 sol = new QueueReconstructionByHeight_2();
        sol.reconstructQueue(arr);
    }
}
