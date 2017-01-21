package io.github.ryantaplin1705.domain;

public class Transaction {
    private final TransactionReference reference;
    private final TransactionDetails details;

    public Transaction(TransactionReference reference, TransactionDetails details) {
        this.reference = reference;
        this.details = details;
    }

    public void print(String transactionInfo) {
        System.out.print("! " + transactionInfo + " ");
        reference.print();
        details.print(reference);
        System.out.println("");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;

        if (reference != null ? !reference.equals(that.reference) : that.reference != null) return false;
        return details != null ? details.equals(that.details) : that.details == null;

    }

    @Override
    public int hashCode() {
        int result = reference != null ? reference.hashCode() : 0;
        result = 31 * result + (details != null ? details.hashCode() : 0);
        return result;
    }
}
