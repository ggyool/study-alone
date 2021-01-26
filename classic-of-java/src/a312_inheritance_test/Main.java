package a312_inheritance_test;

public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        System.out.println(child.age);
        // 1. Child의 생성자에 super를 넣지 않아도
        // 자동으로 Parent의 생성자를 호출한다.
        // 초기화 블럭들도 실행이 된다.
        /*
        Parent static {        }
        Child static {        }
        Parent {         }
        Parent()
        Child {         }
        Child()
        20
         */
    }
}
