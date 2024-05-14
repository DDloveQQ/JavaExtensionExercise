package ThreadCommunication;

public class Task01 {
    public static void main(String[] args) {
        PrintFunction pf = new PrintFunction();
        new Thread("奇数") {
            @Override
            public void run() {
                while (true) {
                    pf.printOdd();
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        new Thread("偶数") {
            @Override
            public void run() {
                while (true) {
                    pf.printEven();
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

    }
}
class PrintFunction {
    private int num = 1;

    public synchronized void printOdd() {
        System.out.println(Thread.currentThread().getName() + num++);
        this.notify();
        try {
            this.wait();
        } catch (InterruptedException e) {
           e.printStackTrace();
        }
    }

    public synchronized void printEven() {
        System.out.println(Thread.currentThread().getName() + num++);
        this.notify();
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}