import java.util.concurrent.Semaphore;

public class Buffer {
    int[] buf;
    int size;
    int count;
    int in;
    int out;
    Semaphore mutex;
    Semaphore empty;
    Semaphore full;

    Buffer(int size){
        buf = new int[size];
        this.size = size;
        count = in = out = 0;
        mutex = new Semaphore(1);
        empty = new Semaphore(size); // 비어있는 공간의 개수
        full = new Semaphore(0); // 차있는 공간의 개수
    }
    void insert(int item){
        try {
            empty.acquire(); // 공간이 있으면 넘어갈 수 있음, 꽉 차면 멈춤
            mutex.acquire();

            buf[in] = item;
            in = (in+1)%size;
            ++count;
//            System.out.print("+");

            mutex.release();
            full.release();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    int remove(){
        try {
            full.acquire(); // 하나라도 있으면 넘어갈 수 있음, 없으면 멈춤
            mutex.acquire();

            int item = buf[out];
            out = (out+1)%size;
            --count;
//            System.out.print("-");

            mutex.release();
            empty.release();

            return item;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
