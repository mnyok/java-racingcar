package racingcar;

import java.util.Random;

public class Car {
    private final String name;
    private final Random random;
    private int position = 0;

    public Car(String name) {
        this(name, new Random());
    }

    public Car(String name, Random random) {
        this.name = name;
        this.random = random;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void print() {
        ResultView.printCarPosition(name, position);
    }

    public void go() {
        if (isMove()) {
            move();
        }
    }

    private void move() {
        this.position++;
    }

    private boolean isMove() {
        return random.nextInt(10) > 3;
    }
}
