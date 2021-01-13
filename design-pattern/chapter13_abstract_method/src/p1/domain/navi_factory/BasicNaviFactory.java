package p1.domain.navi_factory;

import p1.domain.gps.CheapGPS;
import p1.domain.gps.GPS;
import p1.domain.map.Map;
import p1.domain.map.SmallMap;
import p1.domain.pathfinder.PathFinder;
import p1.domain.pathfinder.SlowPathFinder;
import p1.domain.screen.SDScreen;
import p1.domain.screen.Screen;

public class BasicNaviFactory extends NaviFactory {
    private static NaviFactory naviFactory = new BasicNaviFactory();

    private BasicNaviFactory() {
    }

    public static NaviFactory getInstance() {
        return naviFactory;
    }

    @Override
    public GPS createGPS() {
        return new CheapGPS();
    }

    @Override
    public Map createMap() {
        return new SmallMap();
    }

    @Override
    public Screen createScreen() {
        return new SDScreen();
    }

    @Override
    public PathFinder createPathFinder() {
        return new SlowPathFinder();
    }
}
