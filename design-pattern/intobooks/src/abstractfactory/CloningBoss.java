package abstractfactory;

public class CloningBoss extends Boss{

    public CloningBoss(int attackPower, int defensivePower) {
        super(attackPower, defensivePower);
    }

    @Override
    public void specialAttack() {
        System.out.printf("CloningBoss special attack x 2 (%s)%n", getAttackPower() * 2);
    }

    @Override
    public void attack() {
        System.out.printf("CloningBoss normal attack (%s)%n", getAttackPower());
    }
}
