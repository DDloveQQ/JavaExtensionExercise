package GenericsInCollections;

import java.util.*;

public class Task03 {
    public static void main(String[] args) {
        HashMap<Integer, String> m = new LinkedHashMap<>();
        m.put(1930, "乌拉圭");
        m.put(1934, "意大利");
        m.put(1938, "意大利");
        m.put(1950, "乌拉圭");
        m.put(1954, "西德");
        m.put(1958, "巴西");
        m.put(1962, "巴西");
        m.put(1966, "英格兰");
        m.put(1970, "巴西");
        m.put(1974, "西德");
        m.put(1978, "阿根廷");
        m.put(1982, "意大利");
        m.put(1986, "阿根廷");
        m.put(1990, "西德");
        m.put(1994, "巴西");
        m.put(1998, "法国");
        m.put(2002, "巴西");
        m.put(2006, "意大利");
        m.put(2010, "西班牙");
        m.put(2014, "德国");
        m.put(2018, "法国");

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入年份");
        int year = scanner.nextInt();
        if (m.containsKey(year)) {
            System.out.println(year + "年，获得世界杯冠军的是：" + m.get(year));
        } else {
            System.out.println("没有举办世界杯");
        }
        System.out.println("请输入队名");
        String team = scanner.next();
        scanner.close();
        Set<Map.Entry<Integer, String>> set = m.entrySet();
        if (m.containsValue(team)) {
            System.out.println("该球队在以下年份获得过冠军: ");
            for (Map.Entry<Integer, String> o : set) {
                if (o.getValue().equals(team)) System.out.println(o.getKey());
            }
        } else {
            System.out.println("该球队从未获得过冠军");
        }
    }
}
