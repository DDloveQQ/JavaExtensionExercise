package TCP.Task02;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Task02Client {
    public static void main(String[] args) throws IOException {
        // 连接服务器
        Socket socket = new Socket("127.0.0.1", 8888);

        // 选择要上传的文件
        Scanner input = new Scanner(System.in);
        System.out.println("请选择要上传的文件");
        String fileStr = input.nextLine();
        File file = new File(fileStr);

        if (!fileStr.endsWith(".jpg")) {
            System.out.println("文件必须为jpg格式");
            input.close();
            socket.close();
            return;
        }

        if (file.length() > 1024 * 1024 * 2) {
            System.out.println("照片大小必须小于2M");
            input.close();
            socket.close();
            return;
        }
        DataOutputStream dos = null;
        FileInputStream fis = null;
        try {
            // 获取输出流
            dos = new DataOutputStream(socket.getOutputStream());
            // 先发送文件名
            dos.writeUTF(file.getName().substring(0, file.getName().lastIndexOf(".")));  // 后缀名以前的全部内容
            // 再发送文件内容
            fis = new FileInputStream(file);
            byte[] data = new byte[1024];
            int len;
            while ((len = fis.read(data)) != -1) {
                dos.write(data, 0, len);
            }
            System.out.println("发送完毕!");
            socket.shutdownOutput(); // 告诉服务器已发送完毕
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 接受结果
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String result = br.readLine();
        System.out.println(result);

        br.close();
        socket.close();
        input.close();

    }
}
