package decorator;

public class EncryptionOut extends Decorator {

    public EncryptionOut(FileOut delegate) {
        super(delegate);
    }

    @Override
    public void write(byte[] bytes) {
        super.doDelegate(encrypt(bytes));
    }

    private byte[] encrypt(byte[] bytes) {
        System.out.println("Encryption 실행");
        String encryptedString = "%" + new String(bytes) + "%";
        return encryptedString.getBytes();
    }
}
