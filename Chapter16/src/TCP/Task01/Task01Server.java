package TCP.Task01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

public class Task01Server {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;
        try {
            server = new ServerSocket(8888);
            socket = server.accept();

            // 获取输出流(向客户传递信息)
            PrintStream ps = new PrintStream(socket.getOutputStream());
            ps.println("欢迎咨询!");

            // 获得输入流(读取客户信息)
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            System.out.println(socket.getInetAddress().getHostAddress() + "留言: " + LocalDateTime.now());
            System.out.println(br.readLine() + "\n");
            ps.println("这个月的所有期班都已经满了，只能报下一个月的了！");
            System.out.println(socket.getInetAddress().getHostAddress() + "留言: " + LocalDateTime.now());
            System.out.println(br.readLine());

        } catch (IOException e) {
           e.printStackTrace();
        } finally {
            try {
                if (socket != null) socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (server != null) server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
