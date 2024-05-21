package FileClass;

import java.io.File;
import java.io.IOException;

public class Task02 {
    public static void main(String[] args) {
        test01();
        test02();
        test03();
        test04();
        test05();
    }

    // 检查testIO文件夹下是否存在文件a.txt，如果不存在则创建该文件
    public static void test01() {
        File file = new File("E:\\JavaLearn\\JavaExtensionExercise\\Chapter15\\src\\testIO\\a.txt");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 获取testIO文件夹下的a.txt文件的文件名，文件大小，文件的绝对路径和父路径等信息，并将信息输出在控制台
    public static void test02() {
        File file = new File("Chapter15\\src\\testIO\\a.txt");
        System.out.println("文件名: " + file.getName());
        System.out.println("文件大小: " + file.length());
        System.out.println("文件绝对路径: " + file.getAbsolutePath());
        System.out.println("父路径: " + file.getParent());
    }

    // 判断testIO是否为文件,是文件则输出：xxx是一个文件; 是否文件夹,是文件夹则输出：xxx是一个文件夹
    public static void test03() {
        File file = new File("Chapter15\\src\\testIO");
        if (file.isFile()) {
            System.out.println(file.getName() + "是一个文件");
        } else if (file.isDirectory()) {
            System.out.println(file.getName() + "是一个文件夹");
        } else {
            System.out.println(file.getName() + "啥也不是");
        }
    }

    // 删除testIO文件夹下的a.txt文件
    public static void test04() {
        File file = new File("Chapter15\\src\\testIO\\a.txt");
        file.delete();
    }

    // 删除当前项目下的testIO文件夹下的1.txt文件，然后删除testIO文件夹
    public static void test05() {
        File file = new File("Chapter15\\src\\testIO\\1.txt");
        file.delete();

        File dir = new File("Chapter15\\src\\testIO");
        dir.delete();
    }
}
