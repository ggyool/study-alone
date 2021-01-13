package p1.domain.navi_factory;

import p1.domain.gps.ExpensiveGPS;
import p1.domain.gps.GPS;
import p1.domain.map.LargeMap;
import p1.domain.map.Map;
import p1.domain.pathfinder.FastPathFinder;
import p1.domain.pathfinder.PathFinder;
import p1.domain.screen.HDScreen;
import p1.domain.screen.Screen;

public class PremiumNaviFactory extends NaviFactory {
    private static NaviFactory naviFactory = new PremiumNaviFactory();

    private PremiumNaviFactory() {
    }

    public static NaviFactory getInstance() {
        return naviFactory;
    }

    @Override
    public GPS createGPS() {
        return new ExpensiveGPS();
    }

    @Override
    public Map createMap() {
        return new LargeMap();
    }

    @Override
    public Screen createScreen() {
        return new HDScreen();
    }

    @Override
    public PathFinder createPathFinder() {
        return new FastPathFinder();
    }
}
