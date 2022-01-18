package nullobject;

public class Customer {
    private boolean isVip;
    private boolean isFamilyCombination;

    public Customer(boolean isVip, boolean isFamilyCombination) {
        this.isVip = isVip;
        this.isFamilyCombination = isFamilyCombination;
    }

    public boolean isVip() {
        return isVip;
    }

    public boolean isFamilyCombination() {
        return isFamilyCombination;
    }
}
