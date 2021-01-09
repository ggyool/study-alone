package p2;

import p2.command.MuteCommand;
import p2.command.PowerCommand;

public class Main {
    public static void main(String[] args) {
        Tv tv = new Tv();
        PowerCommand powerCommand = new PowerCommand(tv);
        MuteCommand muteCommand = new MuteCommand(tv);

        TwoButtonController controller = new TwoButtonController(powerCommand, muteCommand);
        controller.button1Pressed();
        controller.button2Pressed();
        controller.button1Pressed();
        controller.button2Pressed();
    }
}
