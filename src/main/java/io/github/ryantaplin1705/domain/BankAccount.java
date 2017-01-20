package io.github.ryantaplin1705.domain;

public class BankAccount {

    // TODO:: Refactor so that we only have 2 collaborators. We currently have 3 <-> conflicts with rule 8.
    private Balance balance;
    private Statement statement;
    private Clock clock;

    public BankAccount(Statement statement, Clock clock) {
        this.clock = clock;
        this.balance = new Balance(0);
        this.statement = statement;
    }


    //TODO:: Remove property balance.total <-> conflicts with rule 9.
    public void deposit(int depositValue) {
        balance = new Balance(balance.total + depositValue);

        if (checkIsPositive(depositValue))
            statement.addTransaction(new TransactionEvent(clock.now(), new Transaction(new UpdateAmount(depositValue), balance)));
    }

    //TODO:: Remove property balance.total <-> conflicts with rule 9.
    public void withdraw(int withdrawValue) {
        balance = new Balance(balance.total - withdrawValue);

        if (checkIsPositive(withdrawValue) && balance.total >= withdrawValue)
            statement.addTransaction(new TransactionEvent(clock.now(), new Transaction(new UpdateAmount(-withdrawValue), balance)));
    }

    private boolean checkIsPositive(int value) {
        if (value >= 0)
            return true;
        return false;
    }

    public void printStatement() {
        statement.print();
    }
}
