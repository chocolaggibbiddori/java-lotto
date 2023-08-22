package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("주어진 금액에 맞는 로또 리스트를 발행한다.")
    @Test
    void createLotto() {
        //g
        int money = 8000;
        LottoPublish lottoPublish = new AutoLottoPublisher();

        //w
        List<Lotto> lottoList = lottoPublish.createLottoList(money);

        //t
        System.out.println(lottoList);
        assertThat(lottoList.size()).isEqualTo(8);
    }
}
