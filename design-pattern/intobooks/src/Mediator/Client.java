package Mediator;

public class Client {
    public static void main(String[] args) {
        // 초기화
        VideoPlayer videoPlayer = new VideoPlayer();
        TitleUI titleUI = new TitleUI();
        MediaController mediaController = new MediaController();
        VideoListUI videoListUI = new VideoListUI();
        VideoMediator videoMediator = new VideoMediator(videoPlayer, titleUI, videoListUI);

        mediaController.addObserver(videoMediator);
        videoListUI.addObservers(videoMediator);


        // 동작 테스트
        videoListUI.select(0);
        mediaController.clickPlayStopButton();
        mediaController.clickPlayStopButton();
        mediaController.clickNextButton();
        mediaController.clickPlayStopButton();
        mediaController.clickPrevButton();
    }
}
