package ReflactionUse;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Task04 {
    public static void main(String[] args) throws Exception {
        test();
    }
    public static void test() throws ClassNotFoundException {
        //1、先得到某个类型的Class对象
        Class clazz = Class.forName("java.time.LocalDate");

        //2、获取类信息
        //（1）获取包对象，即所有java的包，都是Package的对象
        Package pkg = clazz.getPackage();
        System.out.println("包名：" + pkg.getName());

        //（2）获取修饰符
        int mod = clazz.getModifiers();
        System.out.println("类的修饰符有：" + Modifier.toString(mod));

        //（3）类型名
        String name = clazz.getName();
        System.out.println("类名：" + name);

        //（4）父类，父类也有父类对应的Class对象
        Class superclass = clazz.getSuperclass();
        System.out.println("父类：" + superclass);

        //（5）父接口们
        System.out.println("父接口们：");
        Class[] interfaces = clazz.getInterfaces();
        for (Class iter : interfaces) {
            System.out.println(iter);
        }

        //（6）类的属性，你声明的一个属性，就是一个Field的对象
        System.out.println("------------------------------");
        System.out.println("成员如下：");
        System.out.println("属性有：");
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            //修饰符、数据类型、属性名
            int modifiers = field.getModifiers();
            System.out.println("属性的修饰符：" + Modifier.toString(modifiers));

            String name2 = field.getName();
            System.out.println("属性名：" + name2);

            Class<?> type = field.getType();
            System.out.println("属性的数据类型：" + type);
        }
        System.out.println("-------------------------");
        //（7）构造器们
        System.out.println("构造器列表：");
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (int i = 0; i < constructors.length; i++) {
            Constructor constructor = constructors[i];
            System.out.println("第" + (i + 1) + "个构造器：");
            //修饰符、构造器名称、构造器形参列表  、抛出异常列表
            int modifiers = constructor.getModifiers();
            System.out.println("构造器的修饰符：" + Modifier.toString(modifiers));

            String name2 = constructor.getName();
            System.out.println("构造器名：" + name2);

            //形参列表
            System.out.println("形参列表：");
            Class[] parameterTypes = constructor.getParameterTypes();
            for (Class parameterType : parameterTypes) {
                System.out.println(parameterType);
            }

            //异常列表
            System.out.println("异常列表：");
            Class<?>[] exceptionTypes = constructor.getExceptionTypes();
            for (Class<?> exceptionType : exceptionTypes) {
                System.out.println(exceptionType);
            }
            System.out.println();
        }
        System.out.println("---------------------------------");
        //(8)方法们
        System.out.println("方法列表：");
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (int i = 0; i < declaredMethods.length; i++) {
            Method method = declaredMethods[i];
            System.out.println("第" + (i + 1) + "个方法：");
            //修饰符、返回值类型、方法名、形参列表 、异常列表
            int modifiers = method.getModifiers();
            System.out.println("方法的修饰符：" + Modifier.toString(modifiers));

            Class<?> returnType = method.getReturnType();
            System.out.println("返回值类型:" + returnType);

            String name2 = method.getName();
            System.out.println("方法名：" + name2);

            //形参列表
            System.out.println("形参列表：");
            Class[] parameterTypes = method.getParameterTypes();
            for (Class parameterType : parameterTypes) {
                System.out.println(parameterType);
            }

            //异常列表
            System.out.println("异常列表：");
            Class<?>[] exceptionTypes = method.getExceptionTypes();
            for (Class<?> exceptionType : exceptionTypes) {
                System.out.println(exceptionType);
            }
            System.out.println();
        }
    }
}