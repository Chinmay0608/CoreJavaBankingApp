import java.util.*;

public class Bank {
    private final Map<Long,Account> accounts = new HashMap<>();

    private long nextAccountNumber = 10000;

    public Account createAccount(String accountHolderName, double balance){
        long newAccountNumber = nextAccountNumber++;

        Account newAccount = new Account(newAccountNumber,accountHolderName,balance);

        accounts.put(newAccountNumber,newAccount);

        System.out.println("Account created successfully for "+accountHolderName + " with account number "+ newAccountNumber);
        return newAccount;
    }
    public Account getAccount(long accountNumber){
        return accounts.get(accountNumber);
    }
}
