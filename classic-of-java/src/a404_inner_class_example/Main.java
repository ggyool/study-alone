package a404_inner_class_example;

public class Main {
    private int outerVar = 10;

    class Inner {
        private int instanceVar = 10;           // instance 변수 O
//        private static int staticVar = 10;    // static 변수 X
        private static final int CONST = 10;    // 상수는 가능
        private int innerB = outerVar;          // Outer 클래스의 인스턴스 멤버를 사용할 수 있다.

//     private static void staticFunc() {}        // static func X
        private void func() { }
    }

    static class StaticInner {
        private int instanceVar = 10;           // instance 변수 O
        private static int staticVar = 10;      // static 변수 O
        private static final int CONST = 10;    // 상수는 당연히 가능
//        private int innerB = outerVar;          // Outer 클래스의 인스턴스 멤버를 사용 X

        private static void staticFunc() {}        // static func O
        private void func() { }
    }

    // 인스턴스 메서드
    public void instanceFunc() {
        Inner inner = new Inner();
        inner.func();

        StaticInner staticInner = new StaticInner();
        staticInner.func();

        StaticInner.staticFunc();
    }


    // 스태틱 메서드
    public static void staticFunc() {
//        Inner inner = new Inner();    // 불가
        // 굳이 접근하려면 외부 클래스 객체 생성후 가능
        Main outer = new Main();
        Inner inner = outer.new Inner();

        StaticInner staticInner = new StaticInner();
        staticInner.func();

        StaticInner.staticFunc();
    }

    // static 이건 아니건 local 클래스 만들고 사용 가능
    public static void local() {
        int var = 10;
        final int finalVar = 10;
        class Local {
            int localVar = var;
            int localVar2 = finalVar;
            private void func() {
//                var = 10;  // 바꿀 수 없다.
                System.out.println(localVar);
            }
        }
        Local local = new Local();
        local.func();
    }

    public static void main(String[] args) {

    }
}
