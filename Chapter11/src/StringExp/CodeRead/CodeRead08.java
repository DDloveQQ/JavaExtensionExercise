package StringExp.CodeRead;

public class CodeRead08 {
    /*
     * GBK，UTF-8，ISO8859-1所有的字符编码都向下兼容ASCII码
     */
    public static void main(String[] args) throws Exception {
        String str = "中国";
        System.out.println(str.getBytes("ISO8859-1").length);// 2
        // ISO8859-1把所有的字符都当做一个byte处理，处理不了多个字节
        System.out.println(str.getBytes("GBK").length);// 4 每一个中文都是对应2个字节
        System.out.println(str.getBytes("UTF-8").length);// 6 常规的中文都是3个字节

        /*
         * 不乱码：（1）保证编码与解码的字符集名称一样（2）不缺字节
         */
        System.out.println(new String(str.getBytes("ISO8859-1"), "ISO8859-1"));// 乱码
        System.out.println(new String(str.getBytes("GBK"), "GBK"));// 中国
        System.out.println(new String(str.getBytes("UTF-8"), "UTF-8"));// 中国
    }
}
