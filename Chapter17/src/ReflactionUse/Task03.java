package ReflactionUse;

import java.lang.reflect.Method;

// 调用方法
public class Task03 {
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("java.time.LocalDate"); // 先用Class获取类
        Method nowMethod = clazz.getMethod("now");  // 再用Method获取类的方法
        Object obj = nowMethod.invoke(null);  // 最后用Object对象调用Method方法并为其赋予参数
        System.out.println("obj = " + obj);

        Method plusDaysMethod = clazz.getMethod("plusDays", long.class);
        Object obj2 = plusDaysMethod.invoke(obj, 1000);
        System.out.println("obj2 = " + obj2);
    }
}
