package ReverseString;

public class ReverseString {
    private void recur(int idx, char[] s){
        if(idx<s.length/2){
            char tmp = s[idx];
            s[idx] = s[s.length-1-idx];
            s[s.length-1-idx] = tmp;
            recur(idx+1, s);
        }
        else return;
    }
    public void reverseString(char[] s) {
        recur(0, s);
    }
}

