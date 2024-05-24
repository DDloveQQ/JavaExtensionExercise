package StreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Task03 {
    static List<Transaction> transactions = null;

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        System.out.println("2011年发生的所有交易， 并按交易额排序（从低到高）");
        transactions.stream()
                .filter((o) -> o.getYear() == 2011)
                .sorted((o1, o2) -> Integer.compare(o1.getValue(), o2.getValue()))
                .forEach(System.out::println);

        System.out.println("交易员都在哪些不同的城市工作过？");
        transactions.stream()
                .map((o) -> o.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);

        System.out.println("查找所有来自剑桥的交易员，并按姓名排序");
        transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .sorted(((o1, o2) -> o1.getName().compareTo(o2.getName())))
                .distinct()
                .forEach(System.out::println);

        System.out.println("返回所有交易员的姓名字符串，按字母顺序排序");
        transactions.stream()
                .map((t) -> t.getTrader().getName())
                .distinct()
                .sorted()
                .forEach(System.out::println);

        System.out.println("有没有交易员是在米兰工作的？");
        boolean bl = transactions.stream()
                .anyMatch((t) -> t.getTrader().getCity().equals("Milan"));
        System.out.println(bl);

        System.out.println("打印生活在剑桥的交易员的所有交易额");
        Optional<Integer> sum = transactions.stream()
                .filter(e -> e.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .reduce(Integer::sum);
        System.out.println(sum.get());

        System.out.println("所有交易中，最高的交易额是多少");
        Optional<Integer> max = transactions.stream()
                .map(Transaction::getValue)
                .max(Integer::compare);
        System.out.println(max.get());

        System.out.println("找到交易额最小的交易");
        Optional<Transaction> op = transactions.stream()
                .min((o1, o2) -> Integer.compare(o1.getValue(), o2.getValue()));
        System.out.println(op.get());
    }


}

class Trader {

    private String name;
    private String city;

    public Trader() {
    }

    public Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Trader [name=" + name + ", city=" + city + "]";
    }
}

class Transaction {

    private Trader trader;
    private int year;
    private int value;

    public Transaction() {
    }

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() {
        return trader;
    }

    public void setTrader(Trader trader) {
        this.trader = trader;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Transaction [trader=" + trader + ", year=" + year + ", value="
                + value + "]";
    }
}