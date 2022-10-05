package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CarTest {

    @Mock
    CarMoveDecider decision;

    @Test
    @DisplayName("자동차의 초기 상태 검사")
    void initPosition() {
        String name = "테스트이름";
        assertThat(new Car(name))
                .hasFieldOrPropertyWithValue("name", name)
                .hasFieldOrPropertyWithValue("position", 0);
    }

    @Test
    @DisplayName("이동 시도 성공 시 position이 1 위치로 변경된다")
    void go_success() {
        when(decision.decide())
                .thenReturn(true);

        Car car = new Car("테스트이름", decision);
        car.go();

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("이동 시도 실패시 움직이지 않는다")
    void go_fail() {
        when(decision.decide())
                .thenReturn(false);

        Car car = new Car("테스트이름", decision);
        car.go();

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 11})
    @DisplayName("모든 이동 성공 시 성공한 횟수가 위치와 동일하다")
    void go_success_repeat(int repeat) {
        when(decision.decide())
                .thenReturn(true);

        Car car = new Car("테스트이름", decision);
        for (int i = 0; i < repeat; i++) {
            car.go();
        }

        assertThat(car.getPosition()).isEqualTo(repeat);
    }
}
