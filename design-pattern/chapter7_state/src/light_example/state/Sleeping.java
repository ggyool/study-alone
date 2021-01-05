package light_example.state;

import light_example.Light;

public class Sleeping implements State {
    private Sleeping() {
    }

    private static class SingletonHolder {
        private static final State instance = new Sleeping();
    }

    public static State getInstance() {
        return SingletonHolder.instance;
    }
    @Override
    public void turnOn(Light light) {
        light.setState(On.getInstance());
        System.out.println("일반등으로 바꼈습니다.");
    }

    @Override
    public void turnOff(Light light) {
        light.setState(Off.getInstance());
        System.out.println("불이 꺼졌습니다.");
    }
}
