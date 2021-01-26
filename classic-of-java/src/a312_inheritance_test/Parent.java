package a312_inheritance_test;

public class Parent {
    public int age = 10;

    static {
        System.out.println("Parent static {        }");
    }

    {
        age = 20;
        System.out.println("Parent {         }");
    }

    public Parent() {
        System.out.println("Parent()");
    }
}
