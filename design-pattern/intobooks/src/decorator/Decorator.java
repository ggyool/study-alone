package decorator;

public abstract class Decorator implements FileOut {

    // 위임 대상
    private FileOut delegate;

    public Decorator(FileOut delegate) {
        this.delegate = delegate;
    }

    protected void doDelegate(byte[] bytes) {
        delegate.write(bytes);
    }
}
