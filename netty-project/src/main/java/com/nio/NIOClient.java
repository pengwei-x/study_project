package com.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author pengwei
 * @date 2020/12/24
 */
public class NIOClient {
    public static void main(String[] args) throws Exception {
        SocketChannel socketChannel = SocketChannel.open();
        //设置成非阻塞
        socketChannel.configureBlocking(false);
        //连接服务器
        boolean connect = socketChannel.connect(new InetSocketAddress("127.0.0.1", 8100));
        if (!connect) {
            while (!socketChannel.finishConnect()) {
                System.out.println("正在连接中，请稍后....");
            }
        }
        String str = "hello .world";
        ByteBuffer byteBuffer = ByteBuffer.wrap(str.getBytes());
        //发送数据
        socketChannel.read(byteBuffer);
        //停止结束
        System.in.read();

    }
}
