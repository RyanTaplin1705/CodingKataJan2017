package io.github.ryantaplin1705.domain;

public class UpdateAmount {
    public final int amount;

    public UpdateAmount(int amount) {
        this.amount = amount;
    }

    public void print() {
        System.out.print("Transaction: £" + amount + " ");
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
