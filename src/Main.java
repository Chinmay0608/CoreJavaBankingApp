import javax.swing.*;
import java.util.*;

public class Main{
    public static void main(String[] args) {
        Bank myBank = new Bank();

        Scanner scan = new Scanner(System.in);

        while (true){
            System.out.println("\n1.Create Account ");
            System.out.println("2.Deposit ");
            System.out.println("3.Withdraw ");
            System.out.println("4.Check Balance ");
            System.out.println("5.Transaction History");
            System.out.println("6.Exit ");
            System.out.println("Enter Your Choice ");
            int choice = scan.nextInt();
            scan.nextLine();
            switch(choice){
                case 1:
                    System.out.println("Enter Account Holder Name : ");
                    String accountHolderName = scan.nextLine();

                    System.out.println("Enter Initial Balance : ");
                    double initialBalance = scan.nextInt();
                    myBank.createAccount(accountHolderName,initialBalance);
                    break;

                case 2:
                    System.out.println("Enter account Number : ");
                    long accountNumber = scan.nextLong();
                    scan.nextLine();

                    Account accountToDeposit = myBank.getAccount(accountNumber);
                    if(accountToDeposit != null){
                        System.out.println("Enter amount to deposit : ");
                        double amount = scan.nextDouble();
                        scan.nextLine();

                        accountToDeposit.deposit(amount);
                        System.out.println("Current Balance: " + accountToDeposit.getBalance());
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 3:
                    System.out.println("Enter account Number : ");
                    accountNumber = scan.nextLong();
                    scan.nextLine();

                    Account accountToWithdraw = myBank.getAccount(accountNumber);
                    if(accountToWithdraw != null){
                        System.out.println("Enter amount to withdraw : ");
                        double amount = scan.nextDouble();
                        scan.nextLine();

                        accountToWithdraw.withdraw(amount);
                        System.out.println("Current Balance: " + accountToWithdraw.getBalance());
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 4:
                    System.out.println("Enter account Number : ");
                    accountNumber = scan.nextLong();
                    scan.nextLine();

                    Account acc = myBank.getAccount(accountNumber);

                    if(acc != null){
                        System.out.println("Account Holder: " + acc.getAccountHolderName());
                        System.out.println("Current Balance: " + acc.getBalance());
                    }
                    else{
                        System.out.println("Account not found ");
                    }
                    break;

                case 5:
                    System.out.println("Enter account Number to view history : ");
                    accountNumber = scan.nextLong();
                    scan.nextLine();

                    Account accountToView = myBank.getAccount(accountNumber);

                    if(accountToView != null) {
                        System.out.println("\n--- Transaction History for Account #" + accountNumber);
                        List<Transaction> history = accountToView.getTransactionHistory();

                        if (history.isEmpty()) {
                            System.out.println("No transactions found for this account");
                        } else {
                            for (Transaction tx : history) {
                                System.out.println(tx.getTransactionSummary());
                            }
                        }
                        System.out.println("------------------------------------------------");
                    }else {
                        System.out.println("Account not found");
                    }
                    break;

                case 6:
                    System.out.println("Thank you for using the banking app!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

    }
}