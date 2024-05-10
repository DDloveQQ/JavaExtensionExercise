package ExceptionCodeRead;

public class CodeRead02 {
    public static void main(String[] args) {
        try{
            return;
        }finally{  // 一定被执行
            System.out.println("finally");
        }
    }
}
