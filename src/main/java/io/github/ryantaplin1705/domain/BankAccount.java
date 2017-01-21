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
        updateBalance(depositValue);
        if (isPositive(depositValue))
            statement.addTransaction(new TransactionEvent(clock.now(), new Transaction(new TransactionReference("ATM"), new TransactionDetails(new UpdateAmount(depositValue), balance))));
    }

    private void updateBalance(int money) {
        balance = new Balance(balance.total + money);
    }

    //TODO:: Remove property balance.total <-> conflicts with rule 9.
    public void withdraw(int withdrawValue) {
        updateBalance(-withdrawValue);
        if (isPositive(withdrawValue) && balance.total >= withdrawValue)
            statement.addTransaction(new TransactionEvent(clock.now(), new Transaction(new TransactionReference("ATM"), new TransactionDetails(new UpdateAmount(-withdrawValue), balance))));
    }

    public void printStatement() {
        statement.print();
    }

    public void transfer(BankAccount recipient, int transferValue) {
        if (!isPositive(transferValue)) return;
        updateBalance(-transferValue);
        recipient.receivePayment(this, transferValue);
        statement.addTransaction(new TransactionEvent(clock.now(), new Transaction(new TransactionReference(recipient.toString()), new TransactionDetails(new UpdateAmount(-transferValue), balance))));
    }

    private void receivePayment(BankAccount sender, int paymentValue) {
        updateBalance(paymentValue);
        statement.addTransaction(new TransactionEvent(clock.now(), new Transaction(new TransactionReference(sender.toString()), new TransactionDetails(new UpdateAmount(paymentValue), balance))));
    }

    private boolean isPositive(int value) {
        return value >= 0;
    }
}
