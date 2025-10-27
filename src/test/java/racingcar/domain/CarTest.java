package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.view.InputView;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void 자동차_한_대_생성() {
        // given
        String input = "pobi";

        // when
        Car testCar = new Car(input);

        // then
        assertThat(testCar.getName()).isEqualTo("pobi");
    }

    @Test
    void 특정_이름_비어있음() {
        //given
        String input = " ";

        //when & then
        assertThatThrownBy(() -> new Car(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름_5자_초과() {
        //given
        String input = "javaji\n";

        //when & then
        assertThatThrownBy(() -> new Car(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void move() {
        // given
        Car car = new Car("pobi");

        // when
        car.move(true);

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }
}