package ReflactionUse;

import java.lang.reflect.Constructor;

// 创建对象
public class Task02 {
    public static void main(String[] args) throws Exception {
        test02();
    }

    public static void test01() throws Exception {
        Class clazz = Class.forName("java.util.Date");
        Object now = clazz.newInstance();
        System.out.println(now);
    }

    // JDK < 9.0
    public static void test02() throws Exception {
        Class clazz = Class.forName("java.time.LocalDate");
        Constructor constructor = clazz.getDeclaredConstructor(int.class, int.class, int.class);
        constructor.setAccessible(true);
        Object obj = constructor.newInstance(2024, 5, 23);
        System.out.println("obj = " + obj);
    }
}
