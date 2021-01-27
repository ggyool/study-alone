package a359_casting_test;

public class Main {
    public static void main(String[] args) {
        // 실제 인스턴스는 FireTruck 이지만 참조변수에 따라 메서드의 실행여부가 결정이 된다.
        Car car = new FireTruck();
        car.drive();
        // car.water() 불가능
        FireTruck fireTruck = (FireTruck) car;
        fireTruck.water();
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
