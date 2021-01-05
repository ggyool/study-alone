package light_example.state;

import light_example.Light;

public class Main {
    public static void main(String[] args) {
        Light light = new Light();
        light.pushOnButton(); // 일반등
        light.pushOnButton(); // 수면등
        light.pushOnButton(); // 일반등
        light.pushOffButton(); // 꺼짐
        light.pushOnButton(); // 일반등
        light.pushOnButton(); // 수면등
        light.pushOffButton(); // 꺼짐
    }
}
