package lotto;

import java.text.NumberFormat;

public enum Rank implements Comparable<Rank> {

    FIFTH(3, false, 5000),
    FOURTH(4, false, 50000),
    THIRD(5, false, 1500000),
    SECOND(5, true, 30000000),
    FIRST(6, false, 2000000000);

    private final int value;
    private final boolean bonus;
    private final long amount;
    private final String amountStr;

    Rank(int value, boolean bonus, int amount) {
        this.value = value;
        this.bonus = bonus;
        this.amount = amount;
        this.amountStr = NumberFormat.getIntegerInstance().format(amount);
    }

    public boolean hasRank(int value, boolean bonus) {
        return this.value == value && this.bonus == bonus;
    }

    public int getValue() {
        return value;
    }

    public boolean isBonus() {
        return bonus;
    }

    public long getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        if (bonus) return value + "개 일치, 보너스 볼 일치 (" + amountStr + "원)";
        return value + "개 일치 (" + amountStr + "원)";
    }
}
