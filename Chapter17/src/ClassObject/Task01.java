package ClassObject;
import java.time.LocalDate;

// 使用4种方式获取java.time.LocalDate类的Class对象，并打印输出。
public class Task01 {
    public static void main(String[] args) {
        try {
            Class c1 = LocalDate.class;  // 通过类的静态属性 class 获取
            Class c2 = LocalDate.now().getClass();  // 通过对象的 getClass() 方法获取
            Class c3 = Class.forName("java.time.LocalDate");  // 通过反射机制动态获取，并会初始化类
            Class c4 = ClassLoader.getSystemClassLoader().loadClass("java.time.LocalDate");  // 通过类加载器动态获取，但不会初始化类

            System.out.println("c1 = " + c1);
            System.out.println("c2 = " + c2);
            System.out.println("c3 = " + c3);
            System.out.println("c4 = " + c4);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
