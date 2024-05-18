package CustomizeGenerics;

public class Task02 {
    public static void main(String[] args) {
        Person<Person<?>> person = new Person<>("自己", new Person<>("她"));
        System.out.println(person);

        Person<Demon> person1 = new Person<>("许仙", new Demon("白娘子"));
        System.out.println(person1);
    }
}

class Person<T> {
    private String name;
    private T partner;

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, T partner) {
        this.name = name;
        this.partner = partner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getPartner() {
        return partner;
    }

    public void setPartner(T partner) {
        this.partner = partner;
    }

    @Override
    public String toString() {
        if (this.partner != null) {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", partner=" + partner +
                    '}';
        } else {
            return "Person{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}

class Demon {
    private String name;

    public Demon(String name) {
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
        return "Demon{" +
                "name='" + name + '\'' +
                '}';
    }
}