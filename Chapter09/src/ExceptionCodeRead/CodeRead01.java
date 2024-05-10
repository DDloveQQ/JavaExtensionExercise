package ExceptionCodeRead;

public class CodeRead01 {
    public static void main(String[] args) {
        int test = test(3,5);
        System.out.println(test);  // 8
    }

    public static int test(int x, int y){
        int result = x;
        try{
            if(x<0 || y<0){
                return 0;
            }
            result = x + y;
            return result;
        }finally{  // final中的代码无论如何一定会执行，但由于没有return,所以会从try中return出去
            result = x - y;
            // return result; 如果加入return,则try中的return失效
        }
    }
}
