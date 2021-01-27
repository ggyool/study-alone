package a327_overriding_test;

public class Main {
    public static void main(String[] args) {
        // Child 클래스의 func가 실행된다.
        // 메소드는 실제 인스턴스의 것이 실행된다.
        Parent parentChild = new Child();
        parentChild.func(); // Child func


    }
}
