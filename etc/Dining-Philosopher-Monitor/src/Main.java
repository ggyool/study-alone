
public class Main {
    static final int N = 5;

    public static void main(String[] args) {
        Chopstick[] stick = new Chopstick[N];
        for(int i=0; i<N; ++i){
            stick[i] = new Chopstick();
        }
        Philosopher[] phil = new Philosopher[N];
        for(int i=0; i<N; ++i){
            phil[i] = new Philosopher(i, stick[i], stick[(i+1)%N]);
        }
        for(int i=0; i<N; ++i) {
            phil[i].start();
        }
    }
}

