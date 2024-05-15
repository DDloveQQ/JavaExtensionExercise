package StringExp.CodeWrite;

public class StringReplace {
    public static String replace(String text, String subtext, String replace) {
       while (true) { // 无限循环，直到指定字符串不再出现为止
           // 返回指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1
           int index = text.indexOf(subtext);
           if (index != -1) {
               text = text.substring(0, index) + replace + text.substring(index + replace.length());
           } else {
               break;
           }
       }
       return text;
    }

    public static void main(String[] args) {
        System.out.println(replace("aabbbbcbbcbb", "aa", "bb"));
    }
}
