package ConversionStreams;

import java.io.*;

public class Task01 {
    public static void main(String[] args) {
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;

        String srcFile = "Chapter15\\src\\TestIO\\a.txt";
        String destFile = "Chapter15\\src\\TestIO\\b.txt";

        try {
            // 转换输入流，编码方式设置为GBK
            isr = new InputStreamReader(new FileInputStream(srcFile), "GBK");
            // 转换输出流，编码方式设为UTF-8
            osw = new OutputStreamWriter(new FileOutputStream(destFile), "UTF-8");
            // 读写数据
            char[] cbuf = new char[1024];
            int len;
            while ((len = isr.read(cbuf)) != -1) {
                osw.write(cbuf, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (isr != null) isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (osw != null) osw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
