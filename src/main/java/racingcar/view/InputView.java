package racingcar.view;

import java.util.Scanner;

public class InputView {

    public static String[] requestInputNames() {
        ResultView.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분");
        return scanString().split(",");
    }

    public static int requestInputRepeat() {
        ResultView.println("시도할 회수는 몇 회 인가요?");
        return scanNumber();
    }

    private static String scanString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static int scanNumber() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
