package InnerClassExp;

public class CodeRead02 {
    public static void main(String[] args) {
        Out_2.In in = new Out_2().new In();
        in.print();
    }
}
class Out_2 {
    private int age = 12;
    class In {
        private int age = 13;
        public void print() {
            int age = 14;
            System.out.println("局部变量：" + age);//14
            System.out.println("内部类变量：" + this.age);//13
            System.out.println("外部类变量：" + Out_2.this.age);//12
        }
    }
}