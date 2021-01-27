package a330_super_test;

public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        child.func();
    }
}


class Parent {
    protected int px = 10;
}

class Child extends Parent {
    void func() {
        System.out.println("super.px와 px는 같은 주소");
        System.out.println(System.identityHashCode(super.px));
        System.out.println(System.identityHashCode(px));
    }
}