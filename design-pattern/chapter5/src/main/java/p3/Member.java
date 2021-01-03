package p3;

public class Member {
    private String name;
    private int totalRentalPrice;

    public Member(String name, int totalRentalPrice) {
        this.name = name;
        this.totalRentalPrice = totalRentalPrice;
    }

    public int getTotalRentalPrice() {
        return totalRentalPrice;
    }

    public String getName() {
        return name;
    }

    public void addTotalRentalPrice(int price) {
        this.totalRentalPrice += price;
    }
}
