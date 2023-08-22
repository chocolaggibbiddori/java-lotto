package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ValidTest {

    @DisplayName("구입 금액이 숫자이면서 1,000원 단위여야 한다.")
    @Test
    void inputPurchaseAmountTest_success() {
        //g
        String inputMoney = "8000";

        //w
        int checkedMoney = Validator.checkInputMoneyAndReturn(inputMoney);

        //t
        assertThat(checkedMoney).isEqualTo(8000);
    }

    @DisplayName("구입 금액이 숫자가 아니거나 1,000원 단위가 아니라면 예외가 발생한다.")
    @ValueSource(strings = {"1000abc", "35233"})
    @ParameterizedTest
    void inputPurchaseAmountTest_fail_NumberFormat(String inputMoney) {
        //t
        assertThatThrownBy(() -> Validator.checkInputMoneyAndReturn(inputMoney)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호는 규격에 맞아야 한다.")
    @Test
    void inputWinningNumbers_Success() {
        //g
        String inputWinningNumbers = "1, 3, 5, 7, 9, 11";

        //w
        List<Integer> numbers = Validator.checkInputWinningNumbersAndReturn(inputWinningNumbers);

        //t
        System.out.println("numbers = " + numbers);
        assertThat(numbers.size()).isEqualTo(6);
    }

    @DisplayName("당첨 번호가 규격에 맞지 않으면 예외가 발생한다.")
    @ValueSource(strings = {"[1, 2, 3, 4, 5, 6,]", "0,1,3,7,50,70", "1,30, 45"})
    @ParameterizedTest
    void inputWinningNumbers_FailByGrammar(String inputWinningNumbers) {
        //t
        assertThatThrownBy(() -> Validator.checkInputWinningNumbersAndReturn(inputWinningNumbers)).isInstanceOf(IllegalArgumentException.class);
    }
}
