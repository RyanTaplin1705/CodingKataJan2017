package io.github.ryantaplin1705.domain;

public class TransactionDetails {
    private final UpdateAmount amount;
    private final Balance newBalance;

    public TransactionDetails(UpdateAmount amount, Balance newBalance) {
        this.amount = amount;
        this.newBalance = newBalance;
    }

    public void print(TransactionReference reference) {
        amount.print(reference);
        newBalance.print();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransactionDetails that = (TransactionDetails) o;

        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        return newBalance != null ? newBalance.equals(that.newBalance) : that.newBalance == null;

    }

    @Override
    public int hashCode() {
        int result = amount != null ? amount.hashCode() : 0;
        result = 31 * result + (newBalance != null ? newBalance.hashCode() : 0);
        return result;
    }
}
