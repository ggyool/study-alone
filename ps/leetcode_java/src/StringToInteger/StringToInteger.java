package StringToInteger;

public class StringToInteger {

    public int myAtoi(String str) {
        int slen = str.length();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<slen; ++i){
            char c = str.charAt(i);
            if(c!=' '){
                for(int j=i; j<slen; ++j){
                    c = str.charAt(j);
                    if(c==' ') break;
                    sb.append(c);
                }
                break;
            }
        }
        return (int)solve(sb.toString());
    }

    private long solve(String s){
        if(s.length()==0) return 0;
        long ret = 0;
        char firstLetter = s.charAt(0);
        if(Character.isDigit(firstLetter)) {
            for(int i=0; i<s.length(); ++i){
                char c = s.charAt(i);
                if(Character.isDigit(c)){
                    ret = 10*ret + (c-'0');
                }
                else{
                    break;
                }
                if(ret>Integer.MAX_VALUE) {
                    ret = Integer.MAX_VALUE;
                    break;
                }
            }
        }
        else if(firstLetter=='-' || firstLetter=='+'){
            for(int i=1; i<s.length(); ++i){
                char c = s.charAt(i);
                if(Character.isDigit(c)){
                    ret = 10*ret + (c-'0');
                }
                else{
                    break;
                }
                if(firstLetter=='-' && -ret<Integer.MIN_VALUE) {
                    ret = -Integer.MIN_VALUE;
                    break;
                }
                if(firstLetter=='+' && ret>Integer.MAX_VALUE){
                    ret = Integer.MAX_VALUE;
                    break;
                }
            }
            if(firstLetter=='-') ret *= -1;
        }
        return ret;
    }

    public static void main(String[] args) {
        StringToInteger sol = new StringToInteger();
        System.out.println(sol.myAtoi("42"));
    }
}

