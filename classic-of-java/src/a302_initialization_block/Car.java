package a302_initialization_block;

public class Car {
    static {
        System.out.println("static {    }");
    }

    {
        System.out.println("{    }");
    }

    public Car() {
        System.out.println("Car()");
    }
}
