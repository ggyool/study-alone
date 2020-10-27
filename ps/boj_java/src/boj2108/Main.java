package boj2108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 카운팅 할 수도 있으나, 정렬했다.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int sum = 0;
        for(int i=0; i<n; ++i){
            int num = Integer.parseInt(br.readLine());
            sum += num;
            arr[i] = num;
        }
        Arrays.sort(arr);
        final int NONE = 5000;
        int firstFreqV = arr[n-1];
        int secondFreqV = NONE;
        int maxCnt = 1;
        int curCnt = 1;
        for(int i=n-2; i>=0; --i){
            if(arr[i] == arr[i+1]) {
                ++curCnt;
            } else {
                curCnt = 1;
            }
            if(curCnt>maxCnt) {
                maxCnt = curCnt;
                firstFreqV = arr[i];
                secondFreqV = NONE;
            }
            else if(curCnt==maxCnt) {
                secondFreqV = firstFreqV;
                firstFreqV = arr[i];
            }
        }
        double avg = (double)sum / n;
        System.out.println(Math.round(avg));
        System.out.println(arr[n/2]);
        if(secondFreqV!=NONE) {
            System.out.println(secondFreqV);
        } else {
            System.out.println(firstFreqV);
        }
        System.out.println(arr[n-1] - arr[0]);
    }
}
