package abstractfactory;

public class EasyStageEnemyFactory implements EnemyFactory {
    @Override
    public Boss createBoss() {
        return new StrongAttackBoss(1, 10);
    }

    @Override
    public SmallFlight createSmallFlight() {
        return new DashSmallFlight(1, 1);
    }

    @Override
    public Obstacle createObstacle() {
        return new RockObstacle();
    }
}
