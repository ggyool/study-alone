

public class Philosopher extends Thread{
    int id;
    Chopstick lstick, rsick;
    public Philosopher(int id, Chopstick lstick, Chopstick rsick) {
        this.id = id;
        this.lstick = lstick;
        this.rsick = rsick;
    }
    @Override
    public void run(){
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
    void eating(){
        System.out.println("["+id+"] eating");
    }
    void thinking(){
        System.out.println("["+id+"] thinking");
    }
}
