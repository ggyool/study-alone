package abstractfactory;

public class MissileSmallFlight extends SmallFlight {

    public MissileSmallFlight(int attackPower, int defensivePower) {
        super(attackPower, defensivePower);
    }

    @Override
    public void attack() {
        System.out.printf("MissileSmallFlight attack (%s)%n", getAttackPower());
    }
}
