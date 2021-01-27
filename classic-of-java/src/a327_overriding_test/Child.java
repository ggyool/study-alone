package a327_overriding_test;

public class Child extends Parent {
    public void func() {
        System.out.println("Child func");
        System.out.println("같은 패키지 이므로 default인 p에 접근가능");
        System.out.println(p);
    }
}
