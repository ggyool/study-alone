package p2;

import subject.Observer;

public class VoiceNotice implements Observer {
    private final ElevatorController elevatorController;

    public VoiceNotice(ElevatorController elevatorController) {
        this.elevatorController = elevatorController;
    }

    @Override
    public void update() {
        System.out.println("엘리베이터 내부 음성: " + elevatorController.getFloor() + "층");
    }
}
