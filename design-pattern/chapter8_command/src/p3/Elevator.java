package p3;

public class Elevator {
    private int id;
    private int floor;

    public Elevator(int id, int floor) {
        this.id = id;
        this.floor = floor;
    }

    public int getId() {
        return id;
    }

    public int getFloor() {
        return floor;
    }

    public void moveFloor(int destination) {
        int beforeFloor = this.floor;
        setFloor(destination);
        System.out.println(id + "번 엘리베이터가 " + beforeFloor + "층에서 " + destination + "층으로 이동했습니다.");
    }

    private void setFloor(int floor) {
        this.floor = floor;
    }
}
