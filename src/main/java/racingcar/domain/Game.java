package racingcar.domain;

import racingcar.listener.GameEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private final GameEventListener eventListener;
    private final int repeat;
    private List<Car> cars;

    public Game(String[] names, int repeat, GameEventListener eventListener) {
        this.repeat = repeat;
        initCars(names);
        this.eventListener = eventListener;
    }

    private void initCars(String[] names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        this.cars = cars;
    }

    public void start() {
        eventListener.onStart();
        for (int i = 0; i < repeat; i++) {
            round();
            eventListener.afterRound(cars);
        }

        eventListener.afterGame(cars);
    }

    private void round() {
        cars.forEach(Car::go);
    }

    public List<Car> getCars() {
        return cars;
    }
}
