package com.nio;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * - ##### Scattering: 将数据写入到Buffer时，可以采用Buffer数组，一次写入（分散
 * - ##### Gathering :从Buffer 读取数据时，可以采用Buffer数组，依次读
 *
 * @author pengwei
 * @date 2020/12/22
 */
public class ScatteringAndGatheringTest {
    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            //NetworkChannel bind(SocketAddress local) throws IOException;
            SocketAddress local = new InetSocketAddress(8000);
            ServerSocketChannel serverSocketChannel1 = serverSocketChannel.bind(local);
            //等待客户端连接
            SocketChannel socketChannel = serverSocketChannel1.accept();

            ByteBuffer byteBuffer = ByteBuffer.allocate(5);
//            ByteBuffer[] byteBuffers = new ByteBuffer[2];
//            byteBuffers[0]=ByteBuffer.allocate(5);
//            byteBuffers[1]=ByteBuffer.allocate(8);

            while (true) {
                long read = socketChannel.read(byteBuffer);
                System.out.println("read:" + read);
//                Arrays.asList(byteBuffers).forEach(byteBuffer -> {
//                    //读写反转
//                    byteBuffer.flip();
//                });
                byteBuffer.flip();
                System.out.println(byteBuffer.array());
                byte[] array = byteBuffer.array();
                System.out.println(new String(array));

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
