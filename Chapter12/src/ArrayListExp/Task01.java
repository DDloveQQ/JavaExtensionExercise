package ArrayListExp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task01 {
    public static void main(String[] args) {
        // 1---3
        String[] num = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        String[] shape = {"黑桃","红桃","方片","梅花"};
        String[] joker = {"大王","小王"};
        // 4
        List<String> list = new ArrayList<>();
        for (String value : num) {
            for (String s : shape) {
                list.add(s + value);
            }
        }
        list.add(joker[0]);
        list.add(joker[1]);

        // 5
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+"  ");
            if((i+1)%10==0){
                System.out.println();
            }
        }
        System.out.println();
        // 6
        List<String> person1 = new ArrayList<>();
        List<String> person2 = new ArrayList<>();
        List<String> person3 = new ArrayList<>();
        List<String> person4 = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0 ; i < 11; i++) {
            person1.add(list.remove(rand.nextInt(list.size())));
            person2.add(list.remove(rand.nextInt(list.size())));
            person3.add(list.remove(rand.nextInt(list.size())));
            person4.add(list.remove(rand.nextInt(list.size())));
        }
        System.out.println("第一个人：" + person1);
        System.out.println("第二个人：" + person2);
        System.out.println("第三个人：" + person3);
        System.out.println("第四个人：" + person4);

        System.out.println("剩余：" + list);
    }
}
