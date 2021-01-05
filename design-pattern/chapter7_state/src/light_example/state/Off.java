package light_example.state;

import light_example.Light;

public class Off implements State {
    private Off() {
    }

    private static class SingletonHolder {
        private static final State instance = new Off();
    }

    public static State getInstance() {
        return SingletonHolder.instance;
    }

    @Override
    public void turnOn(Light light) {
        // 현재는 State 가 Light의 상태를 바꾸고 있다.
        // setter 보다, 다음 State를 return 하고 light에서 바꾸는 것이 바람직해 보임
        light.setState(On.getInstance());
        System.out.println("불이 켜졌습니다.");
    }

    @Override
    public void turnOff(Light light) {
        System.out.println("아무 일도 일어나지 않습니다.");
    }
}
