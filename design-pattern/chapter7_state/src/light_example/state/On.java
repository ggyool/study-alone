package light_example.state;

import light_example.Light;

public class On implements State {
    private On() {
    }

    private static class SingletonHolder {
        private static final State instance = new On();
    }

    public static State getInstance() {
        return SingletonHolder.instance;
    }

    @Override
    public void turnOn(Light light) {
        light.setState(Sleeping.getInstance());
        System.out.println("수면등으로 바꼇습니다.");
    }

    @Override
    public void turnOff(Light light) {
        light.setState(Off.getInstance());
        System.out.println("불이 꺼졌습니다.");
    }
}
