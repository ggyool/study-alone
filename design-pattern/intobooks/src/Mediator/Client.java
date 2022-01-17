package Mediator;

public class Client {
    public static void main(String[] args) {
        VideoPlayer videoPlayer = new VideoPlayer();
        TitleUI titleUI = new TitleUI();
        VideoListUI videoListUI = new VideoListUI(videoPlayer, titleUI);

        MediaController mediaController = new MediaController(videoListUI, videoPlayer);
        mediaController.clickListUI(0);

        mediaController.clickPlayStopButton();
        mediaController.clickPlayStopButton();
        mediaController.clickNextButton();
        mediaController.clickPlayStopButton();
        mediaController.clickPrevButton();
    }
}
