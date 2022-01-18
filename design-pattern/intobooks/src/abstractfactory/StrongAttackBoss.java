package abstractfactory;

public class StrongAttackBoss extends Boss{

    public StrongAttackBoss(int attackPower, int defensivePower) {
        super(attackPower, defensivePower);
    }

    @Override
    public void specialAttack() {
        System.out.printf("StrongAttackBoss special attack x 10 (%s)%n", getAttackPower() * 10);
    }

    @Override
    public void attack() {
        System.out.printf("StrongAttackBoss normal attack (%s)%n", getAttackPower());
    }
}
