package TCP.Task01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Task01Client {
    public static void main(String[] args) {
        Socket socket = null;
        PrintStream ps = null;
        try {
            // 创建套接字并指定IP和端口
            socket = new Socket("127.0.0.1", 8888);

            // 获取输入流(接受服务端发来的信息)
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(br.readLine());

            // 获取输出流(向服务端发送信息)
            ps = new PrintStream(socket.getOutputStream());
            ps.println("你好,我想报名!");
            System.out.println(br.readLine());
            ps.println("好的,请帮我占座!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null) socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (ps != null) ps.close();
        }
    }
}
