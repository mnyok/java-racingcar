package racingcar;

public class Car {
    private final CarMovePredicate movePredicate;
    private int position = 0;

    public Car() {
        this.movePredicate = new DefaultCarMovePredicate();
    }

    public Car(CarMovePredicate movePredicate) {
        this.movePredicate = movePredicate;
    }

    public void go() {
        if (movePredicate.isMovable()) {
            move();
        }
    }

    private void move() {
        this.position++;
    }

    public int getPosition() {
        return position;
    }
}
