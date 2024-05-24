package Optional;

import java.util.Optional;

public class Task01 {

    public static Optional<Girl> getGirlFriend(Boy boy) {
        if (boy == null) return Optional.empty();
        return Optional.ofNullable(boy.getGirlFriend());
    }

    public static void main(String[] args) {
        Boy boy = new Boy("张三", new Girl("翠翠"));
        Girl girl = getGirlFriend(boy).orElse(new Girl("嫦娥"));
        Optional.of(girl).ifPresent(System.out::println);
    }
}
class Girl {
    private String name;

    public Girl(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Girl [name=" + name + "]";
    }

}

class Boy {
    private String name;
    private Girl girlFriend;

    public Boy(String name, Girl girlFriend) {
        super();
        this.name = name;
        this.girlFriend = girlFriend;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Girl getGirlFriend() {
        return girlFriend;
    }

    public void setGirlFriend(Girl girlFriend) {
        this.girlFriend = girlFriend;
    }

    @Override
    public String toString() {
        return "Boy [name=" + name + ", girlFriend=" + girlFriend + "]";
    }
}