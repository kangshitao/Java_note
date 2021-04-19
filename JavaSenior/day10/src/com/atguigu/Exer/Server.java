package com.atguigu.Exer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Kangshitao
 * @date 2021年4月18日 下午4:13
 */
public class Server {
    public static void main(String[] args) {
        new Server().start();
    }

    public void start() {
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            ss = new ServerSocket(9999);
            while (true) {
                socket = ss.accept();
                is = socket.getInputStream();
                int len = 0;
                baos = new ByteArrayOutputStream();
                while ((len = is.read()) != -1) {
                    baos.write(len);
                }
                String message = baos.toString();
                System.out.print("From " + socket.getInetAddress().getHostName() + ": ");
                System.out.println(message);
                socket.getOutputStream().write("-----Message received-----".getBytes());
                socket.shutdownOutput();
                if ("exit".equals(message)) break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ss != null) {
                try { ss.close(); }
                catch (IOException e) { e.printStackTrace(); }
            }
            if (socket != null) {
                try { socket.close(); }
                catch (IOException e) { e.printStackTrace(); }
            }
            if (is != null) {
                try { is.close(); }
                catch (IOException e) { e.printStackTrace(); }
            }
            if (baos != null) {
                try { baos.close(); }
                catch (IOException e) { e.printStackTrace(); }
            }
        }
    }
}