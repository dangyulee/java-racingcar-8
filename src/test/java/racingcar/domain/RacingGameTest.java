package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class RacingGameTest {

    @Test
    void 레이싱_게임_생성() {
        // given
        List<String> names = List.of("pobi", "javaj");
        int attempts = 5;

        // when
        RacingGame game = RacingGame.of(names, attempts);

        // then
        assertThat(game.getCars())
                .extracting(Car::name)
                .containsExactly("pobi", "javaj");
        assertThat(game.getAttempts()).isEqualTo(5);
    }

    @Test
    void 중복된_차_이름() {
        //given
        List<String> names = List.of("pobi", "pobi");
        int attempts = 5;

        //when & then
        assertThatThrownBy(() -> RacingGame.of(names, attempts))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도_횟수_1_미만() {
        //given
        List<String> names = List.of("pobi", "javaj");
        int attempts = -1;

        //when & then
        assertThatThrownBy(() -> RacingGame.of(names, attempts))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void hasNextRound() {
        //given
        List<String> names = List.of("pobi", "javaj");
        int attempts = 3;
        RacingGame game = RacingGame.of(names, attempts);

        //when
        boolean result = game.hasNextRound();

        //then
        assertThat(result).isTrue();
    }

    @Test
    void playOneRound() {
        //given
        List<String> names = List.of("pobi", "javaj");
        int attempts = 1;
        RacingGame game = RacingGame.of(names, attempts);

        //when
        boolean before = game.hasNextRound();
        game.playOneRound();
        boolean after = game.hasNextRound();

        //then
        assertThat(before).isTrue();
        assertThat(after).isFalse();
    }
}