package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ValidTest {

    @DisplayName("구입 금액이 숫자이면서 1,000원 단위여야 한다.")
    @Test
    void inputPurchaseAmountTest_success() {
        //g
        String inputMoney = "8000";

        //w
        int checkedMoney = Validator.checkInputMoney(inputMoney);

        //t
        assertThat(checkedMoney).isEqualTo(8000);
    }

    @DisplayName("구입 금액이 숫자가 아니라면 예외가 발생한다.")
    @Test
    void inputPurchaseAmountTest_fail_NumberFormat() {
        //g
        String inputMoney = "1000abc";

        //t
        assertThatThrownBy(() -> Validator.checkInputMoney(inputMoney)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1,000원 단위가 아니라면 예외가 발생한다.")
    @Test
    void inputPurchaseAmountTest_fail_amount() {
        //g
        String inputMoney = "35233";

        //t
        assertThatThrownBy(() -> Validator.checkInputMoney(inputMoney)).isInstanceOf(IllegalArgumentException.class);
    }
}
