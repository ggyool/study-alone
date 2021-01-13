package p1.domain.navi_factory;

import p1.domain.gps.GPS;
import p1.domain.map.Map;
import p1.domain.pathfinder.PathFinder;
import p1.domain.screen.Screen;

public abstract class NaviFactory {
    public abstract GPS createGPS();
    public abstract Map createMap();
    public abstract Screen createScreen();
    public abstract PathFinder createPathFinder();
}
