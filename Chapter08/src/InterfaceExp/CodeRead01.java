package InterfaceExp;

interface A{
    int x = 0;
}
class B{
    int x = 1;
}

class CodeRead01 extends B implements A{
    public void printX(){
        System.out.println(A.x);
        System.out.println(new B().x);
    }
    public static void main(String[] args) {
        new CodeRead01().printX();
    }
}