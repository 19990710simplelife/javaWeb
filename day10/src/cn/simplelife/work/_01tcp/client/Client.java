package cn.simplelife.work._01tcp.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @ClassName Client
 * @Description
 * @Author simplelife
 * @Date 2022/10/17 15:22
 * @Version 1.0
 */

public class Client {
    public static void main(String[] args) {
        try {
            // 1、创建一个连接某个服务器的socket对象
            Socket socket = new Socket("127.0.0.1", 8090);
            // 2、从socket中拿到输出流往服务器发数据
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("您好！服务器".getBytes(StandardCharsets.UTF_8));
            // 3、调用Socket对象的shutdownOutput()方法，通知服务器发送完毕。
            socket.shutdownOutput();
            // 4、从Socket中拿到输入流拿到数据
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len;
            while ((len = inputStream.read(bytes)) > 0) {
                String s = new String(bytes, 0, len);
                System.out.println(s);
            }
            // 5、调用socket对象的shutdownInput()方法，通知服务器数据接收完毕
            socket.shutdownInput();
            // 6、关闭Socket对象
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
