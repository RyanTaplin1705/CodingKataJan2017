package io.github.ryantaplin1705;

import io.github.ryantaplin1705.domain.BankAccount;
import io.github.ryantaplin1705.domain.Clock;
import io.github.ryantaplin1705.domain.Statement;

public class Main {

    private static final Statement statement = new Statement();
    private static final Clock clock = new Clock();

    public static void main(String[] args) {
        BankAccount account = new BankAccount(statement, clock);

        account.deposit(50);
        account.deposit(1000);
        account.withdraw(105);

        account.printStatement();

        System.out.print("Hello Tom :O!!!");
    }


    /*  TODO:: List
         1. Deposit & Withdraw [DONE]
         2. Transfer between accounts
         3. Account Statements (Date, Amount, newBalance)  [DONE]
         4. Statement Printing [DONE]
         5. Statement Filtering (Deposits, Withdrawals, Dates)


         Rules:
         1. One level of indentation.
         2. Don't use ELSE.
         3. Wrap primitives & strings (in classes).
         4. First class collection. ->>> ?
         5. One dot per line.
         6. No abbreviations.
         7. Maximum 50 lines per class.
         8. Maximum 2 instance variables.
         9. No getters/setters/properties.
    */
}
