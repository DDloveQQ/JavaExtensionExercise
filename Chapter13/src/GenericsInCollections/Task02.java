package GenericsInCollections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;

public class Task02 {
    public static void main(String[] args) {
        HashSet<Integer> set = new LinkedHashSet<>();
        Random rand = new Random();
        while (set.size() < 10) {
            set.add(rand.nextInt(50) * 2);
        }
        for (Integer integer : set) {
            System.out.println(integer);
        }
    }
}
