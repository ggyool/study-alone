package road_example;

abstract public class DisplayDecorator extends Display {
    private final Display decoratedDisplay;

    protected DisplayDecorator(Display decoratedDisplay) {
        this.decoratedDisplay = decoratedDisplay;
    }

    @Override
    public void draw() {
        decoratedDisplay.draw();
    }
}
