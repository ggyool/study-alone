package a312_inheritance_test;

public class Child extends Parent {
    static {
        System.out.println("Child static {        }");
    }

    {
        System.out.println("Child {         }");
    }

    public Child() {
//        super();
        System.out.println("Child()");
    }
}
