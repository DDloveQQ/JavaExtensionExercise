package Lambda;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Task04 {
    public static void main(String[] args) {
        EmployeeService es = new EmployeeService();

        es.add(new Employee(1, "张三", 33, 8000));
        es.add(new Employee(2, "翠花", 23, 18000));
        es.add(new Employee(3, "无能", 46, 8000));
        es.add(new Employee(4, "李四", 23, 9000));
        es.add(new Employee(5, "老王", 23, 15000));
        es.add(new Employee(6, "大嘴", 23, 11000));

        System.out.println("所有员工对象:");
        es.get((o) -> true).forEach((o) -> System.out.println(o));

        System.out.println("所有年龄超过35的员工:");
        es.get((o) -> o.getAge() > 35).forEach(System.out::println);

        System.out.println("所有编号是偶数的员工:");
        es.get((o) -> o.getId() % 2 == 0).forEach(System.out::println);

        System.out.println("名字是张三的员工");
        es.get((o) -> o.getName().equals("张三")).forEach(System.out::println);

        System.out.println("年龄超过25,且薪资低于10000的员工");
        es.get((o) -> (o.getAge() > 25 && o.getSalary() < 10000)).forEach(System.out::println);

    }
}

class EmployeeService {
    private ArrayList<Employee> all = new ArrayList<>();

    public void add(Employee emp) {
        all.add(emp);
    }

    public ArrayList<Employee> get(Predicate<Employee> p) {
        ArrayList<Employee> out = new ArrayList<>();
        for (Employee emp : all) {
            if (p.test(emp)) {
                out.add(emp);
            }
        }
        return out;
    }
}
