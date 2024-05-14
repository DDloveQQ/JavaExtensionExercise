package ThreadCommunication;

public class Task03 {
    public static void main(String[] args) {
        BankAccount2 ba2 = new BankAccount2("AAA", 1000);
        Man man = new Man(ba2, "老王");
        Woman woman = new Woman(ba2, "花花");
        man.start();
        woman.start();
    }
}

class Man extends Thread {
    private BankAccount2 BA2;

    public Man(BankAccount2 BA2, String name) {
        super(name);
        this.BA2 = BA2;
    }

    @Override
    public void run() {
        while (true) {  // while(true)保证程序一直执行
            BA2.save(Math.random() * 10000);
            try {
                Thread.sleep(1000);  // 控制输出节奏
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Woman extends Thread {
    private BankAccount2 BA2;

    public Woman(BankAccount2 BA2, String name) {
        super(name);
        this.BA2 = BA2;
    }

    @Override
    public void run() {
        while (true) {  // while(true)保证程序一直执行
            BA2.withdraw(Math.random() * 10000);
            try {
                Thread.sleep(1000);  // 控制输出节奏
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}