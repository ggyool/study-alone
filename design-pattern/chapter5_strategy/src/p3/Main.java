package p3;

// 책 문제가 좀 이상한듯하여 마음대로 만들어 보았음
// 중복할인은 없다고 가정
public class Main {
    public static void main(String[] args) {
        Member member = new Member("name", 0);
        Book book1 = new Book("홍길동전", 2000, 1000);

        Rental rental1 = new Rental(member, book1, 10);
        rental1.rend();

        Book book2 = new Book("전우치", 2020, 10000);
        Rental rental2 = new Rental(member, book2, 2);
        rental2.rend();
    }
}