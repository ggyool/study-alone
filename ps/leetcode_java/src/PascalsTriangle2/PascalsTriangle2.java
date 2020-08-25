package PascalsTriangle2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PascalsTriangle2 {
    public List<Integer> getRow(int rowIndex) {
        Integer[] arr = new Integer[rowIndex+1];
        arr[0] = 1;
        for(int i=1; i<=rowIndex; ++i) {
            int j, bef = 1;
            for (j = 1; j < i; ++j) {
                int tmp = arr[j];
                arr[j] = arr[j] + bef;
                bef = tmp;
            }
            arr[j] = 1;
        }
        return Arrays.asList(arr);
    }
}
