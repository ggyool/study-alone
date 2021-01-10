package road_example;

public class Main {
    public static void main(String[] args) {
        Display roadDisplay = new RoadDisplay();

        // 생성자 protected로 만들어져 있지만, 동일 패키지므로 호출 가능
        Display laneDisplay = new LaneDecorator(roadDisplay);
        laneDisplay.draw();

        Display laneTrafficDisplay = new TrafficDecorator(laneDisplay);
        laneTrafficDisplay.draw();

//        Display laneTrafficDisplay = new TrafficDecorator(new LaneDecorator(new RoadDisplay()));

    }
}

