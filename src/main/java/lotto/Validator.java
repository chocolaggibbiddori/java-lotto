package lotto;

import java.util.ArrayList;
import java.util.List;

public class Validator {

    private static final String ERROR_MESSAGE = "[ERROR] ";

    private Validator() {
    }

    public static int checkInputMoneyAndReturn(String inputMoney) {
        int money = checkNumberFormatAndReturn(inputMoney);
        checkAmount(money);
        return money;
    }

    private static int checkNumberFormatAndReturn(String inputMoney) {
        checkNumberFormat(inputMoney);
        return Integer.parseInt(inputMoney);
    }

    private static void checkAmount(int money) {
        if (money % AutoLottoPublisher.MIN_AMOUNT != 0) throw createIllegalArgumentException("구매 금액이 1,000원 단위가 아닙니다.");
    }

    public static IllegalArgumentException createIllegalArgumentException(String message) {
        return new IllegalArgumentException(createErrorMessage(message));
    }

    public static IllegalArgumentException createIllegalArgumentException(String message, Throwable cause) {
        return new IllegalArgumentException(createErrorMessage(message), cause);
    }

    public static String createErrorMessage(String message) {
        return ERROR_MESSAGE + message;
    }

    public static List<Integer> checkInputWinningNumbersAndReturn(String inputWinningNumbers) {
        List<Integer> numbers = new ArrayList<>();
        String[] split = inputWinningNumbers.split(",");

        checkWinningNumbersSize(split);
        for (String str : split) {
            str = str.trim();
            checkNumberFormat(str);
            int number = checkNumberOutOfRangeAndReturn(str);
            numbers.add(number);
        }

        return numbers;
    }

    private static void checkWinningNumbersSize(String[] split) {
        if (split.length != AutoLottoPublisher.LOTTO_NUM) throw createIllegalArgumentException("6개의 숫자를 입력해주세요.");
    }

    private static void checkNumberFormat(String str) {
        if (str.matches("\\D")) throw createIllegalArgumentException("숫자를 입력해주세요.");
    }

    private static int checkNumberOutOfRangeAndReturn(String str) {
        int i = Integer.parseInt(str);
        if (i < 1 || i > 45) throw createIllegalArgumentException("1-45 사이의 숫자를 입력해주세요.");
        return i;
    }

    public static int checkBonusNumberAndReturn(String inputBonusNumber) {
        checkNumberFormat(inputBonusNumber);
        return checkNumberOutOfRangeAndReturn(inputBonusNumber);
    }
}
