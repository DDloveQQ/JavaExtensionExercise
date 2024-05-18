package CustomizeGenerics;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;
import java.util.Objects;

public class Task03 {
    public static void main(String[] args) {
        Employee[] arr = new Employee[4];
        arr[0] = new Employee("张三", 18000, 18);
        arr[1] = new Employee("李四", 14000, 28);
        arr[2] = new Employee("王五", 14000, 24);
        arr[3] = new Employee("赵六", 15000, 18);

        int index = MyArrays.find(arr, new Employee("张三", 18000, 18));
        System.out.println(index);

        Employee maxSalary = MyArrays.max(arr);
        System.out.println("max = " + maxSalary);

        Employee maxAge = MyArrays.max(arr, new EmployeeAgeComparator());
        System.out.println("maxAge = " + maxAge);
    }
}
class MyArrays {
    //可以在任意类型的对象数组中，查找某个元素的下标，按照顺序查找，如果有重复的，就返回第一个找到的，如果没有返回-1
    public static <T> int find(T[] arr, T value) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].equals(value)) {//使用==比较太严格，使用equals方法，因为任意对象都有equals方法
                return i;
            }
        }
        return -1;
    }
    //可以在任意类型的对象数组中，查找最大值，要求元素必须实现Comparable接口
    public static <T extends Comparable<? super T>> T max(T[] arr) {
        T max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max.compareTo(arr[i]) < 0) max = arr[i];
        }
        return max;
    }

    // 可以在任意类型的对象数组中，查找最大值，按照指定定制比较器来比较元素大小
    public static <T> T max(T[] arr, Comparator<? super T> c) {
        T max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (c.compare(max, arr[i]) < 0) max = arr[i];
        }
        return max;
    }
}

class Employee implements Comparable<Employee> {
    private String name;
    private double salary;
    private int age;

    public Employee(String name, double salary, int age) {
        super();
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public Employee() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.salary, salary) == 0 && age == employee.age && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary, age);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
        if (this.getSalary() - o.getSalary() != 0) {
            return Double.compare(this.getSalary(), o.getSalary());
        } else {
            return (this.getName().compareTo(o.getName()));
        }
    }
}
class EmployeeAgeComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        if (o1.getAge() != o2.getAge()) {
            return o1.getAge() - o2.getAge();
        } else {
            return Collator.getInstance(Locale.CHINA).compare(o1.getName(), o2.getName());
        }
    }
}