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
            throw new IllegalArgumentException(createErrorMessage("구매 금액이 숫자가 아닙니다."), e);
        }

        return money;
    }

    private static void checkAmount(int money) {
        if (money % 1000 != 0) throw new IllegalArgumentException(createErrorMessage("구매 금액이 1,000원 단위가 아닙니다."));
    }

    private static String createErrorMessage(String message) {
        return ERROR_MESSAGE + message;
    }
}
