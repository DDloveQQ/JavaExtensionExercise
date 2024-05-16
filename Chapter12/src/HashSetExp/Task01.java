package HashSetExp;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Task01 {
    public static void main(String[] args) {
        HashSet<Character> set = new LinkedHashSet<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入一串字母");
        String str = scanner.next();
        char[] c = str.toCharArray();
        for (char o : c) {
            set.add(o);
        }
        for (char o : set) {
            System.out.print(o);
        }
    }
}
