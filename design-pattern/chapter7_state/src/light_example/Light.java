package light_example;

import light_example.state.Off;
import light_example.state.State;

public class Light {
    private State state;

    public Light() {
        this.state = Off.getInstance();
    }

    public void pushOnButton() {
        state.turnOn(this);
    }

    public void pushOffButton() {
        state.turnOff(this);
    }

    public void setState(State state) {
        this.state = state;
    }
}
