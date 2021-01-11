package p1;

public class Customer {
    private final String name;
    private final int point;

    public Customer(String name, int point) {
        this.name = name;
        this.point = point;
    }

    public String getName() {
        return name;
    }

    public int getPoint() {
        return point;
    }
}
