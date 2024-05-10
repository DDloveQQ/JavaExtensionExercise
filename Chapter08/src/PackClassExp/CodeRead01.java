package PackClassExp;

public class CodeRead01 {
    public static void main(String[] args) {
        Integer i1 = 128;
        Integer i2 = 128;
        int i3 = 128;
        int i4 = 128;
        System.out.println(i1 == i2);  //false -> 地址不同
        System.out.println(i3 == i4);  //true -> 数值相同
        System.out.println(i1 == i3);  //true -> 自动拆箱 + 数值相同
    }
}
