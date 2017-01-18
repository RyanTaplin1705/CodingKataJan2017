package io.github.ryantaplin1705.domain;

import java.util.ArrayList;
import java.util.List;

public class Statement {

    public final List<TransactionEvent> transactionEvents;

    public Statement() {
        this.transactionEvents = new ArrayList<>();
    }

    public void addTransaction(TransactionEvent transactionEvent) {
        transactionEvents.add(transactionEvent);
    }
}
