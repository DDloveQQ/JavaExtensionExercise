package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Receiver {
    public static void main(String[] args) {
        DatagramSocket ds = null;
        try {
            // 准备一个socket，用来接收消息
            ds = new DatagramSocket(8888);

            // 准备一个数据报，来接收数据
            byte[] data = new byte[1024 * 64];
            DatagramPacket dp = new DatagramPacket(data, data.length);

            // 接收数据
            ds.receive(dp);

            // 数据拆包
            byte[] result = dp.getData();
            int len = dp.getLength();
            System.out.println(new String(result, 0, len));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ds != null)
                ds.close();
        }
    }
}
