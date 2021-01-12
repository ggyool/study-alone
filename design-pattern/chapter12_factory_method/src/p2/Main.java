package p2;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();

        car.speedUp(150);
        car.speedDown(30);

        car.enginedFailedDetected();
        car.speedUp(100);
        car.speedDown(30);
        car.speedUp(50);
        car.engineRepaired();
        car.speedUp(100);
    }
}
