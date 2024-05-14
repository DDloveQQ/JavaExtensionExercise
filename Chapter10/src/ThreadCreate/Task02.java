package ThreadCreate;

public class Task02 {
    public static void main(String[] args) {
        PrintLetter pl = new PrintLetter();
        new Thread() {
            @Override
            public void run() {
                while (true) {  // 使后续程序进入无限循环状态,否则pl.printLower()只会被执行一次
                    pl.printLower();
                    try {
                        Thread.sleep(1000); // 控制输出节奏
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                while (true) {  // 使后续程序进入无限循环状态,否则pl.printUpper()只会被执行一次
                    pl.printUpper();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }.start();
    }
}

class PrintLetter {
    private char letter = 'a';

    // 负责打印小写字母
    public synchronized void printLower() {
        for (int i = 0; i < 3; i++) {
            if (letter > 'z') {
                letter = 'a';
            }
            System.out.println(Thread.currentThread().getName() + " -> " + letter++);
        }
        this.notify();
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("thread0唤醒");
        }
    }

    // 负责打印大写字母
    public synchronized void printUpper() {
        for (int i = 0; i < 3; i++) {
            if (letter > 'z') {
                letter = 'a';
            }
            System.out.println(Thread.currentThread().getName() + " -> " + (char)(letter - 32));
            letter++;
        }
        this.notify();
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("thread1唤醒");
        }
    }
}