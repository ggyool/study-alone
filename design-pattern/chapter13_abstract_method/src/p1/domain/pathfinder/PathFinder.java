package p1.domain.pathfinder;

import p1.domain.location.Location;
import p1.domain.path.Path;

public abstract class PathFinder {
    public abstract Path findPath(Location from, Location to);
}
