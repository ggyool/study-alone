package a393_interface_example;

public class Main {
    public static void main(String[] args) {
        Tank tank = new Tank();
        tank.setHp(100);

        Scv scv = new Scv();
        System.out.println(tank.getHp()); // 100
        scv.repair(tank);
        System.out.println(tank.getHp()); // 150
    }
}

class Unit {
    protected int hp;
    protected final int MAX_HP;

    public Unit(int hp) {
        this.hp = hp;
        this.MAX_HP = hp;
    }

    public boolean isFullHp() {
        return hp == MAX_HP;
    }

    public void recoverHp() {
        if (isFullHp()) {
            return;
        }
        hp += 1;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}

class GroundUnit extends Unit {
    public GroundUnit(int hp) {
        super(hp);
    }
}

interface Repairable {
}

class Tank extends GroundUnit implements Repairable {
    public Tank() {
        super(150);
    }
}

class Scv extends GroundUnit implements Repairable {
    public Scv() {
        super(60);
    }

    public void repair(Repairable repairable) {
        if (repairable instanceof Repairable) {
            Unit unit = (Unit) repairable;
            while (!unit.isFullHp()) {
                unit.recoverHp();
            }
            System.out.println("repair complete");
        }
    }


}