package io.gtihub.ryantaplin1705;

import io.github.ryantaplin1705.domain.BankAccount;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DepositTest {

    @Test
    public void shouldDepositIntoBankAccount() throws Exception {
        BankAccount account = new BankAccount();

        account.deposit(100);
        assertThat(account.balance.total).isEqualTo(100);
    }

    @Test
    public void shouldHandleDepositingZeroValue() throws Exception {
        BankAccount account = new BankAccount();

        account.deposit(0);
        assertThat(account.balance.total).isEqualTo(0);
    }
}
