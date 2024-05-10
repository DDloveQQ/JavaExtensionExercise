package StaticExp;

public class BankAccount {
    private static double rate;
    private String id;
    private double balance;

    public BankAccount(String id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public static double getRate() {
        return rate;
    }

    public static void setRate(double rate) {
        BankAccount.rate = rate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double annualInterest() {
        return balance * rate;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id='" + id + '\'' +
                ", balance=" + balance +
                ", annualInterest=" + annualInterest() +
                '}';
    }

    public static void main(String[] args) {
        BankAccount bA1 = new BankAccount("111", 1000);
        BankAccount bA2 = new BankAccount("222", 2000);
        BankAccount.setRate(0.035);

        System.out.println(bA1);
        System.out.println(bA2);
    }
}
