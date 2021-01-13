package p1.domain;

import p1.domain.gps.GPS;
import p1.domain.location.Location;
import p1.domain.map.Map;
import p1.domain.navi_factory.BasicNaviFactory;
import p1.domain.navi_factory.NaviFactory;
import p1.domain.navi_factory.PremiumNaviFactory;
import p1.domain.pathfinder.PathFinder;
import p1.domain.screen.Screen;

public class Main {
    public static void main(String[] args) {
        NaviFactory naviFactory = BasicNaviFactory.getInstance();
//        NaviFactory naviFactory = PremiumNaviFactory.getInstance();

        GPS gps = naviFactory.createGPS();
        PathFinder pathFinder = naviFactory.createPathFinder();
        Location l1 = gps.findCurrentLocation();
        Location l2 = gps.findCurrentLocation();
        pathFinder.findPath(l1, l2);

        Screen screen = naviFactory.createScreen();
        Map map = naviFactory.createMap();
        screen.drawMap(map);
    }
}
