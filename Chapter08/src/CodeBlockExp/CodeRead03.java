package CodeBlockExp;

// static代码块 > 一般代码块 > 构造函数
// 父类 > 子类

public class CodeRead03 extends HelloA{
    public CodeRead03(){  // 6
        System.out.println("HelloB");
    }
    {  // 5
        System.out.println("I'm B Class");
    }
    static{  // 2
        System.out.println("static B");
    }

    public static void main(String[] args) {
        new CodeRead03();
    }
}

class HelloA{
    public HelloA(){  // 4
        System.out.println("HelloA");
    }
    {  // 3
        System.out.println("I'm A Class");
    }
    static{  // 1
        System.out.println("static A");
    }
}
