package EnumExp;

import static EnumExp.Data.EQUIPMENTS;

public class Task02 {
    public static void main(String[] args) {
        Equipment[] arr = new Equipment[EQUIPMENTS.length];
        for (int i = 0; i < arr.length; i++) {
            int id = Integer.parseInt(EQUIPMENTS[i][0]);
            String factory = EQUIPMENTS[i][1];
            double price = Double.parseDouble(EQUIPMENTS[i][2]);
            String name = EQUIPMENTS[i][3];
            int value = Integer.parseInt(EQUIPMENTS[i][4]);
            Status status = Status.getByValue(value);
            arr[i] = new Equipment(id,factory,price,name,status);
            System.out.println(arr[i]);
        }
    }
}

enum Status {
    FREE("空闲"),
    USED("在用"),
    SCRAP("报废");

    private final String description;
    private int value;

    Status(String description) {
        this.value = ordinal();
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static Status getByValue(int value) {
        return Status.values()[value];
    }

    @Override
    public String toString() {
        return description;
    }
}

class Equipment {
    private int id;
    private String factory;
    private double price;
    private String name;
    private Status status;

    public Equipment() {
    }

    public Equipment(int id, String factory, double price, String name, Status status) {
        this.id = id;
        this.factory = factory;
        this.price = price;
        this.name = name;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "id=" + id +
                ", factory='" + factory + '\'' +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", status=" + status +
                '}';
    }
}

class Data {
    public static final String[][] EQUIPMENTS = {
            {"1", "联想", "6000", "拯救者","0"},
            {"2", "宏碁 ","5000", "AT7-N52","0"},
            {"3", "小米", "2000", "5V5Pro","1"},
            {"4", "戴尔", "4000", "3800-R33","1"},
            {"5", "苹果", "12000", "MBP15","1"},
            {"6", "华硕", "8000", "K30BD-21寸","2"},
            {"7", "联想", "7000", "YOGA","0"},
            {"8", "惠普", "5800", "X500","2"},
            {"9", "苹果", "4500","2021Pro","0"},
            {"10", "惠普", "5800", "FZ5","1"}
    };
}