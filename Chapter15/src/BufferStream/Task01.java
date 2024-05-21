package BufferStream;

import java.io.*;

public class Task01 {
    public static void main(String[] args) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            // 1. 指定数据源
            FileInputStream fis = new FileInputStream("E:\\水下机器人\\1.mp4");

            // 2. 使用缓冲流包装
            bis = new BufferedInputStream(fis);

            // 3. 指定目的地
            FileOutputStream fos = new FileOutputStream("Chapter15\\src\\TestIO\\copy.mp4");

            // 4. 使用包装流包装
            bos = new BufferedOutputStream(fos);

            // 读写数据
            byte[] data = new byte[1024];
            int len;
            while ((len = bis.read(data)) != -1) {
                bos.write(data, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bos != null) bos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                if (bis != null) bis.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
