package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.view.InputView;

import java.util.List;

public class RacingController {

    public void run() {
        try {
            List<String> names = InputView.inputCarNames();
            int attempts = InputView.inputAttempts();

            RacingGame game = RacingGame.of(names, attempts);

            while (game.hasNextRound()) {
                game.playOneRound();
            }

        }
        catch (IllegalArgumentException e) {
            throw e;
        }
    }
}
