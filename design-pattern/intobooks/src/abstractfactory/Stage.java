package abstractfactory;

public class Stage {
    private static final int ENEMY_COUNT = 3;
    private static final int OBSTACLE_COUNT = 10;


    private EnemyFactory enemyFactory;
    private EnemyFlight[] enemyFlights = new EnemyFlight[ENEMY_COUNT];
    private Obstacle[] obstacles = new Obstacle[OBSTACLE_COUNT];
    private Boss boss;

    public Stage(EnemyFactory enemyFactory) {
        this.enemyFactory = enemyFactory;
        createEnemies();
        createObstacle();
    }

    private void createEnemies() {
        for (int i = 0; i < ENEMY_COUNT; i++) {
            enemyFlights[i] = enemyFactory.createSmallFlight();
        }
        boss = enemyFactory.createBoss();
    }

    private void createObstacle() {
        for (int i = 0; i < OBSTACLE_COUNT; i++) {
            obstacles[i] = enemyFactory.createObstacle();
        }
    }
}
