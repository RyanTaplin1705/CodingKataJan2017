package io.github.ryantaplin1705.domain;

public class BankAccount {

    // TODO Refactor so that we only have 2 collaborators. We currently have 3.
    private Balance balance;
    private Statement statement;
    private Clock clock;

    public BankAccount(Statement statement, Clock clock) {
        this.clock = clock;
        this.balance = new Balance(0);
        this.statement = statement;
    }

    public void deposit(int money) {
        Balance currentBalance = balance;
        balance = new Balance(currentBalance.total + money);

        statement.addTransaction(new TransactionEvent(clock.now(), new Transaction(new UpdateAmount(money), balance)));
    }
}
