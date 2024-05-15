package StringExp.CodeRead;

public class CodeRead02 {
    public static void stringReplace(String text){
        text = text.replace('j','i');
    }
    public static void bufferReplace(StringBuffer text){
        text.append("C"); // 实参受到影响
        text = new StringBuffer("Hello"); // 实参不受影响,因为换成了另一个地址
        text.append("World!");
    }

    public static void main(String[] args) {
        String textString = new String("java");
        StringBuffer textBuffer = new StringBuffer("java");

        stringReplace(textString);  // 数据传参，不影响textString
        bufferReplace(textBuffer);  // 地址传参,会影响textBuffer

        System.out.println(textString + textBuffer);//javajavaC

    }
}
