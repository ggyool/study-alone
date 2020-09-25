package TaskScheduler;

import java.util.HashMap;

// 다시 풀자
public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        // 남은 작업 수
        int[] cnt = new int[26];
        // 실행중 이면 남은 턴
        int[] turn = new int[26];
        for(int i=0; i<tasks.length; ++i){
            char c = tasks[i];
            ++cnt[c-'A'];
        }
        int ret = 0;
        while(true){
            boolean allZero = true;
            int maxCnt = 0;
            int target = -1;
            for(int i=0; i<26; ++i){
                if(maxCnt < cnt[i]){
                    allZero = false;
                    if(turn[i]>0) continue;
                    maxCnt = cnt[i];
                    target = i;
                }
            }
            if(allZero) break;
            if(target!=-1){
                --cnt[target];
                for(int j=0; j<26; ++j){
                    if(turn[j]>0) --turn[j];
                }
                turn[target] = n;
            }
            else{
                for(int j=0; j<26; ++j){
                    if(turn[j]>0) --turn[j];
                }
            }
            ++ret;
        }
        return ret;
    }

    public static void main(String[] args) throws InterruptedException {
        TaskScheduler sol = new TaskScheduler();
        char[] arr = {'A','A','A','B','B','B'};
        sol.leastInterval(arr, 2);
    }
}
