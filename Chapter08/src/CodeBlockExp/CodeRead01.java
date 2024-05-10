package CodeBlockExp;

// 注意，i、k、n是类变量，在程序一开始就已经有定义，只不过都是默认值0
public class CodeRead01 {
    ////////////////////////////// 静态区 //////////////////////////////////
    public static int k = 0;  //1
    public static CodeRead01 t1 = new CodeRead01("t1");  //2
    public static CodeRead01 t2 = new CodeRead01("t2");  //6
    public static int i = print("i");  //10
    public static int n = 99;  //11
    static{
        print("静态块");  //12
    }

    public static int print(String str){
        System.out.println((++k) + ":" + str + "  i=" + i + "  n=" + n);
        ++n;
        return ++i;
    }
    /////////////////////////////////////////////////////////////////////////
    public int j = print("j");  //3  //7
    {
        print("构造块");  //4  //8
    }

    public CodeRead01(String str){  //5  //9
        System.out.println((++k) + ":" + str + "  i=" + i + "  n=" + n);
        ++n;
        ++i;
    }

    public static void main(String[] args) {

    }
}
