package StringExp.CodeRead;

public class CodeRead04 {
    int a;
    int b;
    String str;
    public void f(){
        a = 0;
        b = 0;
        str = "hello";
        int[] c = {0};
        g(b, c, str);
        System.out.println(a + " " + b + " " + c[0] + "," + str);
    }
    public void g(int b, int[] c, String s){
        a = 1;  // 函数参数列表没声明,说明是类中的变量,因此受影响
        b = 1;
        c[0] = 1;
        s = "world";
    }
    public static void main(String[] args) {
        CodeRead04 t = new CodeRead04();
        t.f();
    }
}
