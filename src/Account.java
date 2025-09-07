import java.util.*;

public class Account {
    private final long accountNumber;
    private final String accountHolderName;
    private double balance;

    public List<Transaction> getTransactionHistory() {
        return this.transactionHistory;
    }

    private List<Transaction> transactionHistory;

    public Account(long accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.transactionHistory = new ArrayList<>();
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount){
        if(amount <= 0){
            System.out.println("Invalid deposit : "+amount);
            return;
        }
        balance+=amount;
        Transaction newTransaction = new Transaction("Deposit : ",amount);
        this.transactionHistory.add(newTransaction);
        System.out.println("Deposited : "+amount);
    }

    public void withdraw(double amount){
        if(amount > balance || amount <=0 ){
            System.out.println("Invalid withdraw or Insufficient balance "+ amount);
            return;
        }
        balance-=amount;
        Transaction newTransaction = new Transaction("Withdrawal : ",amount);
        this.transactionHistory.add(newTransaction);
        System.out.println("Withdrew : "+amount);
    }
}
