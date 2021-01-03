package KidsWithTheGreatestNumberOfCandies;

import java.util.ArrayList;
import java.util.List;

public class KidsWithTheGreatestNumberOfCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxVal = 0;
        for (int candy : candies) {
            maxVal = Math.max(maxVal, candy);
        }
        List<Boolean> ret = new ArrayList<>();
        for (int candy : candies) {
            if (maxVal <= candy + extraCandies) {
                ret.add(true);
            } else {
                ret.add(false);
            }
        }
        return ret;
    }
}
