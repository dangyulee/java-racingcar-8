package racingcar.domain;

import java.util.Objects;

public class Cars {
    private final String name;
    private int position = 0;

    public Cars(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("자동차 이름이 비어있습니다.");
        if (name.trim().length() > 5)
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
    }

    public String name() {
        return name;
    }

    public int position() {
        return position;
    }
}
