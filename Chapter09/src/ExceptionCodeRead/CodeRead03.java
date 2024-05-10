package ExceptionCodeRead;

public class CodeRead03 {
    // 非静态代码块，只有在new一个对象的时候才会调用
    {
        System.out.println("a");
    }
    // 静态代码块，程序开始便会调用
    static{
        System.out.println("b");
    }
    {
        System.out.println("c");
    }
    // 静态函数,无需new一个对象便可以执行
    public static String getOut(){
        try{
            return "1";
        }catch(Exception e){
            return "2";
        }finally{ // 一定执行
            return "3";
        }
    }
    public static void main(String[] args) {
        System.out.println(getOut());  // b \n 3
    }
}
