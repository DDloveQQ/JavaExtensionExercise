package HashMapExp;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Task01 {
    public static void main(String[] args) {
        HashMap<Character, Integer> map = new HashMap<>();
        String str = "Your future depends on your dreams, so go to sleep.";
        str = str.replaceAll("[^a-zA-Z]", "");
        char[] c = str.toCharArray();
        for (char o : c) {
            if (map.containsKey(o)) {
                map.put(o, map.get(o) + 1);
            } else {
                map.put(o, 1);
            }
        }
        Set<Map.Entry<Character, Integer>> set = map.entrySet();
        for (Object o : set) {
            System.out.println(o);
        }
    }
}
