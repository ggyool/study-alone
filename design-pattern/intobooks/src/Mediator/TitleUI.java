package Mediator;

public class TitleUI {
    private Video video;

    public TitleUI(){
    }

    public void changeVideo(Video video) {
        this.video = video;
        System.out.println(String.format("제목이 바뀌었습니다 (%s)", video.getTitle()));
    }
}
