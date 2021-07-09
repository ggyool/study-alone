package mypackage.chapter8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TotoApp {
    public static void main(String[] args) {
        List<Toto> totos = Arrays.asList(
                new Toto("br", 2000),
                new Toto("fr", 30000),
                new Toto("de", 20000),
                new Toto("fr", 1000),
                new Toto("kr", 15000),
                new Toto("jp", 10),
                new Toto("en", 1500),
                new Toto("kr", 7000),
                new Toto("kr", 4000),
                new Toto("br", 1000),
                new Toto("en", 1030),
                new Toto("br", 1000)
        );

        Map<String, Integer> stats = new HashMap<>();
        for (Toto toto : totos) {
            String nation = toto.getNation();
            int money = toto.getMoney();

            // 이곳에 코드를 넣으시오.
            // ...
            // ...
            // ...
            //stats.merge(nation, money, Integer::sum);
        }
        System.out.println(stats);
        // 기대 결과
        // {br=4000, de=20000, jp=10, kr=26000, en=2530, fr=31000}
    }

    static class Toto {
        private String nation;
        private int money;

        private Toto(final String nation, final int money) {
            this.nation = nation;
            this.money = money;
        }

        public String getNation() {
            return nation;
        }

        public int getMoney() {
            return money;
        }
    }
}


