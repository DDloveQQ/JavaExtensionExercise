package TimeAPI;

// 使用Calendar获取当前时间, 把这个时间设置为你的生日, 再获取你的百天(出生后100天)日期。

// 使用LocalDateTime获取当前时间, 把这个时间设置为你的生日, 再获取你的百天(出生后100天)日期。

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class Task01 {
    @Test
    public void exercise01() {
        Calendar calendar = Calendar.getInstance();
        System.out.println("今天是你的生日");
        Date birthday = calendar.getTime();
        System.out.println(birthday);

        System.out.println("百天以后是：");
        calendar.add(Calendar.DAY_OF_YEAR, 100);
        birthday = calendar.getTime();
        System.out.println(birthday);
    }

    @Test
    public void exercise02() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("今天是你的生日");
        System.out.println(localDateTime);

        System.out.println("百天以后是：");
        System.out.println(localDateTime.plusDays(100));
    }
}
