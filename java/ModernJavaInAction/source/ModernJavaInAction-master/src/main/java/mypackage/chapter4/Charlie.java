package mypackage.chapter4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Charlie {
    public static void main(String[] args) {
        List<WoowahanOrder> deliveries = Arrays.asList(
                new WoowahanOrder("짜장면2", "우테코 루터회관", 1500),
                new WoowahanOrder("교촌허니콤보", "우테코 백엔드 강의실", 1999),
                new WoowahanOrder("햄버거", "우테코 프론트엔드 강의실", 2000),
                new WoowahanOrder("신호등 치킨", "요기요 본사", 525),
                new WoowahanOrder("민트 초코 피자", "요기요테크코스", 1525)
        );

        final long count1 = deliveries.stream()
                .filter(o -> o.getDistance() > 1800)
                .distinct()
                .limit(3)
                .count();
        System.out.println(count1);

        Predicate<WoowahanOrder> yogiyoContains = order -> order.getArrivalAddress().contains("요기요");
        Predicate<WoowahanOrder> wootecoContains = order -> order.getArrivalAddress().contains("우테코");
        IntPredicate distanceFilter = distance -> distance < 2000;

        final List<WoowahanOrder> orders = deliveries.stream()
                .filter(yogiyoContains.negate())
                .filter(order -> distanceFilter.test(order.distance))
                .collect(Collectors.toList());

        final long count = deliveries.stream()
                .filter(wootecoContains)
                .skip(1)
                .count();

        final Optional<WoowahanOrder> max = deliveries.stream()
                .max(Comparator.comparing(WoowahanOrder::getDistance));

        System.out.println(orders.toString());
        System.out.println("우테코에서 요청한 주문 : " + count);
    }
}


class WoowahanOrder {
    String food;
    String arrivalAddress;
    int distance;
    public WoowahanOrder(String food, String arrivalAddress, int distance) {
        this.food = food;
        this.arrivalAddress = arrivalAddress;
        this.distance = distance;
    }
    public String getFood() {
        return food;
    }
    public String getArrivalAddress() {
        return arrivalAddress;
    }
    public int getDistance() {
        return distance;
    }
    @Override
    public String toString() {
        return "WoowahanOrder{" +
                "food='" + food + '\'' +
                ", arrivalAddress='" + arrivalAddress + '\'' +
                '}';
    }
}