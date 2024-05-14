package ThreadCreate;

public class OddAndEven1 {
    public static void main(String[] args) {
        new Thread("子线程") {
            @Override
            public void run() {
                for (int i = 0; i < 100; i += 2) {
                    System.out.println(getName() + "->" + i);
                }
            }
        }.start();
        for (int i = 1; i < 100; i += 2) {
            System.out.println("main主线程" + "->" + i);
        }
    }
}
