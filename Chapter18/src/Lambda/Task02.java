package Lambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class Task02 {
    public static void main(String[] args) {
        test02();
    }

    public static void test01() {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            list.add((char) ('a' + i));
        }
        list.forEach((o) -> System.out.print(o + " "));
    }

    public static void test02() {
        HashMap<Integer, String> map = new LinkedHashMap<>();
        map.put(1,"Java");
        map.put(2,"C");
        map.put(3,"Python");
        map.put(4,"C++");
        map.put(5,"C#");
        map.forEach((o1, o2) -> System.out.println(o1 + ": " + o2));
    }
}
