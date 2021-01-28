package a425_throw_test;

public class Main {
    public static void main(String[] args) {
        // 컴파일 불가능 Checked Exception
        // throw new Exception();

        // 컴파일 가능 Unchecked Exception
        throw new RuntimeException();
    }
}
