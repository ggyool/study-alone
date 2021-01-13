package p1.domain.gps;

import p1.domain.location.Location;

public class CheapGPS extends GPS {
    @Override
    public Location findCurrentLocation() {
        System.out.println("find current location with cheap GPS");
        return new Location();
    }
}
