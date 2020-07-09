import java.util.concurrent.Semaphore;

public class Philosopher extends Thread{
    int id;
    Semaphore lstick, rsick;
    public Philosopher(int id, Semaphore lstick, Semaphore rsick) {
        this.id = id;
        this.lstick = lstick;
        this.rsick = rsick;
    }

    @Override
    public void run(){
        try {
            while(true){
                if(id%2==0){
                    lstick.acquire();
                    rsick.acquire();
                }
                else{
                    rsick.acquire();
                    lstick.acquire();
                }

                eating();

                lstick.release();
                rsick.release();
                thinking();
            }
        }
        catch (InterruptedException e){
            e.printStackTrace();
         }
    }

    void eating(){
        System.out.println("["+id+"] eating");
    }

    void thinking(){
        System.out.println("["+id+"] thinking");
    }

}
