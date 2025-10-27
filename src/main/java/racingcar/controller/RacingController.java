package racingcar.controller;

import racingcar.view.InputView;

import java.util.List;

public class RacingController {

    public void run() {
        try {
            List<String> names = InputView.inputCarNames();
            int attempts = InputView.inputAttempts();
        }
        catch (IllegalArgumentException e) {
            throw e;
        }
    }
}
