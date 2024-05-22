package TCP.Task02;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Task02Server {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;
        DataInputStream dis = null;
        PrintStream ps = null;
        FileOutputStream fos = null;

        try {
            server = new ServerSocket(8888);
            socket = server.accept();
            dis = new DataInputStream(socket.getInputStream());
            ps = new PrintStream(socket.getOutputStream());

            // 读取文件名
            String fileName = dis.readUTF();

            // 生成唯一的文件名
            String destFile = "photo" + "/" + fileName + System.currentTimeMillis() + ".jpg";

            // 读取文件内容并写入目标文件
            fos = new FileOutputStream(destFile);
            try {
                byte[] data = new byte[1024];
                int len;
                while ((len = dis.read(data)) != -1) {
                    fos.write(data, 0, len);
                }
                ps.println("接受成功!");
            } catch (IOException e) {
                ps.println("接受失败!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (ps != null) {
                ps.close();
            }
            try {
                if (dis != null)
                    dis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (socket != null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (server != null)
                    server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
