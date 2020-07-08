import java.util.concurrent.Semaphore;

public class main {
    // number of philosophers and sticks
    static final int N = 5;

    public static void main(String[] args) {
        Semaphore[] stick = new Semaphore[N];
        for(int i=0; i<N; ++i){
            stick[i] = new Semaphore(1);
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
