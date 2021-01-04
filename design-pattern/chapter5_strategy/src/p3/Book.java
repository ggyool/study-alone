package p3;

public class Book {
    private String signature;
    private int publishYear;
    private int price;

    public Book(String signature, int publishYear, int price) {
        this.signature = signature;
        this.publishYear = publishYear;
        this.price = price;
    }

    public String getSignature() {
        return signature;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public int getPrice() {
        return price;
    }
}
