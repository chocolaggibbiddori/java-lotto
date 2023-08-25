package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.AutoLottoPublisher.LOTTO_NUM;

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
        Set<Integer> numbers = new HashSet<>();
        String[] split = inputWinningNumbers.split(",");

        checkWinningNumbersSize(split);
        for (String str : split) {
            str = str.trim();
            checkNumberFormat(str);
            int number = checkNumberOutOfRangeAndReturn(str);
            numbers.add(number);
        }

        checkDuplicated(numbers);
        return new ArrayList<>(numbers);
    }

    private static void checkWinningNumbersSize(String[] split) {
        if (split.length != LOTTO_NUM) throw createIllegalArgumentException("6개의 숫자를 입력해주세요.");
    }

    private static void checkNumberFormat(String str) {
        if (str.matches(".*\\D.*")) throw createIllegalArgumentException("숫자로 입력해주세요.");
    }

    private static int checkNumberOutOfRangeAndReturn(String str) {
        int i = Integer.parseInt(str);
        if (i < 1 || i > 45) throw createIllegalArgumentException("1-45 사이의 숫자를 입력해주세요.");
        return i;
    }

    private static void checkDuplicated(Set<Integer> numbers) {
        if (numbers.size() != LOTTO_NUM) throw createIllegalArgumentException("중복된 숫자가 입력되었습니다.");
    }

    public static int checkBonusNumberAndReturn(String inputBonusNumber) {
        checkNumberFormat(inputBonusNumber);
        return checkNumberOutOfRangeAndReturn(inputBonusNumber);
    }
}
