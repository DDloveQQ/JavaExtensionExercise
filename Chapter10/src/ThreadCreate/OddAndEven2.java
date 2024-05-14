package ThreadCreate;

public class OddAndEven2 {
    public static void main(String[] args) {
        PrintEvenThread even = new PrintEvenThread();
        PrintOddThread odd = new PrintOddThread();
        even.start();
        odd.start();

        try {
            odd.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        even.stop();
    }
}
class PrintEvenThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i <= 100; i += 2) {
            System.out.println("偶数线程" + "->" + i);
            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class PrintOddThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 100; i += 2) {
            System.out.println("奇数线程" + "->" + i);
        }
    }
}