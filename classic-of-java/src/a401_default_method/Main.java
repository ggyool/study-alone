package a401_default_method;


public class Main {
    public static void main(String[] args) {
        MyInterface myInterface = new MyInterfaceImpl();
        myInterface.funcC();
    }
}

interface MyInterface {
    void funcA();
    void funcB();
    default void funcC() {
        System.out.println("default funcC run");
    }
}

class Parent {
    public void funcC() {
        System.out.println("Parent funcC run");
    }
}

class MyInterfaceImpl extends Parent implements MyInterface {
    @Override
    public void funcA() {
        System.out.println("funcA run");
    }

    @Override
    public void funcB() {
        System.out.println("funcB run");
    }
}
