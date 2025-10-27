package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNum {
    public static boolean canMove() {
        int n = Randoms.pickNumberInRange(0, 9);
        return n >= 4;
    }
}
