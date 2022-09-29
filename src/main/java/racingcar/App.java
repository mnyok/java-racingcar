package racingcar;

public class App {
    public static void main(String[] args) {
        String[] names = InputView.requestInputNames();
        int repeat = InputView.requestInputRepeat();
        ResultView.println();

        Game game = new Game(names, repeat);
        game.start();
    }
}
