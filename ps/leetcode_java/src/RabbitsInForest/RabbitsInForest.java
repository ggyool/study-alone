package RabbitsInForest;

public class RabbitsInForest {
    public int numRabbits(int[] answers) {
        int[] count = new int[1000];
        for(int i=0; i<answers.length; ++i){
            ++count[answers[i]];
        }
        int ret = 0;
        for(int i=0; i<1000; ++i){
            if(count[i]>0){
                int group = i+1;
                ret += count[i]/group*group;
                if(count[i]%group>0) ret += group;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        RabbitsInForest sol = new RabbitsInForest();
        int[] arr = {1,0,1,0,0};
        System.out.println(sol.numRabbits(arr));
    }
}
