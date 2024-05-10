package PackClassExp;

public class CodeRead02 {
    public static void main(String[] args) {
        double a = 2.0;
        double b = 2.0;
        Double c = 2.0;
        Double d = 2.0;
        System.out.println(a == b);  //true -> 数值相同
        System.out.println(c == d);  //false -> 地址不同
        System.out.println(a == d);  //true -> 自动拆箱 + 数值相同
    }
}
