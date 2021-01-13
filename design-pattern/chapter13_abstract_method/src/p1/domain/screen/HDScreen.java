package p1.domain.screen;

import p1.domain.map.Map;

public class HDScreen extends Screen {
    @Override
    public void drawMap(Map map) {
        System.out.println("draw map " + map.getClass().getName() + " on HD screen");
    }
}
