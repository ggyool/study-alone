package IntegerToRoman;

import java.util.HashMap;

public class IntegerToRoman {

    String[] symbol = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
    int[] value = {1,4,5,9,10,40,50,90,100,400,500,900,1000};

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        for(int i=value.length-1; i>=0; --i){
            int cnt = num / value[i];
            num -= value[i]*cnt;
            for(int j=0; j<cnt; ++j){
                sb.append(symbol[i]);
            }
        }
        return sb.toString();
    }
}
