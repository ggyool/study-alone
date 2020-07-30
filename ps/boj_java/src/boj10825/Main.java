package boj10825;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        List<Student> students = new ArrayList<>();
        for(int i=0; i<n; ++i){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int ko = Integer.parseInt(st.nextToken());
            int en = Integer.parseInt(st.nextToken());
            int ma = Integer.parseInt(st.nextToken());
            students.add(new Student(name, ko, en, ma));
        }
        Collections.sort(students);
        for (Student student : students) {
            bw.write(student.getName() + '\n');
        }
        br.close();
        bw.close();
    }
}

class Student implements Comparable<Student> {
    private String name;
    private int ko, en, ma;
    public Student(){}
    public Student(String name, int ko, int en, int ma) {
        this.name = name;
        this.ko = ko;
        this.en = en;
        this.ma = ma;
    }
    // return 값이 양수 일때 자리가 바뀐다.
    // ko:내림차순, en:오름차순, ma:내림차순, name:오름차순
    @Override
    public int compareTo(Student other) {
        if(ko!=other.ko) return other.ko-ko;
        if(en!=other.en) return en-other.en;
        if(ma!=other.ma) return other.ma-ma;
        // name 의 아스키값이 other.name 보다 크면 양수
        // 오름차순이므로 크면 바꿔야 한다 (그대로 return)
        return name.compareTo(other.name);
    }
    public String getName() {
        return name;
    }
}