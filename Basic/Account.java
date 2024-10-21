import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

class Account {
    int accno;
    String accname;
    double balance;

    // Constructor to initialize account details
    public Account(int accno, String accname, double balance) {
        this.accno = accno;
        this.accname = accname;
        this.balance = balance;
    }

    // Method to display account details
    public void displayAccount() {
        System.out.println("Account No: " + accno + ", Account Name: " + accname + ", Balance: " + balance);
    }

    // Static method to sort accounts by balance
    public static void sortAccount(Account[] accounts) {
        Arrays.sort(accounts, Comparator.comparingDouble(a -> a.balance));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of accounts: ");
        int n = scanner.nextInt();

        Account[] accounts = new Account[n];

        // Accept account details
        for (int i = 0; i < n; i++) {
            System.out.print("Enter Account No: ");
            int accno = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter Account Name: ");
            String accname = scanner.nextLine();
            System.out.print("Enter Balance: ");
            double balance = scanner.nextDouble();

            accounts[i] = new Account(accno, accname, balance);
        }

        // Sort the accounts by balance
        Account.sortAccount(accounts);

        // Display sorted account details
        System.out.println("\nAccounts sorted by balance:");
        for (Account account : accounts) {
            account.displayAccount();
        }

        scanner.close();
    }
}
