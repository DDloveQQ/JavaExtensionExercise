package Comparator;

import java.util.Comparator;

public class ArrayTools {
    public static void sort(Object[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                //将arr[j]强制为Comparable接口类型，目的是调用compareTo方法(此时的arr[j]还是Object数据类型，无法使用Employee下重写的方法)
                Comparable c = (Comparable) arr[j];
                if (c.compareTo(arr[j + 1]) > 0) {
                    Object temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void sort(Object[] arr, Comparator c) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                //这里不需要强制类型转换, 因为形参列表已经给出了Comparator
                if (c.compare(arr[j], arr[j + 1]) > 0) {
                    Object temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void print(Object[] arr) {
        for (Object obj : arr) {
            System.out.println(obj);
        }
    }
}
