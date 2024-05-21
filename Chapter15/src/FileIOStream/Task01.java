package FileIOStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

// 使用文件字节流复制一个视频文件
public class Task01 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            // 1. 创建流对象
            fis = new FileInputStream("E:\\水下机器人\\1.mp4");
            // 2. 指定复制目的地
            fos = new FileOutputStream("Chapter15\\src\\copy.mp4");
            // 3. 定义读写数据的数值
            byte[] data = new byte[1024];
            // 4. 定义长度
            int len;
            // 5. 循环读取数据
            while ((len = fis.read(data)) != -1) {
                // 6. 写出数据
                fos.write(data, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 7. 关闭资源
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
