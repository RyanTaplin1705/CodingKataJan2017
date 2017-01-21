package io.gtihub.ryantaplin1705;

import io.github.ryantaplin1705.domain.*;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TransferTest {

    private static final LocalDateTime NOW = LocalDateTime.now();

    private final Statement statement = mock(Statement.class);
    private final Statement statement2 = mock(Statement.class);
    private final Clock clock = mock(Clock.class);

    @Before
    public void before() {
        when(clock.now()).thenReturn(NOW);
    }

    @Test
    public void shouldTransferMoneyIntoBankAccount() throws Exception {
        BankAccount account = new BankAccount(statement, clock);
        BankAccount account2 = new BankAccount(statement2, clock);

        account.deposit(100);
        account.transfer(account2, 30);

        verify(statement2).addTransaction(new TransactionEvent(NOW, new Transaction(new TransactionReference(account.toString()), new TransactionDetails(new UpdateAmount(30), new Balance(30)))));
        verify(statement).addTransaction(new TransactionEvent(NOW, new Transaction(new TransactionReference(account2.toString()), new TransactionDetails(new UpdateAmount(-30), new Balance(70)))));
    }
}
