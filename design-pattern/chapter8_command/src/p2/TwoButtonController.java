package p2;

import p2.command.Command;

public class TwoButtonController {
    private Command button1Command;
    private Command button2Command;

    public TwoButtonController(Command button1Command, Command button2Command) {
        this.button1Command = button1Command;
        this.button2Command = button2Command;
    }

    public void setCommand(Command button1Command, Command button2Command) {
        this.button1Command = button1Command;
        this.button2Command = button2Command;
    }

    public void button1Pressed() {
        button1Command.execute();
    }

    public void button2Pressed() {
        button2Command.execute();
    }
}
