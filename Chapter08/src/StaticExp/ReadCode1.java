package StaticExp;

public class ReadCode1 {
    static int x, y, z;  // 三个变量为类变量,初始值为0

    static {
        int x = 5;  // 注意，此处虽然为静态代码块，但建立的变量x为局部变量，和类变量不是同一个东西！！！
        // x = 5; 如果这里不加int，则表示对类变量进行赋值，于是类变量x变为5
        x--;
    }

    static {
        x--;  // 没加int，说明操作的是类变量
    }

    public static void main(String[] args) {
        System.out.println("x=" + x);
        z--;  //-1
        method();
        System.out.println("result:" + (z + y + ++z));  //3
    }

    public static void method() {
        y = z++ + ++z;  // z++在参与运算时为-1，但实际已经变成了0，因此++z在参与运算时的值为1（z++并不是在;后生效，而是在+后生效）
    }
}
