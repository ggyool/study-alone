package p2;

public class Tv {
    private boolean powerOn = false;
    private boolean muteOn = false;

    public void power() {
        powerOn = !powerOn;
        if (powerOn) {
            System.out.println("전원이 켜졌습니다.");
        } else {
            System.out.println("전원이 꺼졌습니다.");
        }
    }
    
    public void mute() {
        if (!powerOn) {
            return;
        }
        
        muteOn = !muteOn;
        if (muteOn) {
            System.out.println("음소거");
        } else {
            System.out.println("음소거 해제");
        }
    }
}
