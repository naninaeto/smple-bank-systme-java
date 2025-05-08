
import java.util.*;

class BankAccount {
    private final String accountNumber;
    private final String accountHolder;
    private double balance;

    public BankAccount(String accNo, String accHolder) {
        this.accountNumber = accNo;
        this.accountHolder = accHolder;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Invalid or insufficient balance.");
        }
    }

    public void showDetails() {
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + accountHolder);
        System.out.println("Balance        : $" + balance);
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}

public class BankSystem {
    private static final Map<String, BankAccount> accounts = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- BANK SYSTEM MENU ---");
            System.out.println("1. Create Account");
            System.out.println("2. View Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> createAccount();
                case 2 -> viewAccount();
                case 3 -> depositMoney();
                case 4 -> withdrawMoney();
                case 5 -> System.out.println("Thank you for using our bank system!");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 5);
    }

    private static void createAccount() {
        System.out.print("Enter Account Number: ");
        String accNo = scanner.nextLine();
        if (accounts.containsKey(accNo)) {
            System.out.println("Account already exists.");
            return;
        }
        System.out.print("Enter Account Holder Name: ");
        String accHolder = scanner.nextLine();
        BankAccount newAcc = new BankAccount(accNo, accHolder);
        accounts.put(accNo, newAcc);
        System.out.println("Account created successfully!");
    }

    private static void viewAccount() {
        System.out.print("Enter Account Number: ");
        String accNo = scanner.nextLine();
        BankAccount acc = accounts.get(accNo);
        if (acc != null) {
            acc.showDetails();
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void depositMoney() {
        System.out.print("Enter Account Number: ");
        String accNo = scanner.nextLine();
        BankAccount acc = accounts.get(accNo);
        if (acc != null) {
            System.out.print("Enter Amount to Deposit: ");
            double amount = scanner.nextDouble();
            acc.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void withdrawMoney() {
        System.out.print("Enter Account Number: ");
        String accNo = scanner.nextLine();
        BankAccount acc = accounts.get(accNo);
        if (acc != null) {
            System.out.print("Enter Amount to Withdraw: ");
            double amount = scanner.nextDouble();
            acc.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }
}
