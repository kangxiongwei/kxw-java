package com.kxw.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * NIO构建服务端
 *
 * @author kangxiongwei
 * @date 2020-03-05 10:10
 */
public class NioServer {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.bind(new InetSocketAddress("localhost", 9092));
        channel.configureBlocking(false);
        Selector selector = Selector.open();
        channel.register(selector, SelectionKey.OP_ACCEPT);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (selector.select() > 0) {
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                iterator.remove();
                if (selectionKey.isAcceptable()) {
                    ServerSocketChannel server = (ServerSocketChannel) selectionKey.channel();
                    //新注册channel
                    SocketChannel socketChannel = server.accept();
                    if (socketChannel == null) {
                        continue;
                    }
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
                }
                //读取数据
                if (selectionKey.isReadable()) {
                    StringBuilder builder = new StringBuilder();
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    buffer.clear();
                    socketChannel.read(buffer);
                    buffer.flip();
                    while (buffer.hasRemaining()) {
                        builder.append((char) buffer.get());
                    }
                    System.out.println(builder.toString());
                    //将读取到的数据绑定到选中的key中
                    selectionKey.attach("接收到数据:" + builder.toString());
                }
                //写入数据
                if (selectionKey.isWritable()) {
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    String response = (String) selectionKey.attachment();
                    if (response == null) {
                        continue;
                    }
                    selectionKey.attach(null);
                    buffer.clear();
                    buffer.put(response.getBytes());
                    buffer.flip();
                    while (buffer.hasRemaining()) {
                        socketChannel.write(buffer);
                    }
                }
            }
        }
        channel.close();
    }


}
