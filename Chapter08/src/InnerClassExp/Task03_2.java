package InnerClassExp;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Task03_2 {
    private static MyArrayList list;

    @BeforeClass
    public static void init() {
        list = new MyArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Before
    public void before() {
        System.out.println("该测试方法开始前list中的数据如下：");
        Selector select = list.select();
        while (select.hasNext()) {
            System.out.print(select.next() + " ");
        }
        System.out.println();
    }

    @After
    public void after() {
        System.out.println("该测试方法结束后list中的数据如下：");
        Selector select = list.select();
        while (select.hasNext()) {
            System.out.print(select.next() + " ");
        }
        System.out.println();
    }

    @Test
    public void testAdd() {
        System.out.println("现在测试的是testAdd()方法");
        list.add(4);
    }

    @Test
    public void testRemove() {
        System.out.println("现在测试的是testRemove()方法");
        list.remove(1);
    }

    @Test
    public void testSet() {
        System.out.println("现在测试的是testSet()方法");
        list.set(1, 5);
    }

    @Test
    public void testGet() {
        System.out.println("现在测试的是testGet()方法");
        System.out.println(list.get(1));
    }
}
