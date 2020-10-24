package boj11286;

import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pospq = new PriorityQueue<>();
        PriorityQueue<Integer> negpq = new PriorityQueue<>();
        for(int i=0; i<n; ++i){
            int num = Integer.parseInt(br.readLine());
            if(num==0){
                if(pospq.isEmpty() && negpq.isEmpty()) {
                    bw.write(0 + "\n");
                }
                else if(pospq.isEmpty()){
                    bw.write(-negpq.poll() + "\n");
                }
                else if(negpq.isEmpty()){
                    bw.write(pospq.poll() + "\n");
                }
                else if(pospq.peek()>=negpq.peek()) {
                    bw.write(-negpq.poll() + "\n");
                }
                else{
                    bw.write(pospq.poll() + "\n");
                }
            }
            else if(num>0){
                pospq.add(num);
            }
            else{
                negpq.add(-num);
            }
        }
        bw.close();
    }
}
