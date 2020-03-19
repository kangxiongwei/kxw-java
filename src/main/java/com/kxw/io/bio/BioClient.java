package com.kxw.io.bio;

import java.io.IOException;
import java.net.Socket;

/**
 * @author kangxiongwei
 * @date 2020-03-03 02:49
 */
public class BioClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 9091);
        socket.getOutputStream().write("xxxx".getBytes());
    }

}
