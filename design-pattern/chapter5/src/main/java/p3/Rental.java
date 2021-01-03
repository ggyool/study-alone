package p3;

import p3.discount_strategy.BookDiscountStrategy;
import p3.discount_strategy.DefaultDiscountStrategy;
import p3.discount_strategy.DiscountStrategy;
import p3.discount_strategy.MemberDiscountStrategy;

public class Rental {
    private Member member;
    private Book book;
    private int amount;
    private DiscountStrategy discountStrategy;

    public Rental(Member member, Book book, int amount) {
        this.member = member;
        this.book = book;
        this.amount = amount;
        createDiscountStrategy(member, book);
    }

    private void createDiscountStrategy(Member member, Book book) {
        if (isDiscountable(member)) {
            this.discountStrategy = new MemberDiscountStrategy();
            return;
        }
        if (isDiscountable(book)) {
            this.discountStrategy = new BookDiscountStrategy();
            return;
        }
        this.discountStrategy = new DefaultDiscountStrategy();
    }

    private boolean isDiscountable(Member member) {
        final int MEMBER_DISCOUNT_PRICE = 10_000;
        int totalRentalPrice = member.getTotalRentalPrice();

        if (totalRentalPrice >= MEMBER_DISCOUNT_PRICE) {
            return true;
        }
        return false;
    }

    private boolean isDiscountable(Book book) {
        final int BOOK_DISCOUNT_YEAR = 10;
        int publishYear = book.getPublishYear();
        int currentYear = 2021;

        if (currentYear - publishYear >= BOOK_DISCOUNT_YEAR) {
            return true;
        }
        return false;
    }

    public void rend() {
        int totalPrice = getTotalPrice();
        System.out.println("대여: " + member.getName() + "가 " + book.getSignature() + " " + amount + "권 " + totalPrice);
        member.addTotalRentalPrice(totalPrice);
    }

    private int getTotalPrice() {
        int totalPrice = book.getPrice() * amount;
        int discountRate = discountStrategy.getDiscountRate();

        return totalPrice - discountRate * totalPrice / 100;
    }
}
