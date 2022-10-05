package racingcar.view;

import java.util.List;

public class ResultView {

    public static void printRoundResult(List<LaneView> lanes) {
        for (LaneView lane: lanes) {
            lane.print();
        }

        println();
    }

    public static void printWinner(List<String> winnerNames) {
        print(winnerNames.get(0));
        for (int i = 1; i < winnerNames.size(); i++) {
            print(", ");
            String winnerName = winnerNames.get(i);
            print(winnerName);
        }
        println("가 최종 우승했습니다.");
    }

    public static void print(String target) {
        System.out.print(target);
    }

    public static void println() {
        System.out.println();
    }

    public static void println(String target) {
        System.out.println(target);
    }
}
