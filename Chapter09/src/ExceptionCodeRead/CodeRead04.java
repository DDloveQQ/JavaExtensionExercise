package ExceptionCodeRead;

public class CodeRead04 {
    static int i = 0;
    public static void main(String[] args) {
        System.out.println(test());  // 2
    }

    public static int test(){
        try{
            return ++i;  // 会执行++i,但不会return出去,因为还有finally没有执行
        }finally{
            return ++i;  // 会执行++i,且会return出去
        }
    }
}
