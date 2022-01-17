package Mediator;

public class VideoPlayer {
    private Video video;
    private PlayStatus playStatus = PlayStatus.STOP;

    public void changeVideo(Video video) {
        this.video = video;
    }

    public void play() {
        playStatus = PlayStatus.PLAY;
        System.out.println(video.getTitle() + " 플레이");
    }

    public void stop() {
        playStatus = PlayStatus.STOP;
        System.out.println(video.getTitle() + " 스탑");
    }

    public boolean isStop() {
        return playStatus == PlayStatus.STOP;
    }

    public boolean isPlay() {
        return playStatus == PlayStatus.PLAY;
    }

    public Video getVideo() {
        return video;
    }
}
