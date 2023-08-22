package lotto;

import java.util.List;

import static lotto.Validator.*;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        checkSize(numbers);
        checkDuplicated(numbers);
    }

    private void checkSize(List<Integer> numbers) {
        if (numbers.size() != 6) throw createIllegalArgumentException("로또 번호는 6개여야 합니다.");
    }

    private void checkDuplicated(List<Integer> numbers) {
        long count = numbers.stream().distinct().count();
        if (count != 6) throw createIllegalArgumentException("중복된 숫자가 있습니다.");
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
