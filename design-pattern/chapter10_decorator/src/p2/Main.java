package p2;

public class Main {
    public static void main(String[] args) {
        CarComponent basicCar = new BasicCar(1000);
        System.out.println(basicCar.getCarInfo());
        System.out.println(basicCar.getPrice());

        CarComponent airbagCar = new AirBagDecorator(basicCar, 100);
        System.out.println(airbagCar.getCarInfo());
        System.out.println(airbagCar.getPrice());

        CarComponent airbagSccCar = new SccDecorator(airbagCar, 100);
        System.out.println(airbagSccCar.getCarInfo());
        System.out.println(airbagSccCar.getPrice());

        CarComponent sccNaviEscCar = new EscDecorator(new NaviDecorator(new SccDecorator(basicCar, 100), 100), 100);
        System.out.println(sccNaviEscCar.getCarInfo());
        System.out.println(sccNaviEscCar.getPrice());
    }
}
