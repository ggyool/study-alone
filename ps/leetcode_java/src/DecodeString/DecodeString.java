package DecodeString;

public class DecodeString {
    String s;
    int i, len;
    public String makeString(){
        if(i>=len) return "";
        String tmp = "";
        while(true){
            char c = s.charAt(i++);
            if(c=='[') break;
            tmp += c;
        }
        int cnt = Integer.parseInt(tmp);
        String ts = "";
        while(i<len){
            char c = s.charAt(i);
            if('0'<=c && c<='9') ts += makeString();
            else if(c==']') {
                ++i;
                break;
            }
            else {
                ts += c;
                ++i;
            }
        }
        String ret = "";
        for(int j=0; j<cnt; ++j){
            ret += ts;
        }
        return ret;
    }
    public String decodeString(String s) {
        this.s = s;
        this.i = 0;
        this.len = s.length();
        String ret = "";
        while(i<len){
            char c = s.charAt(i);
            if('0'<=c && c <= '9') {
                ret += makeString();
            }
            else{
                ret += c;
                ++i;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        DecodeString sol = new DecodeString();
        System.out.println(sol.decodeString("2[abc]3[cd]ef"));
    }
}
