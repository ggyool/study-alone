package abstractfactory;

public abstract class SmallFlight extends EnemyFlight {

    public SmallFlight(int attackPower, int defensivePower) {
        super(attackPower, defensivePower);
    }

    public abstract void attack();
}
