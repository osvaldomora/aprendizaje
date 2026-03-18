package osvaldo.morales.company.demo.inherintance;

public class SavingsAccount extends BankAccount {

    private final String testVariable ;

    public SavingsAccount(String owner, double balance, String testVariable) {
        super(owner, balance);

        this.testVariable = testVariable;
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient funds");
        }
    }

    public static void printName() {
        SavingsAccount savingsAccount = new SavingsAccount("",12,"");
        System.out.println(savingsAccount.testVariable); // ❌ compile-time error
    }

    @Override
    public void withdraw2(double amount) {
        //this should be implemented by concret class
    }
}