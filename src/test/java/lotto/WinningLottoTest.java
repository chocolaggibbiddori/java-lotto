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
}
