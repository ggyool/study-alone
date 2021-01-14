package computer_example;

public class Main {
    public static void main(String[] args) {
        Body body = new Body(100, 70);
        Keyboard keyboard = new Keyboard(5, 2);
        Monitor monitor = new Monitor(20, 30);
        Speaker speaker = new Speaker(10, 10);

        Computer computer = new Computer();
        computer.addComponent(body);
        computer.addComponent(keyboard);
        computer.addComponent(monitor);
        computer.addComponent(speaker);

        System.out.println(computer.getPower() + " 와트");
        System.out.println(computer.getPrice() + " 만원");
    }
}
