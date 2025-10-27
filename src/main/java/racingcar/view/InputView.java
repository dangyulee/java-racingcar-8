package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public static List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String line = Console.readLine();
        if (line == null || line.trim().isEmpty()) throw new IllegalArgumentException("입력이 비어 있습니다.");
        List<String> names = Arrays.stream(line.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
        return names;
    }

    public static int inputAttempts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String line = Console.readLine();

        try {
            return Integer.parseInt(line.trim());
        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 입력값입니다. 정수로 입력해주세요.");
        }
    }

}
