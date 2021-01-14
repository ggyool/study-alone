package p1;

// 책 코드 그대로 하면
// dir1안에 dir2를 넣고 dir2에 f2 f3를 넣어서
// depth가 0 1 2 2 문제 없이 되었지만
// dir2안에 f2 f3을 넣고 dir1에 dir2를 넣는다면
// dir2 = 0 -> 1
// f2 = 1
// f3 = 1
// dir1 = 0 이 된다.
// setDepth 부분을 템플릿 메소드를 사용하여 수정하였다.
// directory 일때는 자식들의 depth를 재설정 한다.
public class Main {
    public static void main(String[] args) {
        Directory dir1 = new Directory("root");
        Directory dir2 = new Directory("Dir1");

        File f1 = new File("f1", 100);
        File f2 = new File("f2", 200);
        File f3 = new File("f3", 300);
        File f4 = new File("f4", 400);

        dir1.addEntry(f1);


        dir2.addEntry(f2);
        dir2.addEntry(f3);
        dir1.addEntry(dir2);

        dir1.addEntry(f4);


        dir1.print();
        /*
        [Directory] root, Size: 1000
            [File] f1, Size: 100
            [Directory] Dir1, Size: 500
                [File] f2, Size: 200
                [File] f3, Size: 300
            [File] f4, Size: 400
         */
    }
}
