package p1;

public class ExternalEmailContent extends EmailContentDecorator {
    protected ExternalEmailContent(EmailContent decoratedEmailContent) {
        super(decoratedEmailContent);
    }

    @Override
    public String getContent() {
        String content = super.getContent();
        return addDisclaimer(content);
    }

    private String addDisclaimer(String content) {
        return content + " Company Disclaimer";
    }
}
