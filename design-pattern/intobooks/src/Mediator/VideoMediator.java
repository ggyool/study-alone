package Mediator;

/*
1. VideoListUI 에서 특정 제목을 클릭하면, 제목에 해당하는 동영상이 플레이되고, 제목 표시 영역에 해당 제목을 표시한다.
listUI -> mediator -> titleUI
                   -> player

2. 영상 제어 영역에서 재생/멈춤 버튼을 누르면 영상 플레이 영역은 영상을 재생하거나 멈춘다.
controller -> mediator -> player

3. 영상 제어 영역에서 다음/이전 버튼을 누르면 영상 목록에서 다음이나 이전 영상을 재생한다.
- player 에서 현재 비디오를 가져오고, listUI에서 다음 비디오를 가져오고 재생한다.
controller -> mediator -> player -> listUI -> titleUI
                                           -> player

*/
public class VideoMediator implements ControllerObserver, ListObserver {

    private VideoPlayer videoPlayer;
    private TitleUI titleUI;
    private VideoListUI videoListUI;

    public VideoMediator(VideoPlayer videoPlayer, TitleUI titleUI, VideoListUI videoListUI) {
        this.videoPlayer = videoPlayer;
        this.titleUI = titleUI;
        this.videoListUI = videoListUI;
    }

    private void playVideo(Video video) {
        titleUI.changeVideo(video);
        videoPlayer.changeVideo(video);
        videoPlayer.play();
    }

    @Override
    public void clickPlayStopButton() {
        if (videoPlayer.isStop()) {
            videoPlayer.play();
        } else if (videoPlayer.isPlay()) {
            videoPlayer.stop();
        }
    }

    @Override
    public void clickNextButton() {
        Video currentVideo = videoPlayer.getVideo();
        Video nextVideo = videoListUI.takeNextByCurrentVideo(currentVideo);
        playVideo(nextVideo);
    }

    @Override
    public void clickPrevButton() {
        Video currentVideo = videoPlayer.getVideo();
        Video prevVideo = videoListUI.takePrevByCurrentVideo(currentVideo);
        playVideo(prevVideo);
    }

    @Override
    public void delegateVideo(Video video) {
        playVideo(video);
    }
}
