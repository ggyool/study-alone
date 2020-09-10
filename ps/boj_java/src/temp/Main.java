package temp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        List<Student> list = new ArrayList<>();
        for(int i=0; i<n; ++i){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int ko = Integer.parseInt(st.nextToken());
            int en = Integer.parseInt(st.nextToken());
            int ma = Integer.parseInt(st.nextToken());
            list.add(new Student(name, ko, en, ma));
        }
        Collections.sort(list);
        for(int i=0; i<n; ++i){
            bw.write(list.get(i).getName() + "\n");
        }
        br.close();
        bw.close();
    }
}

class Student implements Comparable<Student>{
    private String name;
    private int ko;
    private int en;
    private int ma;

    public Student(String name, int ko, int en, int ma) {
        this.name = name;
        this.ko = ko;
        this.en = en;
        this.ma = ma;
    }

    public String getName() {
        return name;
    }
    @Override
    public int compareTo(Student o) {
        if(o.ko==ko){
            if(o.en==en){
                if(o.ma==ma){
                    // 순서가 앞서면 음수
                    return name.compareTo(o.name);
                }
                return o.ma - ma;
            }
            return en-o.en;
        }
        return o.ko - ko;
    }
}
