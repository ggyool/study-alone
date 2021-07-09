package mypackage.chapter7;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Wante {
    public static void main(String[] args) {
        List<Car> cars = Arrays.asList( new Car(100), new Car(1000),new Car(2000),new Car(3000));
        Stream<Car> stream1 = cars.stream();
        Stream<Car> stream2 = stream1.peek(Car::printPrice);
        Stream<Car> stream3 = stream2.filter(Car::isExpensive);
        System.out.println("filtering");
        Stream<Car> stream4 = stream3.peek(Car::printPrice);
        Stream<Car> stream5 = stream4.sorted(Comparator.comparing(Car::getPrice));
        System.out.println("sorting");
        Stream<Car> stream6 = stream5.peek(Car::printPrice);
        System.out.println(stream6.count());
    }
}

class Car{
    private final int price;
    public Car(int price) {
        this.price = price;
    }
    public boolean isExpensive() {
        return price > 1000;
    }
    public void printPrice() {
        System.out.println("Car: " + price);
    }
    public int getPrice() {
        return price;
    }
}
