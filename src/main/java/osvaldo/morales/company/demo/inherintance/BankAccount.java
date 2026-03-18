package osvaldo.morales.company.demo.inherintance;

public abstract class BankAccount implements Withdrawable{

     protected String owner;
     public double balance;

    // ✅ Abstract classes CAN have constructors
    public BankAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    // Concrete method (shared behavior)
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    // Abstract method (must be implemented)
    public abstract void withdraw(double amount);

}