package Mediator;

import java.util.ArrayList;
import java.util.List;

public class VideoListUI {

    private List<Video> videos = new ArrayList<>();
    private VideoPlayer videoPlayer;
    private TitleUI titleUI;

    public VideoListUI(VideoPlayer videoPlayer, TitleUI titleUI) {
        this.videoPlayer = videoPlayer;
        this.titleUI = titleUI;
        videos.add(new Video("video1", 5));
        videos.add(new Video("video2", 7));
        videos.add(new Video("video3", 3));
    }

    public void select(int index) {
        if (index < 0 || index >= videos.size()) {
            throw new IllegalArgumentException("리스트 범위 벗어남");
        }
        Video video = videos.get(index);
        titleUI.changeVideo(video);
        videoPlayer.changeVideo(video);
        videoPlayer.play();
    }

    public void selectNext() {
        Video video = videoPlayer.getVideo();
        int index = videos.indexOf(video);
        select(index + 1);
    }

    public void selectPrev() {
        Video video = videoPlayer.getVideo();
        int index = videos.indexOf(video);
        select(index - 1);
    }
}
