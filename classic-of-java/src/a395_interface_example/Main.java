package a395_interface_example;

public class Main {

}

class Building {

}

interface Liftable {
    void liftOff();
    void liftOn();
}

class LiftableImpl implements Liftable {
    @Override
    public void liftOff() {
        // 구현
    }

    @Override
    public void liftOn() {
        // 구현
    }
}


// 배럭과 팩토리 메소드의 내용이 같은 동작인 경우 일일이 작성하면 코드가 중복된다.
// 따라서 Impl 클래스를 만들어 사용한다.
class Barrack extends Building implements Liftable {
    Liftable liftable = new LiftableImpl();

    @Override
    public void liftOff() {
        liftable.liftOff();
    }

    @Override
    public void liftOn() {
        liftable.liftOn();
    }
}

class Factory extends Building implements Liftable {
    Liftable liftable = new LiftableImpl();

    @Override
    public void liftOff() {
        liftable.liftOff();
    }

    @Override
    public void liftOn() {
        liftable.liftOn();
    }
}