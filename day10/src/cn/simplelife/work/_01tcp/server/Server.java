package cn.simplelife.work._01tcp.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @ClassName Server
 * @Description
 * @Author simplelife
 * @Date 2022/10/17 16:35
 * @Version 1.0
 */

public class Server {
    public static void main(String[] args) {
        try {
            // 1、创建一个服务端对象
            ServerSocket serverSocket = new ServerSocket(8090);
            // 2、侦听客户端的连接，获取和客户端通信的socket对象
            Socket accept = serverSocket.accept();
            // 3、从Socket获取输入流，接收客户端发送的数据
            InputStream inputStream = accept.getInputStream();
            byte[] bytes = new byte[1024];
            int len;
            while ((len = inputStream.read(bytes)) > 0) {
                String s = new String(bytes, 0, len);
                System.out.println(s);
            }
            // 4、调用Socket对象中的shutdownInput通知客户端数据接收完毕
            accept.shutdownInput();
            // 5、从Socket对象中拿到输出流往客户端发送数据
            OutputStream outputStream = accept.getOutputStream();
            outputStream.write("你也好！客户端".getBytes(StandardCharsets.UTF_8));
            // 6、调用Socket对象的shutdownOutput()方法通知客户端数据发送完毕
            accept.shutdownOutput();
            // 7、关闭Socket对象
            accept.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
