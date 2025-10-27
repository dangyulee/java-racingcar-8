package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingController {

    public void run() {
        try {
            List<String> names = InputView.inputCarNames();
            int attempts = InputView.inputAttempts();

            RacingGame game = RacingGame.of(names, attempts);

            System.out.println("실행 결과");
            while (game.hasNextRound()) {
                game.playOneRound();
            }
            String result = OutputView.printMove(game.snapshotPositions());
            System.out.println(result);
            List<String> winners = game.findWinners();
            String printWinners = OutputView.printWinners(winners);
            System.out.println(printWinners);
        }
        catch (IllegalArgumentException e) {
            throw e;
        }
    }
}
