package abstractfactory;

public class DashSmallFlight extends SmallFlight {

    public DashSmallFlight(int attackPower, int defensivePower) {
        super(attackPower, defensivePower);
    }

    @Override
    public void attack() {
        System.out.printf("DashSmallFlight attack (%s)%n", getAttackPower());
    }
}
