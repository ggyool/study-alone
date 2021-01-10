package p1;

public class BasicEmailContent extends EmailContent {
    private String content;

    public BasicEmailContent(String content) {
        this.content = content;
    }

    @Override
    public String getContent() {
        return content;
    }
}
