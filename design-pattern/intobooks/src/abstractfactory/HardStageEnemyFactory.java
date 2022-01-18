package abstractfactory;

public class HardStageEnemyFactory implements EnemyFactory {
    @Override
    public Boss createBoss() {
        return new CloningBoss(5, 20);
    }

    @Override
    public SmallFlight createSmallFlight() {
        return new MissileSmallFlight(1, 1);
    }

    @Override
    public Obstacle createObstacle() {
        return new BombObstacle();
    }
}
