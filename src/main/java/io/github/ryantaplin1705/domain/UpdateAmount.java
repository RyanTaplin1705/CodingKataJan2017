package io.github.ryantaplin1705.domain;

public class UpdateAmount {
    public final int amount;

    public UpdateAmount(int amount) {
        this.amount = amount;
    }

    public void print(TransactionReference reference) {
        String appendValue = "";
        if (amount > 0)
            appendValue = " deposited ";
        if (amount < 0)
            appendValue = " withdrew ";
        if (!reference.checkDefault() && amount > 0)
            appendValue = " sent ";
        if (!reference.checkDefault() && amount < 0)
            appendValue = " received ";

        System.out.print(appendValue + "£" + makeIntegerPositive(amount) + " ");
    }

    private int makeIntegerPositive(int amount) {
        if (amount < 0)
            return -amount;
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UpdateAmount that = (UpdateAmount) o;

        return amount == that.amount;
    }

    @Override
    public int hashCode() {
        return amount;
    }
}
