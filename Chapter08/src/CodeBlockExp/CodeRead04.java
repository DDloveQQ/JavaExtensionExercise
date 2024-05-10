package CodeBlockExp;

public class CodeRead04 {
    public static void main(String[] args) {
        new HelloB_2();
    }
}
class HelloA_2{
    public HelloA_2(){
        System.out.println("HelloA_2");
    }
    {
        System.out.println("I'm A_2 Class");
    }
}

class HelloB_2 extends HelloA_2{
    public HelloB_2(){
        System.out.println("HelloB_2");
    }
    {
        System.out.println("I'm B_2 Class");
    }
}