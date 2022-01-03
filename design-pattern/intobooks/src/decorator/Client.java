package decorator;

public class Client {

    public static void main(String[] args) {
        FileOut encryptionOut = new EncryptionOut(new FileOutImpl());
        encryptionOut.write("안녕".getBytes());
    }
    
}
