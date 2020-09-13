package ZigZagConversion;

public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if(numRows==1) return s;
        int slen = s.length();
        int r = numRows;
        int c = slen/2;

        char[][] arr = new char[r][c];
        int i = 0;
        int y = 0;
        int x = 0;
        arr[y][x] = s.charAt(i++);
        while(i<slen){
            for(int j=0; j<r-1; ++j){
                if(i>=slen) break;
                ++y;
                arr[y][x] = s.charAt(i++);

            }
            for(int j=0; j<r-1; ++j){
                if(i>=slen) break;
                --y;
                ++x;
                arr[y][x] = s.charAt(i++);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int n=0; n<r; ++n){
            for(int m=0; m<c; ++m){
                if(arr[n][m]!=0)
                    sb.append(arr[n][m]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ZigZagConversion sol = new ZigZagConversion();
        sol.convert("Apalindromeisaword,phrase,number,orothersequenceofunitsthatcanbereadthesamewayineitherdirection,withgeneralallowancesforadjustmentstopunctuationandworddividers.", 3);
    }

}


