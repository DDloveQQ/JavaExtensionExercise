package GenericsInCollections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class Task01 {
    public static void main(String[] args) {
        HashSet<Integer> set = new LinkedHashSet<>();
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            set.add(rand.nextInt(50) * 2);
        }
        System.out.println("元素个数： " + set.size());
        for (Integer o : set) {
            System.out.println(o);
        }
    }
}
