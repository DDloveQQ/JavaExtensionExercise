package DataStream;

import java.io.*;

public class Task01 {
    public static void main(String[] args) {
        Serialization();
        Deserialization();
    }

    public static void Serialization() {
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream("data.dat"));

            int a = 10;
            char c = 'a';
            double d = 2.5;
            boolean b = true;
            String str = "尚硅谷";

            dos.writeInt(a);
            dos.writeChar(c);
            dos.writeDouble(d);
            dos.writeBoolean(b);
            dos.writeUTF(str);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (dos != null) dos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void Deserialization() {
        DataInputStream dis = null;
        try {
            dis = new DataInputStream(new FileInputStream("data.dat"));

            System.out.println(dis.readInt());
            System.out.println(dis.readChar());
            System.out.println(dis.readDouble());
            System.out.println(dis.readBoolean());
            System.out.println(dis.readUTF());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (dis != null) dis.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
