package StaticExp;

public class ReadCode2 {
    public static void main(String[] args) {
        int i = 0;
        System.out.println(new SDText().x + "," + new SDText().y + "," + new SDText().x);
    }
}

class SDText {
    // 以下三条只会在第一次new SDText时执行，而后续再次new SDText时只会执行构造函数
    static SDText sd = new SDText();  // x=4,y=1且都为类变量，全局共享
    static int x = 3;  // x=3 类变量重置为3
    static int y;  // y=1 类变量维持原状（1）

    public SDText() {
        x++;
        y++;
    }
}
