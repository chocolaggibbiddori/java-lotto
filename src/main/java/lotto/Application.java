package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 1. 구입 금액을 입력 받는다.
        System.out.println("구매 금액을 입력해 주세요.");
        String inputMoney = Console.readLine();
        int money = Validator.checkInputMoney(inputMoney);
    }
}
