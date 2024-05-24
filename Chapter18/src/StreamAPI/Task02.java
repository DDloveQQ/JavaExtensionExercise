package StreamAPI;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task02 {
    public static void main(String[] args) {
        //第一支队伍
        ArrayList<String> one = new ArrayList<>();
        one.add("迪丽热巴");
        one.add("宋远桥");
        one.add("苏星河");
        one.add("石破天");
        one.add("石中玉");
        one.add("老子");
        one.add("庄子");
        one.add("洪七公");

        //第二支队伍
        ArrayList<String> two = new ArrayList<>();
        two.add("古力娜扎");
        two.add("张无忌");
        two.add("赵丽颖");
        two.add("张三丰");
        two.add("尼古拉斯赵四");
        two.add("张天爱");
        two.add("张二狗");

        // 第一个队伍只要名字小于等于3个字的成员姓名；
        // 第一个队伍筛选之后只要前3个人；
        System.out.println("队伍一处理结果: ");
        one.stream().filter((o) -> o.length() <= 3)// lambda表达式定义过滤标准
                .limit(3)  // 取前三个
                .collect(Collectors.toList())  // 转为list<string>
                .forEach(System.out::println);  // 输出结果

        // 第二个队伍只要姓张的成员姓名；
        // 第二个队伍筛选之后去掉前2个人；
        System.out.println("队伍二处理结果: ");
        two.stream().filter((o) -> o.charAt(0) == '张')
                .skip(2)  // 取后两个
                .toList()  // 转为list<string>
                .forEach(System.out::println);  // 输出结果

        // 将两个队伍合并为一个队伍；存储到一个新集合中，打印合并队伍后成员姓名。
        Stream.concat(one.stream(), two.stream())
                .toList()
                .forEach(System.out::println);

        // 将两个队伍合并为一个队伍；
        // 根据姓名创建Person对象；
        // 打印整个队伍的Person对象信息。
        Stream.concat(one.stream(), two.stream())
                .map(Person::new)
                .toList()
                .forEach(System.out::println);

    }

}
class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}