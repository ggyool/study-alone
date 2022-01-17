package Mediator;

import java.util.Objects;

public class Video {
    private String title;
    private int playTime;

    public Video(String title, int playTime) {
        this.title = title;
        this.playTime = playTime;
    }

    public String getTitle() {
        return title;
    }

    public int getPlayTime() {
        return playTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Video video = (Video) o;
        return getPlayTime() == video.getPlayTime() && Objects.equals(getTitle(), video.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getPlayTime());
    }
}
