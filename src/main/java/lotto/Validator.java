package lotto;

public class Validator {

    private static final String ERROR_MESSAGE = "[ERROR] ";

    private Validator() {
    }

    public static int checkInputMoney(String inputMoney) {
        int money = checkNumberFormat(inputMoney);
        checkAmount(money);
        return money;
    }

    private static int checkNumberFormat(String inputMoney) {
        int money;

        try {
            money = Integer.parseInt(inputMoney);
        } catch (NumberFormatException e) {
            throw createIllegalArgumentException("구매 금액이 숫자가 아닙니다.", e);
        }

        return money;
    }

    private static void checkAmount(int money) {
        if (money % 1000 != 0) throw createIllegalArgumentException("구매 금액이 1,000원 단위가 아닙니다.");
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
}
