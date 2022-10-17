package cn.simplelife.work._02tcp.server;

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
        while (true){
            try {
                // 1、创建一个服务端对象
                ServerSocket serverSocket = new ServerSocket(8090);
                // 2、侦听客户端的连接，获取和客户端通信的socket对象
                Socket accept = serverSocket.accept();
                // 3、从Socket获取输入流，接收客户端发送的数据
                InputStream inputStream = accept.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String line = null;
                while ((line = reader.readLine()) != null) {
                    if ("".equals(line)) {
                        break;
                    }
                    System.out.println(line);
                }
                // 4、调用Socket对象中的shutdownInput通知客户端数据接收完毕
                accept.shutdownInput();
                // 5、从Socket对象中拿到输出流往客户端发送数据
                OutputStream outputStream = accept.getOutputStream();
                PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(outputStream));
                printWriter.println("你好，浏览器！！");
                printWriter.println("HTTP/1.1 200 OK");
                printWriter.println("Content-Type: text/html;charset=utf-8");
                printWriter.println();
                printWriter.flush();
                // 6、调用Socket对象的shutdownOutput()方法通知客户端数据发送完毕
                accept.shutdownOutput();
                // 7、关闭Socket对象
                accept.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
