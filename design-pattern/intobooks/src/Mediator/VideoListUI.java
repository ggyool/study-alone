package Mediator;

import java.util.ArrayList;
import java.util.List;

public class VideoListUI {

    private List<Video> videos = new ArrayList<>();
    private List<ListObserver> listObservers = new ArrayList<>();

    public VideoListUI() {
        videos.add(new Video("video1", 5));
        videos.add(new Video("video2", 7));
        videos.add(new Video("video3", 3));
    }

    public void addObservers(ListObserver listObserver) {
        listObservers.add(listObserver);
    }

    public void select(int index) {
        Video video = takeValidateVideo(index);
        for (ListObserver listObserver : listObservers) {
            listObserver.delegateVideo(video);
        }
    }

    private Video takeValidateVideo(int index) {
        if (index < 0 || index >= videos.size()) {
            throw new IllegalArgumentException("리스트 범위 벗어남");
        }
        return videos.get(index);
    }

    public Video takeNextByCurrentVideo(Video video) {
        int index = videos.indexOf(video) + 1;
        Video nextVideo = takeValidateVideo(index);
        return nextVideo;
    }

    public Video takePrevByCurrentVideo(Video video) {
        int index = videos.indexOf(video) - 1;
        Video prevVideo = takeValidateVideo(index);
        return prevVideo;
    }
}
