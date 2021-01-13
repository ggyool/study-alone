package p1.domain.screen;

import p1.domain.map.Map;

public class SDScreen extends Screen {
    @Override
    public void drawMap(Map map) {
        System.out.println("draw map " + map.getClass().getName() + " on SD screen");
    }
}
