package ExceptionCodeRead;

public class CodeRead06 {
    public static int fun(){
        int result = 5;
        try{
            result = result / 0;  // 除0异常
            return result;
        }catch(Exception e){
            System.out.println("Exception");  // 输出1
            result = -1;
            return result;
        }finally{
            result = 10; // 因为没有return,所以此步骤对后续操作没有影响
            System.out.println("I am in finally.");  // 输出2
        }
    }
    public static void main(String[] args) {
        int x = fun();
        System.out.println(x);  // 输出3 (-1)
    }
}
