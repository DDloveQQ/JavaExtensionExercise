package TimeAPI;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Scanner;

public class Task02 {
    @Test
    public void getLocalTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        DateTimeFormatter df = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        System.out.println(df.format(localDateTime));

        df = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH时mm分ss秒 SSS毫秒 E 是这一年的D天");
        String str = df.format(localDateTime);
        System.out.println(str);
    }

    @Test
    public void timeInterval() {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime chicagoDateTime = LocalDateTime.now(ZoneId.of("America/Chicago"));
        Duration duration = Duration.between(localDateTime, chicagoDateTime);
        System.out.println(duration);
    }

    @Test
    public void timeInterval2() {
        LocalDate localDate = LocalDate.now();
        Scanner input = new Scanner(System.in);
        System.out.println("请输入生日（格式为1995-05-01）：");
        String birthdayStr = input.next();
        input.close();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate birthday = LocalDate.from(df.parse(birthdayStr));
        Period p = Period.between(localDate, birthday);
        System.out.println(p);
    }

    @Test
    public void timeInterval3() throws ParseException {
        Date today = new Date();
        Scanner input = new Scanner(System.in);
        System.out.println("请输入生日（格式为1995-05-01 08:08）：");
        String birthdayStr = input.next();
        input.close();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date birthday = sf.parse(birthdayStr);

        long time = today.getTime() - birthday.getTime();
        System.out.println(time);

        Date date = new Date(time);
        System.out.println(date);
    }
}
