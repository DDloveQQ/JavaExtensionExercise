package InnerClassExp;

public class CodeRead03 {
    public CodeRead03(){
        Inner s1 = new Inner();
        s1.a = 10;
        Inner s2 = new Inner();
        s2.a = 20;
        CodeRead03.Inner s3 = new CodeRead03.Inner();
        System.out.println(s3.a);  // 5
    }
    class Inner{
        public int a = 5;
    }
    public static void main(String[] args) {
        CodeRead03 t = new CodeRead03();
        Inner r = t.new Inner();
        System.out.println(r.a);  // 5
    }
}
