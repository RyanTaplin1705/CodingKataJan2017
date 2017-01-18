package io.gtihub.ryantaplin1705;

import io.github.ryantaplin1705.domain.*;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DepositTest {

    private static final LocalDateTime NOW = LocalDateTime.now();

    private final Statement statement = mock(Statement.class);
    private final Clock clock = mock(Clock.class);

    @Before
    public void before() {
        when(clock.now()).thenReturn(NOW);
    }

    @Test
    public void shouldDepositIntoBankAccount() throws Exception {
        BankAccount account = new BankAccount(statement, clock);

        account.deposit(100);
        verify(statement).addTransaction(new TransactionEvent(NOW, new Transaction(new UpdateAmount(100), new Balance(100))));
    }

    @Test
    public void shouldHandleDepositingZeroValue() throws Exception {
        BankAccount account = new BankAccount(statement, clock);

        account.deposit(0);
        verify(statement).addTransaction(new TransactionEvent(NOW, new Transaction(new UpdateAmount(0), new Balance(0))));
    }
}
