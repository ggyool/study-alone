package modernjavainaction.practice;

public class ParentChildApp {
    public static void main(String[] args) {
        Parent parent = new Child();
    }
}

// 오버라이드
// 부모에서 protected 로 만들면 괜찮고
// public 으로 만들면 문제다.

// 부모의 필드가 protected 라면 캡슐화가 깨졌다.
// extends HashSet<String>

// 캡슐화가
class Parent {

    // 열려 있죠

    protected final void printSecretValue() {
        System.out.println("sv");
    }
}

class Child extends Parent {
    public void printChildValue() {
        super.printSecretValue();
    }
}

