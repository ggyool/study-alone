package a382_inheritance_interface;

public class Main {
}

interface Movable {
    void move(int x, int y);
}

interface Attackable {
    void attack(int x, int y);
}

interface Fightable extends Movable, Attackable {

}

class Fighter implements Fightable {
    @Override
    public void move(int x, int y) {
    }

    @Override
    public void attack(int x, int y) {
    }
}