package Comparator;

import com.sun.source.tree.Tree;

import java.util.Collections;
import java.util.TreeSet;

public class Task01 {
    public static void main(String[] args) {
        System.out.println("按照成绩和年龄排序：");
        TreeSet<Student> set = new TreeSet<>((o1, o2) -> {
            if (o1.getScore() != o2.getScore()) {
                return (int) (o1.getScore() - o2.getScore());
            } else {
                return o1.getAge() - o2.getAge();
            }
        });
        set.add(new Student("liusan",20,90.0));
        set.add(new Student("lisi",22,90.0));
        set.add(new Student("wangwu",20,99.0));
        set.add(new Student("sunliu",22,100.0));
        for (Student student : set) {
            System.out.println(student);
        }

        System.out.println("按照姓名排序：");
        // 一旦创建了一个TreeSet并提供了一个比较器，就无法更改该比较器,因此这里需要新建立一个TreeSet
        TreeSet<Student> set2 = new TreeSet<>((o1, o2) -> o1.getName().compareTo(o2.getName()));

        set2.add(new Student("liusan",20,90.0));
        set2.add(new Student("lisi",22,90.0));
        set2.add(new Student("wangwu",20,99.0));
        set2.add(new Student("sunliu",22,100.0));

        for (Student student : set2) {
            System.out.println(student);
        }
    }
}
class Student {
    private String name;
    private int age;
    private double score;

    public Student(String name, int age, double score) {
        this.name = name;
        this.age = age;
        this.score = score;
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
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}