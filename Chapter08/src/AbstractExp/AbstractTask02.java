package AbstractExp;

public class AbstractTask02 {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[3];
        vehicles[0] = new Monocycle(1);
        vehicles[1] = new Bicycle(2);
        vehicles[2] = new Tricycle(3);

        for (Vehicle v : vehicles) {
            System.out.println(v);
            v.drive();
        }
    }
}

abstract class Vehicle {
    private int wheels;

    public Vehicle(int wheels) {
        this.wheels = wheels;

    }

    public abstract void drive();

    @Override
    public String toString() {
        return "wheels=" + wheels;
    }
}

class Monocycle extends Vehicle {

    public Monocycle(int wheels) {
        super(wheels);
    }

    @Override
    public void drive() {
        System.out.println("脚踏独轮车，摇摇摆摆往前走");
    }
}

class Bicycle extends Vehicle {

    public Bicycle(int wheels) {
        super(wheels);
    }

    @Override
    public void drive() {
        System.out.println("脚踏双轮自行车，优哉游哉往前走");
    }
}

class Tricycle extends Vehicle {

    public Tricycle(int wheels) {
        super(wheels);
    }

    @Override
    public void drive() {
        System.out.println("脚踏三轮车，稳稳当当往前走");
    }
}

