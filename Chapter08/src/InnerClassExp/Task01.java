package InnerClassExp;

// 编写一个匿名内部类，它继承Object，并在匿名内部类中，声明一个方法public void print()，输出尚硅谷。
public class Task01 {
    public static void main(String[] args) {
        new Object() {
            public void print() {
                System.out.println("尚硅谷");
            }
        }.print();
    }
}
