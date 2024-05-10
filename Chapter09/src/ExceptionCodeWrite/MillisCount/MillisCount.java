package ExceptionCodeWrite.MillisCount;

public class MillisCount {
    public static void main(String[] args) {
        try {
            for (int i = 10; i > 0; i--) {
                System.out.println("倒计时还剩: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("时间到!");
        }
    }

//    public static void main(String[] args) {
//        for (int i = 10; i >=1 ; i--) {
//            System.out.println(i);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        System.out.println("新年到！");
//    }
}
