package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class AutoLottoPublisher implements LottoPublish {

    public static final int MIN_AMOUNT = 1000;
    public static final int LOTTO_NUM = 6;

    @Override
    public List<Lotto> createLottoList(int money) {
        List<Lotto> lottoList = new ArrayList<>();
        int lottoNum = money / MIN_AMOUNT;

        for (int i = 0; i < lottoNum; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            numbers.sort(Integer::compareTo);
            lottoList.add(new Lotto(numbers));
        }

        return lottoList;
    }
}
