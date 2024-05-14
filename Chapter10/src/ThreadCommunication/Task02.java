package ThreadCommunication;

public class Task02 {
    public static void main(String[] args) {
        BankAccount ba = new BankAccount();
        Husband hb = new Husband(ba);
        Wife wf = new Wife(ba);
        hb.start();
        wf.start();
    }
}
class Husband extends Thread{
    private BankAccount account;

    public Husband(BankAccount account) {
        super();
        this.account = account;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (Thread.class) {  // 同步代码块
                double money = Math.random() * 10000;
                System.out.println("丈夫开始存钱,目前账户状态: " + account);
                System.out.println("丈夫本次存钱: " + money);
                account.setBalance(account.getBalance() + money);
                System.out.println("丈夫存钱结束,目前账户状态: " + account);
                System.out.println();
                Thread.class.notify();
                try {
                    Thread.sleep(1000);
                    Thread.class.wait();  // 使用notify-wait方法可以使存钱和取钱动作同步,如果注解这两行,则存钱和取钱随机产生
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                Thread.class.notify();
            }
        }
    }
}

class Wife extends Thread {
    private BankAccount account;

    public Wife(BankAccount account) {
        super();
        this.account = account;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (Thread.class) {
                double money = Math.random() * 10000;
                System.out.println("老婆开始取钱,目前账户状态: " + account);
                System.out.println("老婆本次取钱: " + money);
                if (money > account.getBalance()) {
                    System.out.println("余额不足");
                } else {
                    account.setBalance(account.getBalance() - money);
                }
                System.out.println("老婆取钱结束,目前账户状态: " + account);
                System.out.println();
                Thread.class.notify();
                try {
                    Thread.sleep(1000);
                    Thread.class.wait();  // 使用notify-wait方法可以使存钱和取钱动作同步,如果注解这两行,则存钱和取钱随机产生
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                Thread.class.notify();
            }
        }
    }
}
