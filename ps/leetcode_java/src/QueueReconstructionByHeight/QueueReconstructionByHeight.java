package QueueReconstructionByHeight;

import java.util.TreeSet;

// greedy 라는 힌트를 보고 풀었으나 n**3 인듯, 26ms 걸린다.
// 작은 값부터 보는게 포인트
public class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        int len = people.length;

        // 출현한 숫자의 목록
        TreeSet<Integer> st = new TreeSet<>();
        for(int i=0; i<len; ++i){
            st.add(people[i][0]);
        }

        while(!st.isEmpty()){
            int i = st.pollFirst();
            for(int j=0; j<len; ++j){
                int num = people[j][0];
                int cnt = people[j][1];
                if(num==i) {
                    for(int k=0; k<len; ++k) {
                        if(people[k][0] >= num){
                            --cnt;
                        }
                        if(cnt==-1) {
                            // swap
                            int[] tmp = people[j];
                            people[j] = people[k];
                            people[k] = tmp;
                            if(j!=k) --j;
                            break;
                        }
                    }
                }
            }
        }
        return people;
    }

    public static void main(String[] args) {
        QueueReconstructionByHeight sol = new QueueReconstructionByHeight();
        int arr[][] = {{0,0},{6,2},{5,5},{4,3},{5,2},{1,1},{6,0},{6,3},{7,0},{5,1}};

        int res[][] = sol.reconstructQueue(arr);

    }




}
