package ObjectStream;

// 序列化与反序列化

import java.io.*;

public class Task01 {
    public static void main(String[] args) {
        test01();
        test02();
    }

    public static void test01() {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("data.dat"));
            // 待序列化内容
            int a = 10;
            char c = 'a';
            double d = 2.5;
            boolean b = true;
            String str = "尚硅谷";

            oos.writeInt(a);
            oos.writeChar(c);
            oos.writeDouble(d);
            oos.writeBoolean(b);
            oos.writeUTF(str);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null) oos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void test02() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("data.dat"));
            System.out.println(ois.readInt());
            System.out.println(ois.readChar());
            System.out.println(ois.readDouble());
            System.out.println(ois.readBoolean());
            System.out.println(ois.readUTF());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null) ois.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
