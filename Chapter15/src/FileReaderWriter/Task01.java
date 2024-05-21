package FileReaderWriter;

import java.io.*;

// 复制“XXX”到当前项目的testIO文件夹中
public class Task01 {
    public static void main(String[] args) {
        File src = new File("Chapter15\\src\\FROM");
        File dest = new File("Chapter15\\src\\TestIO");
        copyDir(src, dest);
    }
    public static void copyDir(File src, File dest) {
        if (dest.isFile()) {
            throw new RuntimeException(dest + "不是文件夹");
        }
        if (src.isFile()) {
            File destFile = new File(dest.getPath() + "/" + src.getName());
            copyFile(src, destFile);
        } else if (src.isDirectory()) {
            File destFile = new File(dest.getPath() + "/" + src.getName());
            destFile.mkdir();

            File[] listFiles = src.listFiles();
            for (File sub : listFiles) {
                copyDir(sub, destFile);
            }
        }
    }

    public static void copyFile(File srcFile, File destFile) {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            byte[] data = new byte[1024];
            int len;
            while ((len = fis.read(data)) != -1) {
                fos.write(data, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) fis.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (fos != null) fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
