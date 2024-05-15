package StringExp.CodeWrite;

// 面试题：将字符串中指定部分进行反转。比如将“abcdefgho”实现部分反转，结果为”abfedcgho”

public class ReverseSubstring {
    public static void main(String[] args) {
        String s = "abcdefgho";
        System.out.println(reverseString(s, 2, 5));
    }

    public static String reverseString (String s, int begin, int end) {
        if (begin < 0 || end >= s.length() || begin > end) {
            System.out.println("输出参数有误");
            return null;
        }
        char[] c = s.toCharArray();
        char temp;
        while (begin <= end) {
            temp = c[begin];
            c[begin] = c[end];
            c[end] = temp;
            begin++;
            end--;
        }
        return String.valueOf(c);
    }
}
