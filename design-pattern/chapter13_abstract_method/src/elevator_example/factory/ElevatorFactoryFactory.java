package elevator_example.factory;

import elevator_example.enum_type.VendorId;

public class ElevatorFactoryFactory {
    public static ElevatorFactory getElevatorFactory(VendorId vendorId) {
        switch (vendorId) {
            case LG:
                return LgElevatorFactory.getInstance();
            case HYUNDAI:
                return HyundaiElevatorFactory.getInstance();
            case SAMSUNG:
                return SamsungElevatorFactory.getInstance();
            default:
                return null;
        }

    }
}
