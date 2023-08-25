package lotto;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Optional;

import static lotto.AutoLottoPublisher.MIN_AMOUNT;
import static lotto.Validator.createIllegalArgumentException;

public class WinningLotto extends Lotto {

    private final int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonusNumber) {
        if (isContains(bonusNumber)) throw createIllegalArgumentException("보너스 번호가 당첨 번호에 이미 존재합니다.");
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public double getRateOfReturn(List<Lotto> lottoList, EnumMap<Rank, Integer> rankMap) {
        double result = 0.0;

        for (Lotto lotto : lottoList) {
            List<Integer> numbers = lotto.getNumbers();
            int count = (int) numbers.stream().filter(this::isContains).count();
            boolean correctBonus = numbers.stream().anyMatch(this::isBonusNumber);

            Optional<Rank> optRank = Arrays.stream(Rank.values())
                    .filter(r -> r.hasRank(count, correctBonus))
                    .findFirst();

            if (optRank.isPresent()) {
                Rank rank = optRank.get();
                rankMap.put(rank, rankMap.getOrDefault(rank, 0) + 1);
                result += rank.getAmount();
            }
        }

        return round(result, lottoList.size());
    }

    private double round(double result, int num) {
        return Math.round(result / (num * MIN_AMOUNT) * 10) / 10.0;
    }

    private boolean isBonusNumber(int n) {
        return n == bonusNumber;
    }

    @Override
    public String toString() {
        return super.toString() + " + " + bonusNumber;
    }
}
