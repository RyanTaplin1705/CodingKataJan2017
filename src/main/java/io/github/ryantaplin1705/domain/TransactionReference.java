package io.github.ryantaplin1705.domain;

public class TransactionReference {
    private final String reference;

    public TransactionReference(String reference) {
        this.reference = reference;
    }

    public boolean checkDefault() {
        return reference == "" || reference == "ATM";
    }

    public void print() {
        System.out.print(reference);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransactionReference that = (TransactionReference) o;

        return reference != null ? reference.equals(that.reference) : that.reference == null;

    }

    @Override
    public int hashCode() {
        return reference != null ? reference.hashCode() : 0;
    }
}
