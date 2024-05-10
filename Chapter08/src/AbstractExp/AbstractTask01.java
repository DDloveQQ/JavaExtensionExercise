package AbstractExp;

public class AbstractTask01 {
    public static void main(String[] args) {
        numC nc = new numC();
        nc.showA();
        nc.showB();
        nc.showC();
    }
}
abstract class numA {
    public int numa = 10;
    public abstract void showA();
}

abstract class numB extends numA {
    public int numb = 20;
    public abstract void showB();
}

class numC extends numB {
    public int numc = 30;

    @Override
    public void showA() {
        System.out.println(numa);
    }

    @Override
    public void showB() {
        System.out.println(numb);
    }

    public void showC() {
        System.out.println(numc);
    }
}
