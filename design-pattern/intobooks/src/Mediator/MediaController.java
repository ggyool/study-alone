package Mediator;

// 1. VideoListUI 에서 특정 제목을 클릭하면, 제목에 해당하는 동영상이 플레이되고, 제목 표시 영역에 해당 제목을 표시한다.
// 2. 영상 제어 영역에서 재생/멈춤 버튼을 누르면 영상 플레이 영역은 영상을 재생하거나 멈춘다.
// 3. 영상 제어 영역에서 다음/이전 버튼을 누르면 영상 목록에서 다음이나 이전 영상을 재생한다.
public class MediaController {

    private VideoListUI videoListUI;
    private VideoPlayer videoPlayer;

    public MediaController(VideoListUI videoListUI, VideoPlayer videoPlayer) {
        this.videoListUI = videoListUI;
        this.videoPlayer = videoPlayer;
    }

    public void clickListUI(int index) {
        videoListUI.select(index);
    }

    public void clickPlayStopButton() {
        if (videoPlayer.isStop()) {
            videoPlayer.play();
        } else if (videoPlayer.isPlay()) {
            videoPlayer.stop();
        }
    }

    public void clickNextButton() {
        videoListUI.selectNext();
    }

    public void clickPrevButton() {
        videoListUI.selectPrev();
    }
}
