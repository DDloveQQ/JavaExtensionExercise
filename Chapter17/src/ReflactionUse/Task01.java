package ReflactionUse;

import java.lang.reflect.Field;

// 注意：此程序只可运行于JDK < 9.0的环境，因为新JDK为了降低安全风险所以禁止了通过反射修改private字段
public class Task01 {
    public static void main(String[] args) throws Exception {
        String str = "hello";

        Class clazz = str.getClass();
        Field valueField = clazz.getDeclaredField("value");
        valueField.setAccessible(true);
        char[] value = (char[]) valueField.get(str);
        value[1] = 'a';
        System.out.println("str = " + str);
    }
}
