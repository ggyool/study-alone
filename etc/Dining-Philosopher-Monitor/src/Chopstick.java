public class Chopstick {
    private boolean isUse = false;
    // 젓가락을 집는 동작
    synchronized void acquire(){
        if(isUse) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isUse = true;
    }
    // 젓가락을 놓는 동작
    synchronized void release(){
        isUse = false;
        notify();
    }
}

