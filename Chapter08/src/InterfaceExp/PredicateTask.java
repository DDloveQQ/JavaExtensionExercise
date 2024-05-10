package InterfaceExp;

import java.util.function.Predicate;

public class PredicateTask {
    public static void main(String[] args) {
        EmployeeService es = new EmployeeService();
        es.add(new Employee(4, "李四", 24, 24000));
        es.add(new Employee(3, "张三", 23, 13000));
        es.add(new Employee(5, "王五", 25, 15000));
        es.add(new Employee(1, "赵六", 27, 17000));
        es.add(new Employee(2, "钱七", 16, 6000));

        System.out.println("所有员工：");
//        Employee[] all = es.get(new Predicate() {
//            @Override
//            public boolean test(Object o) {
//                return true;
//            }
//        });
        Employee[] all = es.get(o -> true);  // 使用Lambda表达式
        ArrayTools.print(all);
        System.out.println("--------------------------------");

        System.out.println("所有年龄超过25的员工：");
        all = es.get(o -> ((Employee) o).getAge() > 25);
        ArrayTools.print(all);
        System.out.println("--------------------------------");

        System.out.println("所有薪资高于15000的员工：");
        all = es.get(o -> ((Employee) o).getSalary() > 15000);
        ArrayTools.print(all);
        System.out.println("--------------------------------");

        System.out.println("所有年龄超过25且薪资高于15000的员工：");
        all = es.get(o -> ((Employee) o).getSalary() > 15000 && ((Employee) o).getAge() > 25);
        ArrayTools.print(all);
        System.out.println("--------------------------------");
    }

}

class ArrayTools {
    public static void print(Object[] arr) {
        for (Object os : arr) {
            System.out.println(os);
        }
    }
}

class Employee {
    private int ID;
    private String name;
    private int age;
    private double salary;

    public Employee(){}

    public Employee(int ID, String name, int age, double salary) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}

class EmployeeService {
    private Employee[] arr = new Employee[5];
    private int total = 0;

    public void add(Employee emp) {
        if (total < 5) {
            arr[total++] = emp;
        }
    }

    public Employee[] get(Predicate p) {
        int count = 0;
        for (Employee e : arr) {
            if (p.test(e)) {
                count++;
            }
        }
        Employee[] out = new Employee[count];
        count = 0;

        for (Employee e : arr) {
            if (p.test(e)) {
                out[count++] = e;
            }
        }
        return out;
    }
}