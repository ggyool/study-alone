package kakao_intern_2020.q1;


public class Solution {
    Hand left, right;
    public String solution(int[] numbers, String hand) {
        left = new Hand('L', new Pad( '*'));
        right = new Hand('R', new Pad('#'));
        char h = hand.toUpperCase().charAt(0);
        String answer = "";
        for (int number : numbers) {
            char c = (char)(number + '0');
            char res = judge(c, h);
            if(res=='L'){
                left.setPad(new Pad(c));
            }
            else{
                right.setPad(new Pad(c));
            }
            answer += res;
        }
        return answer;
    }
    public char judge(char c, char hand){
        Pad pad = new Pad(c);
        if(pad.getPos().x == 0) return 'L';
        if(pad.getPos().x == 2) return 'R';
        if(left.getDistance(pad) == right.getDistance(pad)){
            return hand;
        }
        if(left.getDistance(pad) < right.getDistance(pad)) return 'L';
        return 'R';
    }
}


class KeyPos{
    int y,x;
    public KeyPos(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

class Pad{
    char c;
    public Pad(char c) {
        this.c = c;
    }
    public KeyPos getPos(){
        if(c=='1') return new KeyPos(0,0);
        if(c=='2') return new KeyPos(0,1);
        if(c=='3') return new KeyPos(0,2);
        if(c=='4') return new KeyPos(1,0);
        if(c=='5') return new KeyPos(1,1);
        if(c=='6') return new KeyPos(1,2);
        if(c=='7') return new KeyPos(2,0);
        if(c=='8') return new KeyPos(2,1);
        if(c=='9') return new KeyPos(2,2);
        if(c=='*') return new KeyPos(3,0);
        if(c=='0') return new KeyPos(3,1);
        if(c=='#') return new KeyPos(3,2);
        return new KeyPos(-1,-1);
    }
}

class Hand{
    char type;
    Pad pad;
    public Hand(char type, Pad pad) {
        this.type = type;
        this.pad = pad;
    }

    public void setPad(Pad pad) {
        this.pad = pad;
    }
    public int getDistance(Pad o){
        KeyPos pos1 = pad.getPos();
        KeyPos pos2 = o.getPos();
        return Math.abs(pos1.y - pos2.y) + Math.abs(pos1.x - pos2.x);
    }
}