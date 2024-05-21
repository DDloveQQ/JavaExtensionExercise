package PrintStream;

import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

public class Task01 {
    public static void main(String[] args) {
        test01();
        test02();
    }

    public static void test01() {
        Scanner input = null;
        PrintStream ps = null;

        try {
            input = new Scanner(System.in);
            ps = new PrintStream("word.txt");

            for (int i = 0; i < 3; i++) {
                System.out.println("请输入第" + (i + 1) + "句话");
                String content = input.nextLine();
                ps.println(content);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (input != null) input.close();
            if (ps != null) ps.close();
        }
    }

    public static void test02() {
        Scanner input = null;
        try {
            input = new Scanner(new File("word.txt"));
            while (input.hasNextLine()) {
                System.out.println(input.nextLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (input != null) input.close();
        }
    }
}
