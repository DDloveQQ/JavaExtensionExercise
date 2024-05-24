package Lambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class Task05 {
    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<String, Integer>();
        map.put("岑小村", 59);
        map.put("谷天洛", 82);
        map.put("渣渣辉", 98);
        map.put("蓝小月", 65);
        map.put("皮几万", 70);

        Function<Map<String, Integer>, ArrayList<Integer>> f1 = (m) -> {
            ArrayList<Integer> list = new ArrayList<>();
            list.addAll(m.values());
            return list;
        };

        Function<ArrayList<Integer>, Double> f2 = (m) -> {
            double sum = 0;
            for (Integer i : m) {
                sum += i;
            }
            return sum / m.size();
        };

        Double avg = f1.andThen(f2).apply(map);
        System.out.println("学生平均成绩为: " + avg);
    }
}

