package InnerClassExp;

public class CodeRead01 {
    public static void main(String[] args) {
        Out out = new Out();
        out.Print(3);
    }
}
class Out {
    private int age = 12;
    public void Print(final int x) {
        class In {
            public void inPrint() {
                System.out.println(x);//3
                System.out.println(age);//12
            }
        }
        new In().inPrint();
    }
}