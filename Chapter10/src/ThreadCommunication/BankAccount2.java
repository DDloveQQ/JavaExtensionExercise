package ThreadCommunication;

public class BankAccount2 {
    private final String ID;
    private double balance;

    public BankAccount2(String id, double balance) {
        ID = id;
        this.balance = balance;
    }

    public String getID() {
        return ID;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "BankAccount2{" +
                "ID='" + ID + '\'' +
                ", balance=" + balance +
                '}';
    }

    public synchronized void save(double money) {
        if (money > 0) {
            balance = balance + money;
            System.out.println("丈夫" + Thread.currentThread().getName() +"本次存钱" + money +"元，" + this);
        }
        this.notify();
    }

    public synchronized void withdraw(double money) {
        while (balance < money) { // 等到能取出钱为止,因此用while
            System.out.println("妻子" + Thread.currentThread().getName() +"本次想取钱" + money +"元，余额不足，等待...");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (balance >= money) {
            balance = balance - money;
            System.out.println("妻子" + Thread.currentThread().getName() +"本次取钱" + money +"元，" + this );
        }
    }
}
