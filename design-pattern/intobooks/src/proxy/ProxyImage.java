package proxy;

public class ProxyImage implements Image {

    private String path;
    private Image image;

    public ProxyImage(String path) {
        this.path = path;
    }

    @Override
    public void draw() {
        if (image == null) {
            image = new RealImage(path);
        }
        image.draw();
    }
}
