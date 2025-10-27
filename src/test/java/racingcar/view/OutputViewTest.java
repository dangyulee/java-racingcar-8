package racingcar.view;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {

    @Test
    void printMove() {
        // given
        List<Map.Entry<String, Integer>> snapshot = List.of(
                Map.entry("pobi", 2),
                Map.entry("woni", 0)
        );

        // when
        String result = OutputView.printMove(snapshot);

        // then
        String expected = ""
                + "pobi : --\n"
                + "woni : \n"
                + "\n";
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void printWinners_하나() {
        // given
        List<String> winners = List.of("pobi");

        // when
        String result = OutputView.printWinners(winners);

        // then
        String expected = "최종 우승자 : pobi";
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void printWinners_둘_이상() {
        // given
        List<String> winners = List.of("pobi", "womi");

        // when
        String result = OutputView.printWinners(winners);

        // then
        String expected = "최종 우승자 : pobi,womi";
        assertThat(result).isEqualTo(expected);
    }
}