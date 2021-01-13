package p1.domain.gps;

import p1.domain.location.Location;

public class ExpensiveGPS extends GPS {
    @Override
    public Location findCurrentLocation() {
        System.out.println("find current location with expensive GPS");
        return new Location();
    }
}
