package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {
    private InputStream originalIn;

    @BeforeEach
    void setUp() {
        originalIn = System.in;
    }

    @AfterEach
    void tearDown() {
        System.setIn(originalIn);
        Console.close();
    }

    @Test
    void 자동차_이름_입력() {
        //given
        String fakeInput = "pobi,javaj\n";
        System.setIn(new ByteArrayInputStream(fakeInput.getBytes(StandardCharsets.UTF_8)));

        //when
        List<String> result = InputView.inputCarNames();

        //then
        assertThat(result).containsExactly("pobi", "javaj");
    }

    @Test
    void null값_입력() {
        //given
        String fakeInput = "\n";
        System.setIn(new ByteArrayInputStream(fakeInput.getBytes(StandardCharsets.UTF_8)));

        //when & then
        assertThatThrownBy(() -> InputView.inputCarNames())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도횟수_입력() {
        //given
        String fakeInput = "5\n";
        System.setIn(new ByteArrayInputStream(fakeInput.getBytes(StandardCharsets.UTF_8)));

        //when
        int result = InputView.inputAttempts();

        //then
        assertThat(result).isEqualTo(5);
    }

    @Test
    void 시도횟수_입력오류() {
        //given
        String fakeInput = "1.5\n";
        System.setIn(new ByteArrayInputStream(fakeInput.getBytes(StandardCharsets.UTF_8)));

        //when & then
        assertThatThrownBy(() -> InputView.inputAttempts())
                .isInstanceOf(IllegalArgumentException.class);
    }
}