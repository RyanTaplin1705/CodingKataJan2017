package io.github.ryantaplin1705.domain;

public class Balance {

    public final int total;

    public Balance(int total) {
        this.total = total;
    }

    public void print() {
        System.out.print("your new balance is £" + total + ".");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Balance balance = (Balance) o;

        return total == balance.total;
    }

    @Override
    public int hashCode() {
        return total;
    }
}
