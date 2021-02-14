package com.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author pengwei
 * @date 2020/12/24
 */
public class NIOServer {
    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8100));

        Selector selector = Selector.open();

        //将serverSocketChannel设置为非阻塞模式
        serverSocketChannel.configureBlocking(false);
        //将serverSocketChannel 注册到selector上,并让selector监听SelectionKey 的OP_ACCEPT操作位
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        //循环等待客户端连接
        while (true) {
            if (selector.select(1000) == 0) {
                System.out.println("无连接，等待1s");
                continue;
            }
            //得到所有关注事件的集合，有事件发生的key
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                //根据客户端的key,对应的通道事件做相应处理
                //如果是OP_ACCEPT 表示有新的连接
                if (selectionKey.isAcceptable()) {
                    //生成一个channel ，把它注册到selector上
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    System.out.println("客户端连接成功：hashcode:"+socketChannel.hashCode());
                    socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));

                }
                //OP_READ
                if (selectionKey.isReadable()) {
                    //通过key,反向获取对应的Channel
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    //获取对应的buffer
                    ByteBuffer byteBuffer = (ByteBuffer) selectionKey.attachment();
                    socketChannel.read(byteBuffer);
                    System.out.println("客户端信息：" + new String(byteBuffer.array()));
                }

                //移除当前key
                selectionKeys.remove(selectionKey);

            }

        }

    }
}
