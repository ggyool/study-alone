package p1.domain.pathfinder;

import p1.domain.location.Location;
import p1.domain.path.Path;

public class SlowPathFinder extends PathFinder {
    @Override
    public Path findPath(Location from, Location to) {
        System.out.println("slow path finder");
        return new Path();
    }
}
