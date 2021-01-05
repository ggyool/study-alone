package light_example.state;

import light_example.Light;

public interface State {
    void turnOn(Light light);
    void turnOff(Light light);
}
