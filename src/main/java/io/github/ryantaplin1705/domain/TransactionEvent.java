package io.github.ryantaplin1705.domain;

import java.time.LocalDateTime;

public class TransactionEvent {

    private final LocalDateTime transactionDate;
    private final Transaction transaction;

    public TransactionEvent(LocalDateTime transactionDate, Transaction transaction) {
        this.transactionDate = transactionDate;
        this.transaction = transaction;
    }

    public void print() {
        transaction.print(transactionDate.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransactionEvent that = (TransactionEvent) o;

        if (!transactionDate.equals(that.transactionDate)) return false;
        return transaction.equals(that.transaction);
    }

    @Override
    public int hashCode() {
        int result = transactionDate.hashCode();
        result = 31 * result + transaction.hashCode();
        return result;
    }
}
