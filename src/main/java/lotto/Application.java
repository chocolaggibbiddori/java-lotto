package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static lotto.Validator.*;

public class Application {
    public static void main(String[] args) {
        // 1. 구입 금액을 입력 받는다.
        System.out.println("구매 금액을 입력해 주세요.");
        String inputMoney = Console.readLine();
        int money = checkInputMoneyAndReturn(inputMoney);

        // 2. 구입 금액에 맞는 로또를 발행한다.
        LottoPublish lottoPublish = new AutoLottoPublisher();
        List<Lotto> lottoList = lottoPublish.createLottoList(money);
        int lottoNum = lottoList.size();

        System.out.println(lottoNum + "개를 구매했습니다.");
        lottoList.forEach(System.out::println);

        // 3. 당첨 번호를 입력 받는다.
        String inputWinningNumbers = Console.readLine();
        List<Integer> winningNumberList = checkInputWinningNumbersAndReturn(inputWinningNumbers);

        // 4. 보너스 번호를 입력 받는다.
        String inputBonusNumber = Console.readLine();
        int bonusNumber = checkBonusNumberAndReturn(inputBonusNumber);

        WinningLotto winningLotto = new WinningLotto(winningNumberList, bonusNumber);
    }
}
