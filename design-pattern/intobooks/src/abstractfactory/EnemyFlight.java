package abstractfactory;

public abstract class EnemyFlight {

    private final int attackPower;
    private final int defensivePower;

    public EnemyFlight(int attackPower, int defensivePower) {
        this.attackPower = attackPower;
        this.defensivePower = defensivePower;
    }

    protected int getAttackPower() {
        return this.attackPower;
    }
}
