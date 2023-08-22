package lotto;

import java.util.List;

public class WinningLotto extends Lotto {

    private final int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonusNumber) {
        if (isContains(bonusNumber)) throw Validator.createIllegalArgumentException("보너스 번호가 당첨 번호에 이미 존재합니다.");
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    @Override
    public String toString() {
        return super.toString() + " + " + bonusNumber;
    }
}
