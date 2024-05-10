package CodeBlockExp;

public class CodeRead07 {
    public static void main(String[] args){
        Son s1 = new Son();//找到就是Son类的<init>()
    }
}
class Father{
    private int a = getNumber();
    //因为我们现在在newSon类的对象，所以对象的运行时是Son类，
    //而getNumber是虚方法，所以要看子类重写后的getNumber
    //因此运行的是重写后的getNumber()
    {
        System.out.println("Father非静态代码块 a = " + a);
    }
    Father(){
        System.out.println("Father()无参构造");
    }
    public int getNumber(){
        System.out.println("Father:getNumber()");
        return 1;
    }
}
class Son extends Father{
    {
        System.out.println("Son非静态代码");
    }
    public Son(){
        System.out.println("Son()：无参构造");
    }
    public int getNumber(){
        System.out.println("Son:getNumber()");
        return 2;
    }
}