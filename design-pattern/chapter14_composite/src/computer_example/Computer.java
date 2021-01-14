package computer_example;

import java.util.ArrayList;
import java.util.List;

public class Computer extends ComputerDevice {
    private final List<ComputerDevice> components = new ArrayList<>();

    protected Computer() {
        super(0, 0);
    }

    public void addComponent(ComputerDevice computerDevice) {
        components.add(computerDevice);
    }

    public void removeComponent(ComputerDevice computerDevice) {
        components.remove(computerDevice);
    }

    @Override
    public int getPrice() {
        return components.stream()
            .mapToInt(ComputerDevice::getPrice)
            .sum();
    }

    @Override
    public int getPower() {
        return components.stream()
                .mapToInt(ComputerDevice::getPower)
                .sum();
    }
}
