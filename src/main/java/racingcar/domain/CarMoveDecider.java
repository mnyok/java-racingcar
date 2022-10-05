package racingcar.domain;

import java.util.Random;

public class CarMoveDecider {
    private final int LIMIT = 10;
    private final int SUCCESS_CRITERIA = 3;
    private final Random random = new Random();

    public boolean decide() {
        return random.nextInt(LIMIT) > SUCCESS_CRITERIA;
    }
}
