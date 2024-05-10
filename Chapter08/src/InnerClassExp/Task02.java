package InnerClassExp;

// Thread、Runnable的匿名实现类

public class Task02 {
    public static void main(String[] args) {
        new Thread("张三") {
            @Override
            public void run() {
                System.out.println(this.getName() + "爱尚硅谷");
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("尚硅谷爱我");
            }
        }).start();
    }
}
