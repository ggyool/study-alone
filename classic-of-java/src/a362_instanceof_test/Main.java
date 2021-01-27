package a362_instanceof_test;

public class Main {
    public static void main(String[] args) {
        FireTruck fireTruck = new FireTruck();
        System.out.println(fireTruck instanceof Car); // true
        System.out.println(fireTruck instanceof FireTruck); // true

        Car car = fireTruck;
        System.out.println(car instanceof Car); // true
        System.out.println(car instanceof FireTruck); // true

        System.out.println(fireTruck.getClass().getName()); // FireTruck
        System.out.println(car.getClass().getName()); // FireTruck
    }
}

class Car {
    void drive() {
        System.out.println("drive run");
    }
}

class FireTruck extends Car {
    void water() {
        System.out.println("water run");
    }
}