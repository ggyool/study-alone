package road_example;

public class TrafficDecorator extends DisplayDecorator {
    protected TrafficDecorator(Display decoratedDisplay) {
        super(decoratedDisplay);
    }

    @Override
    public void draw() {
        super.draw();
        System.out.println("교통정보 표시");
    }
}
