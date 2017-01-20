package io.github.ryantaplin1705.domain;

public class Transaction {
    private final UpdateAmount amount;
    private final Balance newBalance;

    public Transaction(UpdateAmount amount, Balance newBalance) {
        this.amount = amount;
        this.newBalance = newBalance;
    }

    public void print(String transactionInfo) {
        System.out.print("! " + transactionInfo + " -- ");
        amount.print();
        newBalance.print();
        System.out.println("");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;

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
