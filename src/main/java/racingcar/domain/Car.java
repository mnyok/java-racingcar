package racingcar.domain;

public class Car {
    private final String name;
    private final CarMoveDecider moveDecider;
    private int position = 0;

    public Car(String name) {
        this(name, new CarMoveDecider());
    }

    public Car(String name, CarMoveDecider moveDecider) {
        this.name = name;
        this.moveDecider = moveDecider;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void go() {
        if (moveDecider.decide()) {
            move();
        }
    }

    private void move() {
        this.position++;
    }
}
