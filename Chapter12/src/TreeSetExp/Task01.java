package TreeSetExp;

import java.util.Comparator;
import java.util.TreeSet;

public class Task01 {
    public static void main(String[] args) {
        System.out.println("按照成绩和年龄排序：");
        TreeSet<Student> set = new TreeSet<>(((o1, o2) -> {
            // 注意,这里的o1和o2不需要向下转型,因为前面的<>中已经定义了存储的数据类型
            if (o2.getScore() != o1.getScore()) {
                // 成绩不同则按照程序降序排列
                return (int) (o2.getScore() - o1.getScore());
            } else {
                // 成绩相同则按年龄降序排列
                return (o2.getAge() - o1.getAge());
            }
        }));
        set.add(new Student("liusan",20,90.0));
        set.add(new Student("lisi",22,90.0));
        set.add(new Student("wangwu",20,99.0));
        set.add(new Student("sunliu",22,100.0));
        for (Student stu : set) {
            System.out.println(stu);
        }

        System.out.println("按照姓名排序：");
        TreeSet<Student> set2 = new TreeSet<>(((o1, o2) -> {
            return o1.getName().compareTo(o2.getName());
        }));

        set2.addAll(set);
        for (Student stu : set2) {
            System.out.println(stu);
        }
    }
}

class Student {
    private String name;
    private int age;
    private double score;
    public Student(String name, int age, double score) {
        super();
        this.name = name;
        this.age = age;
        this.score = score;
    }
    public Student() {
        super();
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public double getScore() {
        return score;
    }
    public void setScore(double score) {
        this.score = score;
    }
    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + ", score=" + score + "]";
    }
}
