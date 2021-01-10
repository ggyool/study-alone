package p1;

public class SecureEmailContent extends EmailContentDecorator {
    protected SecureEmailContent(EmailContent decoratedEmailContent) {
        super(decoratedEmailContent);
    }

    @Override
    public String getContent() {
        String content = super.getContent();
        return addEncrypt(content);
    }

    private String addEncrypt(String content) {
        return content + " Encrypted";
    }
}
