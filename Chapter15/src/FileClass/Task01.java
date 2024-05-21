package FileClass;

import java.io.File;
import java.io.IOException;

public class Task01 {
    public static void main(String[] args) throws IOException {
        // 绝对路径创建文件夹
        File dir = new File("E:\\JavaLearn\\JavaExtensionExercise\\Chapter15\\src\\testIO");
        dir.mkdir();

        // 相对路径创建文件
        File file = new File("Chapter15\\src\\testIO\\1.txt");
        file.createNewFile();
    }
}
