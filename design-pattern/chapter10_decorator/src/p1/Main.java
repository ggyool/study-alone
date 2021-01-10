package p1;

public class Main {
    public static void main(String[] args) {
        EmailContent basicEmailContent = new BasicEmailContent("Hello");

        EmailContent externalEmailContent = new ExternalEmailContent(basicEmailContent);
        System.out.println(externalEmailContent.getContent());

        EmailContent secureEmailContent = new SecureEmailContent(basicEmailContent);
        System.out.println(secureEmailContent.getContent());

        EmailContent emailContent = new SecureEmailContent(new ExternalEmailContent(new BasicEmailContent("Bye")));
        System.out.println(emailContent.getContent());
    }
}
