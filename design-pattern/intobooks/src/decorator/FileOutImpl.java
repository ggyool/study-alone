package decorator;

public class FileOutImpl implements FileOut {

    @Override
    public void write(byte[] bytes) {
        System.out.println("file out write 실행");
        System.out.println(new String(bytes));
    }
}
