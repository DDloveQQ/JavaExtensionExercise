package ComprehensiveExercises;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Task01 {
    public static void main(String[] args) {
        try {
            test04();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void test01() throws Exception {
        Class<?> clazz = Class.forName("ComprehensiveExercises.AtguiguDemo");
        System.out.println("类的加载器: " + clazz.getClassLoader());
        System.out.println("包名: " + clazz.getPackageName());
        System.out.println("类名: " + clazz.getName());
        System.out.println("父类: " + clazz.getSuperclass().getName());
        System.out.println("父接口: " + Arrays.toString(clazz.getInterfaces()));

        System.out.println("---------------  类属性  ---------------");
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            System.out.println("第" + (i+1) + "个字段");
            // 获得一个int,这个数值的大小包含了修饰符信息,可通过Modifier.toString翻译得到修饰符
            // 例如: private = 2, static = 8, final = 16, 所以fMod = 2+8+16=26
            // 所有修饰符都有唯一对应的数,且一定是2^n次方,多个数加起来获得的结果一定唯一
            int fMod = fields[i].getModifiers();
            System.out.println("修饰符: " + Modifier.toString(fMod));
            System.out.println("数据类型: " + fields[i].getType().getName());
            System.out.println("属性名: " + fields[i].getName());
        }

        System.out.println("---------------  构造器  ---------------");
        Constructor[] constructor = clazz.getDeclaredConstructors();
        for (int i = 0; i < constructor.length; i++) {
            System.out.println("第" + (i+1) + "个字段");
            int csMod = constructor[i].getModifiers();
            System.out.println("修饰符: " + Modifier.toString(csMod));
            System.out.println("构造器名: " + constructor[i].getName());
            System.out.println("形参列表: " + Arrays.toString(constructor[i].getParameterTypes()));
        }

        System.out.println("---------------  方法  ---------------");
        Method[] methods = clazz.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.println("第" + (i+1) + "个字段");
            int mMod = methods[i].getModifiers();
            System.out.println("修饰符: " + Modifier.toString(mMod));
            System.out.println("方法名: " + methods[i].getName());
            System.out.println("返回类型: " + methods[i].getReturnType());
            System.out.println("形参列表: " + Arrays.toString(methods[i].getParameterTypes()));
        }
    }

    // 用反射获取school的值，并修改school的值为“尚硅谷大学”，然后再获取school的值
    public static void test02() {
        try {
            Class<?> clazz = Class.forName("ComprehensiveExercises.AtguiguDemo");
            Field field = clazz.getDeclaredField("school");
            field.setAccessible(true);
            Object value = field.get(null);
            System.out.println("value = " + value);
            field.set(null, "尚硅谷大学");
            value = field.get(null);
            System.out.println("value = " + value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 用反射创建AtguiguDemo类的对象，并设置班级名称className属性的值，并获取它的值
    public static void test03() {
        try {
            Class<?> clazz = Class.forName("ComprehensiveExercises.AtguiguDemo");
            // 注意,className不是静态遍历,因此必须依托于对象实例,所以先获取构造器,再基于构造器创建新的对象实例
            Constructor<?>[] constructor = clazz.getDeclaredConstructors();
            Object obj = constructor[0].newInstance("高一三班");

            Field field = clazz.getDeclaredField("className");
            field.setAccessible(true);
            Object value = field.get(obj);
            System.out.println("className = " + value);
            field.set(obj, "高三八班");
            value = field.get(obj);
            System.out.println("className = " + value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // 用反射获取有参构造创建2个AtguiguDemo类的对象，并获取compareTo方法，调用compareTo方法，比较大小。
    public static void test04() throws Exception {
        Class<?> clazz = Class.forName("ComprehensiveExercises.AtguiguDemo");
        Constructor<?>[] constructor = clazz.getDeclaredConstructors();
        Object obj1 = constructor[0].newInstance("4班");
        Object obj2 = constructor[0].newInstance("8班");

        Method method = clazz.getDeclaredMethod("compareTo", AtguiguDemo.class);
        System.out.println("比较结果: " + method.invoke(obj1, obj2));  // 参数1: 类对象, 参数2: 待比较的对象
    }
}
