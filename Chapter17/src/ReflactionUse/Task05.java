package ReflactionUse;

import java.lang.reflect.ParameterizedType;

public class Task05 {
    public static void main(String[] args) {
        SubA a = new SubA();
        System.out.println(a.getType());

        SubB b = new SubB();
        System.out.println(b.getType());
    }
}
abstract class Base<T>{
    private Class type;

    public Base() {
        //为type属性赋值为T的实际类型
        Class<? extends Base> clazz = this.getClass();
        try {
            ParameterizedType pt = (ParameterizedType) clazz.getGenericSuperclass();
            type = (Class) pt.getActualTypeArguments()[0];
        } catch (Exception e) {
            type = Object.class;
        }
    }

    public Class getType() {
        return type;
    }
}
class SubA extends Base<String>{

}
class SubB extends Base<Object>{

}

