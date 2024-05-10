package EnumExp;

import java.util.Scanner;

public class Task01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入年份值：");
        int year = input.nextInt();

        System.out.print("请输入月份值：");
        int monthValue = input.nextInt();
        Month month = Month.getByValue(monthValue);
        System.out.println(month);

        System.out.println("月份总天数：" + month.length(year%4==0 && year%100!=0 || year%400==0));

        input.close();
    }
}

enum Month {
    JANUARY("一月"),
    FEBRUARY("二月"),
    MARCH("三月"),
    APRIL("四月"),
    MAY("五月"),
    JUNE("六月"),
    JULY("七月"),
    AUGUST("八月"),
    SEPTEMBER("九月"),
    OCTOBER("十月"),
    NOVEMBER("十一月"),
    DECEMBER("十二月");

    private final String description;

    Month(String description) {
        this.description = description;
    }

    public static Month getByValue(int value){
        if(value>=1 && value<=12){
            return Month.values()[value-1];
        }
        return null;
    }

    public int length(boolean leapYear){
        switch(this){
            case FEBRUARY:
                return leapYear ? 29 : 28;
            case APRIL:
            case JUNE:
            case SEPTEMBER:
            case NOVEMBER:
                return 30;
            default:
                return 31;
        }
    }

    @Override
    public String toString() {
        return (ordinal()+1) +"->" + name() +"->" + description;
    }
}