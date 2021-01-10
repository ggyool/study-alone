package p1;

public abstract class EmailContentDecorator extends EmailContent {
    private final EmailContent decoratedEmailContent;

    protected EmailContentDecorator(EmailContent decoratedEmailContent) {
        this.decoratedEmailContent = decoratedEmailContent;
    }

    @Override
    public String getContent() {
        return decoratedEmailContent.getContent();
    }
}
