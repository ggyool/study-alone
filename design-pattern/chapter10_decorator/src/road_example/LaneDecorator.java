package road_example;

public class LaneDecorator extends DisplayDecorator {
    protected LaneDecorator(Display decoratedDisplay) {
        super(decoratedDisplay);
    }

    @Override
    public void draw() {
        super.draw();
        System.out.println("차선 표시");
    }
}
