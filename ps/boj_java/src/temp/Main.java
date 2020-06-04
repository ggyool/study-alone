package temp;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M,input[],tree[];

    static int init(int node, int start, int end)
    {
        if (start == end)
            return tree[node] = input[start];
        int mid = (start + end) / 2;
        return tree[node] = Math.min(init(node * 2, start, mid),init(node * 2 + 1, mid + 1, end));
    }

    static int min(int node, int start, int end, int left, int right)
    {
        if (left > end || right < start)
            return 1234567890;
        if (left <= start && end <= right)
            return tree[node];
        int mid = (start + end) / 2;
        return Math.min(min(node * 2, start, mid, left, right),min(node*2+1, mid+1, end, left, right));
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        StringBuilder sb=new StringBuilder();
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        input=new int[N+1];
        int size=1;
        while(size<N) {
            size<<=1;
        }
        tree=new int[size<<1];
        for(int i=1;i<=N;++i) input[i]=Integer.parseInt(br.readLine());
        init(1,1,N);

        for(int i=0; i<tree.length; ++i){
            System.out.println(tree[i]);
        }

        while(--M>=0) {
            st=new StringTokenizer(br.readLine());
            sb.append(min(1,1,N,Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()))).append("\n");
        }
        System.out.println(sb);
    }
}