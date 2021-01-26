package a327_overriding_test;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        // Child 클래스의 func가 실행된다.
        Parent parentChild = new Child();
        parentChild.func(); // Child func

        Child child = new Child();
        child.func(); // Child func
    }
}
