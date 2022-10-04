package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GameTest {

    @ParameterizedTest
    @CsvSource(value = {"1:3", "1,2,test3:5", "1,2,3,4,5,6,7:51"}, delimiter = ':')
    @DisplayName("게임 초기 상태의 반복 값이 생성 시 전달받은 값과 동일해야 한다")
    void initGame(String names, int repeat) {
        Game game = new Game(names.split(","), repeat);

        assertThat(game).hasFieldOrPropertyWithValue("repeat", repeat);
    }

    @Test
    @DisplayName("실제 게임을 실행해 테스트한다")
    void test() {
        String[] names = {"자동차1", "자동차2", "자동차3", "자동차4"};

        Game game = new Game(names, 5);

        game.start();
    }
}
