package racingcar.view;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    public static String printMove(List<Map.Entry<String, Integer>> snapshot) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> e : snapshot) {
            sb.append(e.getKey())
                    .append(" : ")
                    .append("-".repeat(e.getValue()))
                    .append("\n");
        }
        sb.append("\n");
        return sb.toString();
    }

    public static String printWinners(List<String> winners) {
        String winnersOutput = winners.stream().collect(Collectors.joining(","));
        return "최종 우승자 : " + winnersOutput;
    }
}
