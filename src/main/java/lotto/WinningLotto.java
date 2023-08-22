package lotto;

import java.util.List;

public class WinningLotto extends Lotto {

    private final int bonus;

    public WinningLotto(List<Integer> numbers, int bonus) {
        super(numbers);
        this.bonus = bonus;
    }
}
