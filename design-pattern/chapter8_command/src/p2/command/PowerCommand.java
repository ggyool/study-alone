package p2.command;

import p2.Tv;

public class PowerCommand implements Command {
    private final Tv tv;

    public PowerCommand(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.power();
    }
}
