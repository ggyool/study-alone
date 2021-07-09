package mypackage.chapter5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


/*
다시보는 요구사항
일단 메뉴를 전부 줄게, 다 적어나봐..
1. 다이어트 메뉴를 만들어야해, 500칼로리가 안 되는 메뉴들만 뽑아봐
2. 그중 가격이 가장 비싼걸 찾아야 하거든?
3. 3개까지만.
4. 그 메뉴들의 가격 목록을 만들어줘
 */

public class Wedge {
    static class Hamburger implements Comparable<Hamburger> {
        String name;
        int price;
        int calorie;

        public Hamburger(String name, int price, int calorie) {
            this.name = name;
            this.price = price;
            this.calorie = calorie;
        }

        @Override
        public int compareTo(Hamburger that) {
            return Integer.compare(this.price, that.price);
        }
    }

    public static void main(String[] args) {
        List<Hamburger> menus = Arrays.asList(
                new Hamburger("쿼터파운더치즈", 4000, 600),
                new Hamburger("빅맥", 4600, 500),
                new Hamburger("베이컨토마토디럭스", 8000, 700),
                new Hamburger("치즈", 2800, 350),
                new Hamburger("더블치즈", 3800, 390),
                new Hamburger("1955버거", 6500, 800),
                new Hamburger("맥치킨", 2500, 410),
                new Hamburger("상하이치킨", 4500, 500),
                new Hamburger("불고기", 2000, 300),
                new Hamburger("행운", 3500, 450)
        );
        List<Integer> topThreePrice = menus.stream()
                .filter(menu -> menu.calorie < 500)
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .map(menu -> menu.price)
                .collect(Collectors.toList());

        System.out.println(topThreePrice);
    }
}
