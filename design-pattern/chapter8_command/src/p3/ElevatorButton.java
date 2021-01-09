package p3;

import p3.command.Command;

public class ElevatorButton {
    private Command command;

    public ElevatorButton(Command command) {
        this.command = command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void press() {
        command.execute();
    }
}
