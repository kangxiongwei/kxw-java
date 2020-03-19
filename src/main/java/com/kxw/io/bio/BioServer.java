package com.kxw.io.bio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author kangxiongwei
 * @date 2020-03-03 02:48
 */
public class BioServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(9091));
        while (true) {
            System.out.println("等待连接...");
            final Socket socket = serverSocket.accept();  //阻塞
            System.out.println("连接成功...");
            new Thread() {
                @Override
                public void run() {
                    byte[] bytes = new byte[1024];
                    int read = 0; //阻塞
                    try {
                        read = socket.getInputStream().read(bytes);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (read > 0) {
                        System.out.println(new String(bytes));
                    }
                }
            }.start();
        }
    }



}
