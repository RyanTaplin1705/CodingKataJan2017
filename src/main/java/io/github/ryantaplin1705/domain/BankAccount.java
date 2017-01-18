package io.github.ryantaplin1705.domain;

public class BankAccount {

    public Balance balance;

    public BankAccount() {
        balance = new Balance(0);
    }

    public void deposit(int money) {
        Balance currentBalance = balance;
        balance = new Balance(currentBalance.total + money);
    }
}
