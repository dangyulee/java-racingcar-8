package racingcar.domain;

import java.util.*;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<Car> cars;
    private final int attempts;
    private int round = 0;

    private RacingGame(List<String> names, int attempts) {
        validateNames(names);
        validateAttempts(attempts);
        this.cars = names.stream().map(Car::new).collect(Collectors.toList());
        this.attempts = attempts;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getAttempts() {
        return attempts;
    }

    public static RacingGame of(List<String> names, int attempts) {
        return new RacingGame(names, attempts);
    }

    private void validateNames(List<String> names) {
        Set<String> set = names.stream().map(String::trim).collect(Collectors.toSet());
        if (set.size() != names.size())
            throw new IllegalArgumentException("중복된 자동차 이름이 있습니다.");
    }

    private void validateAttempts(int attempts) {
        if (attempts <= 0)
            throw new IllegalArgumentException("시도 횟수는 최소 1회 이상입니다.");
    }

    public boolean hasNextRound() {
        return round < attempts;
    }

    public void playOneRound() {
        cars.forEach(c -> c.move(RandomNum.canMove()));
        round++;
    }

    public List<String> findWinners() {
        int max = cars.stream().mapToInt(car -> car.getPosition()).max().orElse(0);
        return cars.stream()
                .filter(c -> c.getPosition() == max)
                .map(car -> car.getName())
                .collect(Collectors.toList());
    }

    public List<Map.Entry<String, Integer>> snapshotPositions() {
        return cars.stream()
                .map(c -> Map.entry(c.getName(), c.getPosition()))
                .collect(Collectors.toList());
    }
}
