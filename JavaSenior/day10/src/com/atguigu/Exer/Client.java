package com.atguigu.Exer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author Kangshitao
 * @date 2021年4月18日 下午4:13
 */
public class Client {
    public static void main(String[] args) {
        new Client().start();
    }

    public void start() {
        Socket socket = null;
        OutputStream os = null;
        Scanner sc = null;
        ByteArrayOutputStream baos = null;
        while (true) {
            try {
                //1.
                socket = new Socket(InetAddress.getByName("127.0.0.1"), 9999);
                //2.
                os = socket.getOutputStream();
                //3.
                System.out.println("Input message：");
                sc = new Scanner(System.in);
                String message = sc.next();
                os.write(message.getBytes(StandardCharsets.UTF_8));
                socket.shutdownOutput();
                //接收来自服务器的消息
                InputStream is = socket.getInputStream();

                baos = new ByteArrayOutputStream();
                int len = 0;
                while ((len = is.read()) != -1) {
                    baos.write(len);
                }
                System.out.println(baos.toString());

                if ("exit".equals(message)) break;
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (os != null) {
                    try {
                        os.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
