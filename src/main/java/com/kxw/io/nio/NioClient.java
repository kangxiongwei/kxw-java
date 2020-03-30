package com.kxw.io.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Scanner;

/**
 * NIO的客户端
 *
 * @author kangxiongwei
 * @date 2020-03-30 18:23
 */
public class NioClient {

    private final ByteBuffer readBuffer = ByteBuffer.allocate(1024);
    private final ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
    private Selector selector;

    private NioClient() throws Exception {
        SocketChannel channel = SocketChannel.open();
        channel.connect(new InetSocketAddress("localhost", 9092));
        channel.configureBlocking(false);
        selector = Selector.open();
        channel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
    }

    public static void main(String[] args) throws Exception {
        NioClient client = new NioClient();
        new Thread(client::writeBufferData).start();
        client.talk();
    }

    private void writeBufferData() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            synchronized (writeBuffer) {
                writeBuffer.put(line.getBytes());
            }
        }
    }

    private void talk() throws Exception {
        while (selector.select() > 0) {
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                iterator.remove();
                //读数据
                if (selectionKey.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    socketChannel.read(readBuffer);
                    readBuffer.flip();
                    String read = Charset.forName("UTF-8").decode(readBuffer).toString();
                    System.out.println(read);
                    readBuffer.clear();
                }
                //写数据
                if (selectionKey.isWritable()) {
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    synchronized (writeBuffer) {
                        writeBuffer.flip();
                        while (writeBuffer.hasRemaining()) {
                            socketChannel.write(writeBuffer);
                        }
                        writeBuffer.compact();
                    }
                }
            }
        }
    }

}
