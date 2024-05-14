package ThreadCommunication;

public class BankAccount {
    private String ID;
    private double balance;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "ID='" + ID + '\'' +
                ", balance=" + balance +
                '}';
    }
}
