package a364_duplicated_variable_test;

public class Main {
    public static void main(String[] args) {
        // 중복이름의 인스턴스의 변수의 경우 참조변수를 따라간다.
        Child child = new Child();
        System.out.println(child.getX()); // 20
        Parent parent = new Child();
        System.out.println(parent.getX()); // 20

        // 하지만 메서드는 실제 인스턴스를 따라간다.
        child.func(); // child func
        parent.func(); // child func
    }
}

class Parent {
    int x = 10;
    void func() {
        System.out.println("parent func");
    }
    public int getX() {
        return x;
    }
}

class Child extends Parent {
    int x = 20;
    void func() {
        System.out.println("child func");
    }
    @Override
    public int getX() {
        return x;
    }
}
