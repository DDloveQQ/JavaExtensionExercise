package Comparator;
import java.util.Comparator;

public class Task01 {
    public static void main(String[] args) {
        Employee[] arr = new Employee[5];
        arr[0] = new Employee(3,"张三",9000,22);
        arr[1] = new Employee(1,"熊大",10000,22);
        arr[2] = new Employee(5,"王五",7500,25);
        arr[3] = new Employee(4,"李四",8500,24);
        arr[4] = new Employee(2,"熊二",8500,18);

        System.out.println("所有员工：");
        ArrayTools.print(arr);

        System.out.println("按照员工编号从小到大排序：");
        ArrayTools.sort(arr);
        ArrayTools.print(arr);

        System.out.println("按照员工编号从大到小排序：");
        ArrayTools.sort(arr, (o1, o2) -> ((Employee)o2).getId() - ((Employee)o1).getId());
        ArrayTools.print(arr);

        System.out.println("按照员工薪资从低到高排序：");
        ArrayTools.sort(arr, ((o1, o2) -> (int) (((Employee)o1).getSalary() - ((Employee)o2).getSalary())));
        ArrayTools.print(arr);

        System.out.println("按照员工年龄从大到小排序：");
        ArrayTools.sort(arr, ((o1, o2) -> ((Employee) o2).getAge() - ((Employee) o1).getAge()));
        ArrayTools.print(arr);
    }
}
