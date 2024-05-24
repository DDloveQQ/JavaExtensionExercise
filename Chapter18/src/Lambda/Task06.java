package Lambda;

public class Task06 {
    public static void main(String[] args) {
        String str1 = strHandler(" 1234 ", (o) -> o.trim());
        System.out.println(str1);

        String str2 = strHandler("abcd", (o) -> o.toUpperCase());
        System.out.println(str2);

        String str3 = strHandler("abcdef", (o) -> o.substring(2, 5));
        System.out.println(str3);
    }

    public static String strHandler(String str, StringHandler sh) {
        return sh.getValue(str);  // 调用抽象的方法
    }
}

@FunctionalInterface
interface StringHandler {
    public String getValue(String str);  // 抽象的方法
}