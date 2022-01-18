package abstractfactory;

public class Client {
    public static void main(String[] args) {
        Stage stage = new Stage(new EasyStageEnemyFactory());
    }
}
