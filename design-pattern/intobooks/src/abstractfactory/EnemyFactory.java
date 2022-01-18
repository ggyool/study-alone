package abstractfactory;

public interface EnemyFactory {

    Boss createBoss();

    SmallFlight createSmallFlight();

    Obstacle createObstacle();
}
