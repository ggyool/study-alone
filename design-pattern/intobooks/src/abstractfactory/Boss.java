package abstractfactory;

public abstract class Boss extends EnemyFlight{

    public Boss(int attackPower, int defensivePower) {
        super(attackPower, defensivePower);
    }

    public abstract void specialAttack();

    public abstract void attack();
}
