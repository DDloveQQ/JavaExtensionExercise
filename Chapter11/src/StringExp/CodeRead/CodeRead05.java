package StringExp.CodeRead;

public class CodeRead05 {
    private static void change(String s, StringBuffer sb) {
        s = "aaaa";  //字符串对象是不可变，一旦修改，就是新对象
        sb.setLength(0);//先把sb里面的内容给清空了
        sb.append("aaaa");//再拼接aaaa
    }


    public static void main(String[] args) {
        String s = "bbbb";
        StringBuffer sb = new StringBuffer("bbbb");
        change(s, sb);
        System.out.println(s + sb);//bbbbaaaa
    }
}
