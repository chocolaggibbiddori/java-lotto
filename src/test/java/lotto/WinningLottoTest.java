package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {

    @DisplayName("올바른 당첨 번호 및 보너스 번호를 입력해야 WinningLoto 객체가 생성된다.")
    @Test
    void createWinningLotto_Success() {
        //g
        List<Integer> winningNumberList = List.of(1, 3, 5, 7, 9, 11);
        int bonusNumber = 2;

        //w
        WinningLotto winningLotto = new WinningLotto(winningNumberList, bonusNumber);
        int findBonusNumber = winningLotto.getBonusNumber();

        //t
        System.out.println("winningLotto = " + winningLotto);
        assertThat(findBonusNumber).isEqualTo(bonusNumber);
    }

    @DisplayName("로또를 입력 받아 수익률을 계산하고, 당첨 통계를 출력한다.")
    @Test
    void calculateRateOfReturn() {
        //g
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(2, 3, 4, 5, 6, 7));
        Lotto lotto3 = new Lotto(List.of(3, 4, 5, 6, 7, 8));
        Lotto lotto4 = new Lotto(List.of(10, 20, 30, 40, 43, 45));
        Lotto lotto5 = new Lotto(List.of(20, 25, 30, 35, 40, 45));
        Lotto lotto6 = new Lotto(List.of(21, 24, 27, 31, 37, 43));
        List<Lotto> lottoList = List.of(lotto1, lotto2, lotto3, lotto4, lotto5, lotto6);

        List<Integer> winningNumberList1 = List.of(4, 6, 2, 5, 3, 1);
        WinningLotto winningLotto1 = new WinningLotto(winningNumberList1, 8);

        List<Integer> winningNumberList2 = List.of(3, 7, 5, 4, 6, 10);
        WinningLotto winningLotto2 = new WinningLotto(winningNumberList2, 8);

        List<Integer> winningNumberList3 = List.of(6, 7, 8, 9, 10, 11);
        WinningLotto winningLotto3 = new WinningLotto(winningNumberList3, 12);

        //w
        double rateOfReturn1 = winningLotto1.rateOfReturn(lottoList);
        double rateOfReturn2 = winningLotto2.rateOfReturn(lottoList);
        double rateOfReturn3 = winningLotto3.rateOfReturn(lottoList);

        //t
        assertThat(rateOfReturn1).isEqualTo(333583.3); // 2,001,500,000 / 6,000
        assertThat(rateOfReturn2).isEqualTo(5258.3); // 31,550,000 / 6,000
        assertThat(rateOfReturn3).isEqualTo(0.8); // 5,000 / 6,000
    }
}
