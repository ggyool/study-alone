package p2.command;

import p2.Tv;

public class MuteCommand implements Command {
    private final Tv tv;

    public MuteCommand(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.mute();
    }
}
