package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final int repeat;
    private List<Car> cars;

    public Game(String[] names, int repeat) {
        this.repeat = repeat;
        initCars(names);
    }

    private void initCars(String[] names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        this.cars = cars;
    }

    public void start() {
        ResultView.println("실행 결과");
        for (int i = 0; i < repeat; i++) {
            round();
        }

        printWinner();
    }

    private void round() {
        cars.forEach(Car::go);
        print();
    }

    private void print() {
        ResultView.printRoundResult(cars);
    }

    private void printWinner() {
        List<String> winnerNames = getWinnerNames();
        ResultView.printWinner(winnerNames);
    }

    private List<String> getWinnerNames() {
        int position = winnerPosition();

        List<String> winnerNames = new ArrayList<>();
        // TODO: 메소드 분리
        for (Car car: cars) {
            if (car.getPosition() == position) {
                winnerNames.add(car.getName());
            }
        }
        return winnerNames;
    }

    private int winnerPosition() {
        int max = 0;
        for (Car car: cars) {
            max = Math.max(car.getPosition(), max);
        }
        return max;
    }

}
