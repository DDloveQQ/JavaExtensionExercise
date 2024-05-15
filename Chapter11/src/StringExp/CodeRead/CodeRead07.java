package StringExp.CodeRead;

public class CodeRead07 {
    public static void main(String[] args) {
        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");
        operate(a, b);
        System.out.println(a + "," + b);// ABx , B
    }

    public static void operate(StringBuffer x, StringBuffer y) {
        x.append(y);
        y = x;  // 把x的地址赋给y,原先y的地址(@b)被顶掉,因此后续的改变将不再影响b
        y.append('x');
    }
}
