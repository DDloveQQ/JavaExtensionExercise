package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Sender {
    public static void main(String[] args) {
        DatagramSocket ds = null;
        try {
            // 建立一个DatagramSocket
            ds = new DatagramSocket();

            // 准备要发送的数据
            String str = "欢迎光临";
            byte[] data = str.getBytes();

            // 把数据包装成一个数据报
            for (int i = 0; i <= 255; i++) {
                InetAddress ip = InetAddress.getByName("172.20.10." + i);
                int port = 8888;
                DatagramPacket dp = new DatagramPacket(data, data.length, ip, port);
                ds.send(dp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ds != null)
                ds.close();
        }
    }
}
