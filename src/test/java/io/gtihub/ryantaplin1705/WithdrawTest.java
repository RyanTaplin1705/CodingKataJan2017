package io.gtihub.ryantaplin1705;

import io.github.ryantaplin1705.domain.*;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.mockito.Mockito.*;

public class WithdrawTest {

    private static final LocalDateTime NOW = LocalDateTime.now();

    private final Statement statement = mock(Statement.class);
    private final Clock clock = mock(Clock.class);

    @Before
    public void before() {
        when(clock.now()).thenReturn(NOW);
    }

    @Test
    public void shouldWithdrawFromBankAccount() throws Exception {
        BankAccount account = new BankAccount(statement, clock);
        account.deposit(500); // better way to add initial currency?

        account.withdraw(100);
        verify(statement).addTransaction(new TransactionEvent(NOW, new Transaction(new TransactionReference("ATM"), new TransactionDetails(new UpdateAmount(-100), new Balance(400)))));
    }

    @Test
    public void shouldNotWithdrawUnavailableAmount() throws Exception {
        BankAccount account = new BankAccount(statement, clock);

        account.withdraw(100);
        verifyZeroInteractions(statement);
    }
}
