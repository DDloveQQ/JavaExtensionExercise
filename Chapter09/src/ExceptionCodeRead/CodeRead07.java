package ExceptionCodeRead;

public class CodeRead07 {
    public static int aMethod(int i) throws Exception{
        try{
            return i / 10;
        }catch(Exception ex){
            throw new Exception("exception in aMethod");
        }finally{
            System.out.println("finally");  // 唯一输出,因为程序没有异常
        }
    }
    public static void main(String[] args) {
        try {
            aMethod(0);
        } catch (Exception e) {
            System.out.println("exception in main");
        }
    }
}
