package PackClassExp;

import PackClassExp.Data;

import static PackClassExp.Data.EMPLOYEE;
import static PackClassExp.Data.EMPLOYEES;

public class Task01 {
    public static void main(String[] args) {
        Employee[] arr = new Employee[EMPLOYEES.length];
        for (int i = 0; i < EMPLOYEES.length; i++) {
            int ID = Integer.parseInt(EMPLOYEES[i][1]);
            String name = EMPLOYEES[i][2];
            int age = Integer.parseInt(EMPLOYEES[i][3]);
            double salary = Double.parseDouble(EMPLOYEES[i][4]);

            switch (EMPLOYEES[i][0]) {
                case "10" -> arr[i] = new Employee(ID, name, age, salary);
                case "11" -> arr[i] = new Programmer(ID, name, age, salary);
                case "12" -> arr[i] = new Designer(ID, name, age, salary,
                        Double.parseDouble(EMPLOYEES[i][5]));
                case "13" -> arr[i] = new Architect(ID, name, age, salary,
                        Double.parseDouble(EMPLOYEES[i][5]),
                        Double.parseDouble(EMPLOYEES[i][6]));
            }
        }
        for (Employee e : arr) {
            System.out.println(e);
        }
    }
}
class Data{
    public static final int EMPLOYEE = 10;//表示普通员工
    public static final int PROGRAMMER = 11;//表示程序员
    public static final int DESIGNER = 12;//表示设计师
    public static final int ARCHITECT = 13;//表示架构师

    public static final String[][] EMPLOYEES = {
            {"10", "1", "段誉", "22", "3000"},
            {"13", "2", "令狐冲", "32", "18000", "15000", "2000"},
            {"11", "3", "任我行", "23", "7000"},
            {"11", "4", "张三丰", "24", "7300"},
            {"12", "5", "周芷若", "28", "10000", "5000"},
            {"11", "6", "赵敏", "22", "6800"},
            {"12", "7", "张无忌", "29", "10800","5200"},
            {"13", "8", "韦小宝", "30", "19800", "15000", "2500"},
            {"12", "9", "杨过", "26", "9800", "5500"},
            {"11", "10", "小龙女", "21", "6600"},
            {"11", "11", "郭靖", "25", "7100"},
            {"12", "12", "黄蓉", "27", "9600", "4800"}
    };
}

class Employee {
    private int ID;
    private String name;
    private int age;
    private double salary;

    public Employee() {}

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

    public String getBasicInfo() {
        return ID + "\t\t" + name + "\t" + age + "\t\t" + salary;
    }

    @Override
    public String toString() {
        return getBasicInfo();
    }
}

class Programmer extends Employee{
    public Programmer() {}

    public Programmer(int ID, String name, int age, double salary) {
        super(ID, name, age, salary);
    }

    @Override
    public String toString() {
        return getBasicInfo() + "\t\t" + "程序员";
    }
}

class Designer extends Programmer {
    public double bonus;
    public Designer() {}

    public Designer(int ID, String name, int age, double salary, double bonus) {
        super(ID, name, age, salary);
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return getBasicInfo() + "\t\t" + "设计师" + "\t\t" + bonus;
    }
}

class Architect extends Designer {
    public double stock;
    public Architect() {}

    public Architect(int ID, String name, int age, double salary, double bonus, double stock) {
        super(ID, name, age, salary, bonus);
        this.stock = stock;
    }

    @Override
    public String toString() {
        return getBasicInfo() + "\t\t" + "架构师" + "\t\t" + bonus + "\t\t" + stock;
    }
}
