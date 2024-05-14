package ThreadCreate;

public class Task01 {
    public static void main(String[] args) {
        Tunnel t = new Tunnel();
        for (int i = 1; i <= 10; i++) {
            new Thread(t, "p" + i).start();
        }
    }
}
class Tunnel implements Runnable {
    private int crossNum;

    @Override
    public void run() {
        cross();
    }

    public synchronized void cross() {
        System.out.println(Thread.currentThread().getName() + "开始通过隧道");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            crossNum++;
            System.out.println(Thread.currentThread().getName() + "已经通过隧道，TA是第" + crossNum + "个通过的");
        }
    }
}