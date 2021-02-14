package com.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author pengwei
 * @date 2020/12/26
 */
public class NettyServer {
    public static void main(String[] args) {
        //创建BossGroup 和WorkerGroup
        /**
         * BossGroup只是做连接处理，业务处理交个workerGroup
         */
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        //创建服务器端的启动对象，并配置参数
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        try {
            serverBootstrap.group(bossGroup, workerGroup)
                    //使用NioServerSocketChannel 作为服务器的通道实现
                    .channel(NioServerSocketChannel.class)
                    //设置线程队列得到的连接个数
                    .option(ChannelOption.SO_BACKLOG, 128)
                    //创建一个通道测试对象（匿名）
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        /**
                         * 给socketChannel 设置处理器 （自定义）
                         *
                         * @param socketChannel
                         * @throws Exception
                         */
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(NettyServerHandler.class.newInstance());
                        }
                    });
            System.out.println(" 服务器 ready .....");

            try {
                ChannelFuture channelFuture = serverBootstrap.bind(8000).sync();
                //featur--Listener机制
                channelFuture.addListener(new ChannelFutureListener() {
                    @Override
                    public void operationComplete(ChannelFuture channelFuture) throws Exception {
                        if(channelFuture.isSuccess()){
                            System.out.println("端口绑定成功！");
                        }else {
                            System.out.println("端口绑定失败！");
                        }
                    }
                });
                //给关闭通道进行监听
                channelFuture.channel().closeFuture().sync();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally { //这里异常已经交给自定义NettySeverHanlder了
            //关闭
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }


    }
}
