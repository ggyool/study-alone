public class BufferUsingMonitor extends Buffer{

    BufferUsingMonitor(int size) {
        super(size);
    }

    @Override
    synchronized void insert(int item){
        if(count==size){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        buf[in] = item;
        in = (in+1)%size;
        ++count;
        System.out.print("+");
        notify();
    }

    @Override
    synchronized int remove(){
        if(count==0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int item = buf[out];
        out = (out+1)%size;
        --count;
        System.out.print("-");
        notify();
        return item;
    }
}
