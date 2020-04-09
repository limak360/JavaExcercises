package pl.kamiljacko.threads;


public class Challanges {
    public static void main(String[] args) {

        BankAccount account = new BankAccount("12345-678", 1000.00);

        new Thread(() -> {
            account.deposit(300);
            account.withdraw(50);
            System.out.println("Transaction for " + account.getAccountNumber());
        }).start();

        new Thread(() -> {
            account.deposit(203.75);
            account.withdraw(100);
            System.out.println("Transaction for " + account.getAccountNumber());
        }).start();
    }
}


