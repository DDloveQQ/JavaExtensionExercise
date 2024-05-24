package Lambda;

import java.util.*;
import java.util.function.Supplier;

public class Task01 {
    public static <T> T getObj(Supplier<T> supplier) {
        return supplier.get();
    }

    public static void main(String[] args) {
        // lambda表达式获得长度为5的String数组
        String[] arr = getObj(() -> new String[5]);
        System.out.println(Arrays.toString(arr));

        // lambda表达式获得包含5个1-20(含1和20)之间随机数的HashSet<Integer>集合
        Random rand = new Random();
        HashSet<Integer> nums = getObj(() -> {
            HashSet<Integer> set = new LinkedHashSet<>();
            while (set.size() < 5){
                set.add(rand.nextInt(20) + 1);
            }
            return set;
        });
        System.out.println(nums.toString());

        // lambda表达式获得一个代表2018年4月1日的Calendar对象
        GregorianCalendar gc = getObj(() -> {
            return new GregorianCalendar(2018, Calendar.MAY, 1);
        });
        System.out.println(gc);
    }
}